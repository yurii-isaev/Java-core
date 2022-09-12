package repositories

import (
	"fmt"

	"github.com/jmoiron/sqlx"

	"e-commerce/internal/entities"
	. "e-commerce/internal/storage/configs"
)

type AuthPostgres struct {
	db *sqlx.DB
}

func NewAuthPostgres(db *sqlx.DB) *AuthPostgres {
	return &AuthPostgres{db: db}
}

func (s *AuthPostgres) CreateUser(user entities.User) (int, error) {
	var id int
	query := fmt.Sprintf(
		`INSERT INTO %s (firstname, lastname, email, password_hash)
       VALUES ($1, $2, $3, $4) RETURNING id`, UsersTable)

	row := s.db.QueryRow(query, user.Firstname, user.Lastname, user.Email, user.Password)
	if err := row.Scan(&id); err != nil {
		return 0, err
	}

	return id, nil
}

func (s *AuthPostgres) ReadUser(email, password string) (entities.User, error) {
	var user entities.User

	query := fmt.Sprintf(
		`SELECT id
       FROM %s WHERE email=$1 AND password_hash=$2`, UsersTable)
	err := s.db.Get(&user, query, email, password)

	return user, err
}

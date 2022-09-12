package entities

// User model
// @Description Account registration model
type User struct {
	Id        int    `json:"-"        db:"id"`
	Firstname string `json:"name"     binding:"required"`
	Lastname  string `json:"username" binding:"required"`
	Email     string `json:"email"    binding:"required"`
	Password  string `json:"password" binding:"required"`
}

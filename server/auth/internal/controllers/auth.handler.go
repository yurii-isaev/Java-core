package controllers

import (
	"net/http"

	"github.com/gin-gonic/gin"

	"e-commerce/internal/entities"
	"e-commerce/internal/usecases/common/dto"
)

// @Summary SignUp
// @Tags auth
// @Description create account
// @ID create-account
// @Accept  json
// @Produce json
// @Success 200 {integer} integer 1
// @Failure 400,404 {object} errorResponse
// @Failure 500 {object} errorResponse
// @Failure default {object} errorResponse
// @Router /auth/sign-up [post]
func (router *Router) SignUp(c *gin.Context) {
	var input entities.User

	// Input validation check.
	if err := c.BindJSON(&input); err != nil {
		dto.NewErrorResponse(c, http.StatusBadRequest, "invalid input body")
		return
	}

	// Registration result check.
	response, err := router.service.Registration(input)
	if err != nil {
		dto.NewErrorResponse(c, http.StatusInternalServerError, err.Error())
		return
	}

	// Return response string.
	c.JSON(http.StatusOK, response)
}

// @Summary SignIn
// @Tags auth
// @Description login
// @ID login
// @Accept json
// @Produce json
// @Param input body Login true "credentials"
// @Success 200 {string} string "token"
// @Failure 400,404 {object} errorResponse
// @Failure 500 {object} errorResponse
// @Failure default {object} errorResponse
// @Router /auth/sign-in [post]
func (router *Router) SignIn(c *gin.Context) {
	var input entities.Login

	// Input validation check.
	if err := c.BindJSON(&input); err != nil {
		dto.NewErrorResponse(c, http.StatusBadRequest, err.Error())
		return
	}

	// Token generate result check.
	token, err := router.service.GenerateToken(input.Username, input.Password)
	if err != nil {
		dto.NewErrorResponse(c, http.StatusInternalServerError, err.Error())
		return
	}

	// Return string JWT.
	c.JSON(http.StatusOK, map[string]interface{}{
		"token": token,
	})
}

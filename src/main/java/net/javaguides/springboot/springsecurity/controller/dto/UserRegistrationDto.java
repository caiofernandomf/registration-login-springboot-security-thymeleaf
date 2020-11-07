package net.javaguides.springboot.springsecurity.controller.dto;

import javax.validation.constraints.AssertTrue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import net.javaguides.springboot.springsecurity.constraint.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})

public class UserRegistrationDto {
    
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @Email
    @NotEmpty
    private String email;
    @Email
    @NotEmpty
    private String confirmEmail;
    @AssertTrue
    private Boolean terms;


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return this.confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean isTerms() {
        return this.terms;
    }

    public Boolean getTerms() {
        return this.terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

}
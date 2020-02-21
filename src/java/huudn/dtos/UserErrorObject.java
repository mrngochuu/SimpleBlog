/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.dtos;

import java.io.Serializable;

/**
 *
 * @author ngochuu
 */
public class UserErrorObject implements Serializable {
    private String emailError, fullnameError, passwordError, confirmError, duplicationError, loginError, domainError;

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }
    
    public String getDuplicationError() {
        return duplicationError;
    }

    public void setDuplicationError(String duplicationError) {
        this.duplicationError = duplicationError;
    }

    public UserErrorObject() {
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getDomainError() {
        return domainError;
    }

    public void setDomainError(String domainError) {
        this.domainError = domainError;
    }
    
}

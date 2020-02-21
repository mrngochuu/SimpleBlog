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
public class CodeDTO implements Serializable {
    private String email;
    private int codeNum;

    public CodeDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }
    
}

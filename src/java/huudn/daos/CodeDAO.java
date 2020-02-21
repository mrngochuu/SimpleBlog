/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.CodeDTO;
import huudn.utils.DatabaseUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngochuu
 */
public class CodeDAO implements Serializable {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if(rs != null) rs.close();
        if(pstm != null) pstm.close();
        if(conn != null) conn.close();
    }
    
    public boolean storeCode(CodeDTO codeDTO) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "INSERT INTO tblCodes(email, codeNum) VALUES(?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, codeDTO.getEmail());
                pstm.setInt(2, codeDTO.getCodeNum());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateCode(CodeDTO codeDTO) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "UPDATE tblCodes SET codeNum = ? WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, codeDTO.getCodeNum());
                pstm.setString(2, codeDTO.getEmail());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteCode(CodeDTO codeDTO) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "DELETE FROM tblCodes WHERE email = ? AND codeNum = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, codeDTO.getEmail());
                pstm.setInt(2, codeDTO.getCodeNum());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean checkExisted(String email) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT email FROM tblCodes WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, email);
                rs = pstm.executeQuery();
                check = rs.next();
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}

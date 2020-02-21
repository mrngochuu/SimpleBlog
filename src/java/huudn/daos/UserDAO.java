/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.UserDTO;
import huudn.utils.DatabaseUtils;
import huudn.utils.PasswordUtils;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 *
 * @author ngochuu
 */
public class UserDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int checkEmailExisted(String email) throws ClassNotFoundException, SQLException {
        int statusID = 0;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT statusID FROM tblUsers WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, email);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    statusID = rs.getInt("statusID");
                }
            }
        } finally {
            closeConnection();
        }
        return statusID;
    }

    public boolean registerAccount(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers(Name, StatusID, Email, Password, RoleID) VALUES (?, ?, ?, ?, ?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userDTO.getName());
                pstm.setInt(2, userDTO.getStatusID());
                pstm.setString(3, userDTO.getEmail());
                pstm.setString(4, PasswordUtils.hashPassword(userDTO.getPassword()));
                pstm.setInt(5, userDTO.getRoleID());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAccount(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET Name = ?, StatusID = ?, Password = ?, RoleID = ? WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userDTO.getName());
                pstm.setInt(2, userDTO.getStatusID());
                pstm.setString(3, PasswordUtils.hashPassword(userDTO.getPassword()));
                pstm.setInt(4, userDTO.getRoleID());
                pstm.setString(5, userDTO.getEmail());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateStatusAccount(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET StatusID = ? WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, userDTO.getStatusID());
                pstm.setString(2, userDTO.getEmail());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public UserDTO checkLogin(String email, String password, int statusID) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        UserDTO userDTO = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT name, roleID FROM tblUsers WHERE email = ? AND password = ? AND statusID = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, email);
                pstm.setString(2, PasswordUtils.hashPassword(password));
                pstm.setInt(3, statusID);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    userDTO = new UserDTO();
                    userDTO.setEmail(email);
                    userDTO.setName(rs.getString("name"));
                    userDTO.setStatusID(statusID);
                    userDTO.setRoleID(rs.getInt("roleID"));
                }
            }
        } finally {
            closeConnection();
        }
        return userDTO;
    }

    public Hashtable<String, String> searchByName(String name) throws ClassNotFoundException, SQLException {
        Hashtable<String, String> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT email, name FROM tblUsers WHERE name LIKE ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + name + "%");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new Hashtable<>();
                    }
                    list.put(rs.getString("email"), rs.getString("name"));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public UserDTO getNameByEmail(String email) throws ClassNotFoundException, SQLException {
        UserDTO dto = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT name FROM tblUsers WHERE email = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, email);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    dto = new UserDTO();
                    dto.setEmail(email);
                    dto.setName(rs.getString("name"));
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.RoleDTO;
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
public class RoleDAO implements Serializable {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if(rs != null) rs.close();
        if(pstm != null) pstm.close();
        if(conn != null) conn.close();
    }
    
    public RoleDTO getObjectByName(String roleName) throws ClassNotFoundException, SQLException {
        RoleDTO roleDTO = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT roleID FROM tblRoles WHERE roleName = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, roleName);
                rs = pstm.executeQuery();
                if(rs.next()) {
                    roleDTO = new RoleDTO();
                    roleDTO.setRoleID(rs.getInt("roleID"));
                    roleDTO.setRoleName(roleName);
                }
            }
        } finally {
            closeConnection();
        }
        return roleDTO;
    }
    
    public RoleDTO getObjectByID(int roleID) throws ClassNotFoundException, SQLException {
        RoleDTO roleDTO = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT roleName FROM tblRoles WHERE roleID = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, roleID);
                rs = pstm.executeQuery();
                if(rs.next()) {
                    roleDTO = new RoleDTO();
                    roleDTO.setRoleID(roleID);
                    roleDTO.setRoleName(rs.getString("roleName"));
                }
            }
        } finally {
            closeConnection();
        }
        return roleDTO;
    }
}

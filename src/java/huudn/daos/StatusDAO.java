/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.StatusDTO;
import huudn.utils.DatabaseUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngochuu
 */
public class StatusDAO implements Serializable {
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
    
    public StatusDTO getObjectByName(String statusName) throws ClassNotFoundException, SQLException {
        StatusDTO dto = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT statusID FROM tblStatuses WHERE statusName = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, statusName);
                rs = pstm.executeQuery();
                if(rs.next()) {
                    dto = new StatusDTO();
                    dto.setStatusID(rs.getInt("statusID"));
                    dto.setStatusName(statusName);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List<StatusDTO> getAllStatus() throws ClassNotFoundException, SQLException {
        List<StatusDTO> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT statusID, statusName FROM tblStatuses";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while(rs.next()) {
                    if(list == null) {
                        list = new ArrayList<>();
                    }
                    StatusDTO dto = new StatusDTO();
                    dto.setStatusID(rs.getInt("statusID"));
                    dto.setStatusName(rs.getString("statusName"));
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}

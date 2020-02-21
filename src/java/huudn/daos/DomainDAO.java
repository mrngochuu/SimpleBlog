/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.DomainDTO;
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
public class DomainDAO implements Serializable {
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
    
    public boolean checkDomain(String domainName) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT domainID FROM tblDomains WHERE domainName = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, domainName);
                rs = pstm.executeQuery();
                check = rs.next();
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<DomainDTO> getDomail() throws SQLException, ClassNotFoundException {
        List<DomainDTO> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT domainName FROM tblDomains";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while(rs.next()) {
                    if(list == null) {
                        list = new ArrayList<>();
                    }
                    DomainDTO dto = new DomainDTO();
                    dto.setDomainName(rs.getString("domainName"));
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}

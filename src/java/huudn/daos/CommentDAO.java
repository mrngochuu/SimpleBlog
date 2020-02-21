/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.CommentDTO;
import huudn.utils.DatabaseUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ngochuu
 */
public class CommentDAO implements Serializable {

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

    public List<CommentDTO> getListComment(int articleID) throws ClassNotFoundException, SQLException {
        List<CommentDTO> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "SELECT commentID, content, commentDate, email FROM tblComments WHERE articleID = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, articleID);
                rs = pstm.executeQuery();
                while(rs.next()) {
                    if(list == null) {
                        list = new ArrayList<>();
                    }
                    CommentDTO dto = new CommentDTO();
                    dto.setCommentID(rs.getInt("commentID"));
                    dto.setCommentDate(new Date(rs.getDate("commentDate").getTime()));
                    dto.setContent(rs.getString("content"));
                    dto.setArticleID(articleID);
                    dto.setEmail(rs.getString("email"));
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean commentArticle(CommentDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if(conn != null) {
                String sql = "INSERT INTO tblComments(content, commentDate, articleID, email) VALUES (?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, dto.getContent());
                pstm.setDate(2, new java.sql.Date(dto.getCommentDate().getTime()));
                pstm.setInt(3, dto.getArticleID());
                pstm.setString(4, dto.getEmail());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}

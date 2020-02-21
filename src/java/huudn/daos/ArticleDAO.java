/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.daos;

import huudn.dtos.ArticleDTO;
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
public class ArticleDAO implements Serializable {

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

    public List<ArticleDTO> searchArticleByContent(String txtSearch, int statusID, int pageNum, int recordNum) throws ClassNotFoundException, SQLException {
        List<ArticleDTO> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT articleID, title, description, email, postingDate FROM tblArticles WHERE content LIKE ? AND statusID = ? ORDER BY postingDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + txtSearch + "%");
                pstm.setInt(2, statusID);
                pstm.setInt(3, (pageNum - 1) * recordNum);
                pstm.setInt(4, recordNum);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO();
                    dto.setArticleID(rs.getInt("articleID"));
                    dto.setTitle(rs.getString("title"));
                    dto.setDescription(rs.getString("description"));
                    dto.setEmail(rs.getString("email"));
                    dto.setPostingDate(new Date(rs.getDate("postingDate").getTime()));
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int getTotalRow(String txtSearch, String email, int statusID) throws SQLException, ClassNotFoundException {
        int total = 0;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT(articleID) AS total FROM tblArticles WHERE content LIKE ? ";
                if (!email.isEmpty()) {
                    sql += "AND email LIKE '%" + email + "%' ";
                }

                if (statusID != 0) {
                    sql += "AND statusID = " + statusID;
                }
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + txtSearch + "%");
                rs = pstm.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("total");
                }
            }
        } finally {
            closeConnection();
        }
        return total;
    }

    public ArticleDTO getDetailsArticle(int articleID, int statusID) throws ClassNotFoundException, SQLException {
        ArticleDTO dto = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT title, description, content, postingDate, email, statusID FROM tblArticles WHERE articleID = ? ";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, articleID);
                if(statusID != 0) {
                    sql += "AND statusID = " + statusID;
                }
                rs = pstm.executeQuery();
                if (rs.next()) {
                    dto = new ArticleDTO();
                    dto.setArticleID(articleID);
                    dto.setTitle(rs.getString("title"));
                    dto.setDescription(rs.getString("description"));
                    dto.setContent(rs.getString("content"));
                    dto.setStatusID(rs.getInt("statusID"));
                    dto.setEmail(rs.getString("email"));
                    dto.setPostingDate(new Date(rs.getDate("postingDate").getTime()));
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean postArticle(ArticleDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblArticles (title, description, content, postingDate, statusID, email) VALUES (?,?,?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, dto.getTitle());
                pstm.setString(2, dto.getDescription());
                pstm.setString(3, dto.getContent());
                pstm.setDate(4, new java.sql.Date(dto.getPostingDate().getTime()));
                pstm.setInt(5, dto.getStatusID());
                pstm.setString(6, dto.getEmail());
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<ArticleDTO> searchArticleForAdmin(String txtSearch, String emailStr, int statusID, int pageNum, int recordNum) throws ClassNotFoundException, SQLException {
        List<ArticleDTO> list = null;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT articleID, title, description, postingDate, email,statusID FROM tblArticles WHERE content LIKE ? ";
                
                //split emailStr up
                if (!emailStr.isEmpty()) {
                    String[] temp = emailStr.split("&");
                    sql += " AND (email = '" + temp[0] + "' ";
                    
                    for(int i = 1; i < temp.length; i++) {
                        sql += "OR email = '" + temp[i] + "' ";
                    }
                    sql += ") ";
                }

                //if statusID == 0, sql does not contain status
                //else status fills it
                if (statusID != 0) {
                    sql += "AND statusID = " + statusID + " ";
                }
                
                //order by date
                sql += "ORDER BY postingDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + txtSearch + "%");
                pstm.setInt(2, (pageNum - 1) * recordNum);
                pstm.setInt(3, recordNum);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO();
                    dto.setArticleID(rs.getInt("articleID"));
                    dto.setTitle(rs.getString("title"));
                    dto.setDescription(rs.getString("description"));
                    dto.setEmail(rs.getString("email"));
                    dto.setStatusID(rs.getInt("statusID"));
                    dto.setPostingDate(new Date(rs.getDate("postingDate").getTime()));
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
   public boolean updateStatusArticle(int articleID, int statusID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            conn = DatabaseUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblArticles SET statusID = ? WHERE articleID = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, statusID);
                pstm.setInt(2, articleID);
                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}

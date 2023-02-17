package com.proj1.Databases;

import com.proj1.Entities.Category;
import com.proj1.Entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Post_database {
    
    Connection con;
    
    public Post_database(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Category> getCategory() {
        ArrayList<Category> list = new ArrayList<>();
        
        try {
            String query = "select * from category";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) {
                
                int cid = set.getInt("cid");
                String name = set.getString("Name");
                String description = set.getString("description");
                
                Category cat = new Category(cid, name, description);
                
                list.add(cat);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean savePost(Post p) {
        boolean f = false;
        
        try {
            String query = "insert into post(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, p.getpTitle());
            stmt.setString(2, p.getpContent());
            stmt.setString(3, p.getpCode());
            stmt.setString(4, p.getpPic());
            stmt.setInt(5, p.getCatId());
            stmt.setInt(6, p.getUserId());
            stmt.executeUpdate();
            
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
        
    }
    
    public ArrayList<Post> getAllPosts() {
        
        ArrayList<Post> list = new ArrayList<>();
        
        try {
            String query = "select * from post";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) {
                
                int pid = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int catId = set.getInt("catId");
                int userId = set.getInt("userId");
                
                Post p = new Post(pid, pTitle, pContent, pCode, pDate, pPic, catId, userId);
                
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Post> getPostsByCatid(int CatId) {
        ArrayList<Post> list = new ArrayList<>();
        
        try {
            String query = "select * from post where catId = ?";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, CatId);
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) {
                
                int pid = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int catId = set.getInt("catId");
                int userId = set.getInt("userId");
                
                Post p = new Post(pid, pTitle, pContent, pCode, pDate, pPic, catId, userId);
                
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Post getPost(int postid) {
        
        Post p = null;
        try {
            String query = "select * from post where pid=?";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            
            stmt.setInt(1, postid);
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) {
                
                int pid = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int catId = set.getInt("catId");
                int userId = set.getInt("userId");
                
                p = new Post(pid, pTitle, pContent, pCode, pDate, pPic, catId, userId);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
}

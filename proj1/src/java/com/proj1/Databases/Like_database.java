package com.proj1.Databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Like_database {

    Connection con;

    public Like_database(Connection con) {
        this.con = con;
    }

    public boolean insertLike(int uid, int pid) {
        boolean f = false;
        try {
            PreparedStatement stmt = this.con.prepareStatement("insert into likes(pid,uid) values(?,?)");
            stmt.setInt(1, pid);
            stmt.setInt(2, uid);

            stmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public int countLike(int pid) {
        int total_like = 0;
        try {
            PreparedStatement stmt = this.con.prepareStatement("select count(*) from likes where pid = ?");

            stmt.setInt(1, pid);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                total_like = set.getInt("count(*)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total_like;
    }

    public boolean checkLike(int uid, int pid) {

        boolean f = false;

        try {
            PreparedStatement stmt = this.con.prepareStatement("select * from likes where pid=? and uid=?");

            stmt.setInt(1, pid);
            stmt.setInt(2, uid);

            ResultSet set = stmt.executeQuery();

            if (set.next()) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean dislike(int pid, int uid) {
        boolean f = false;

        try {
            PreparedStatement stmt = this.con.prepareStatement("delete * from where pid=? and uid=?");

            stmt.setInt(1, pid);
            stmt.setInt(2, uid);

            stmt.executeUpdate();

            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}

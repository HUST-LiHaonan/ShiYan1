/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: ScoreDao
 * Author:   mac
 * Date:     2018/11/25 10:09 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dao;

import beans.Score;
import beans.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static dao.GeneralTool.getConnection;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mac
 * @create 2018/11/25
 * @since 1.0.0
 */
public class ScoreDao {
    private Connection conn = null;
    private PreparedStatement pStat = null;
    private ResultSet rs = null;

    //关闭数据库连接
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pStat != null) {
                pStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加成绩
    public boolean addScore(Score score) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("insert into score values(?,?)");
            pStat.setString(1, score.getId());
            pStat.setInt(2, score.getScore());
            int cnt = pStat.executeUpdate();
            if (cnt > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            close();
        }
    }

    //删除成绩
    public boolean deleteScore(Score score) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("delete from score where id=?");
            pStat.setString(1, score.getId());
            int cnt = pStat.executeUpdate();
            if (cnt > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            close();
        }
    }

    //修改成绩
    public boolean updateScore(Score score){
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("update score set score=? where id=?");
            pStat.setInt(1,score.getScore());
            pStat.setString(2,score.getId());
            int cnt = pStat.executeUpdate();
            if(cnt>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
        finally {
            close();
        }
    }

    //查找成绩(按照学号查找)
    public Score findScore(String id){
        conn = getConnection();
        try {
            Score score = new Score();
            pStat = conn.prepareStatement("select * from score where id=?");
            pStat.setString(1,id);
            rs = pStat.executeQuery();
            if(rs.next()){
                score.setId(rs.getString(1));
                score.setScore(rs.getInt(2));
                return score;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
        finally {
            close();
        }
    }

}


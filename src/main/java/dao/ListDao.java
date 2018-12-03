/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: ListDao
 * Author:   mac
 * Date:     2018/11/25 11:19 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dao;

import beans.ScoreList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static dao.GeneralTool.getConnection;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mac
 * @create 2018/11/25
 * @since 1.0.0
 */
public class ListDao {
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
    //查找所有成绩信息
    public ArrayList <ScoreList> findAll() {
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist order by id");
            rs = pStat.executeQuery();
            while (rs.next()) {
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }
    //按照姓名查找
    public ArrayList<ScoreList> find(String name){
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist where name=?");
            pStat.setString(1,name);
            rs = pStat.executeQuery();
            while (rs.next()) {
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }
    //按照范围查找
    public ArrayList<ScoreList> find(int low,int high){
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist where score>=? and score<=?");
            pStat.setInt(1,low);
            pStat.setInt(2,high);
            rs = pStat.executeQuery();
            while (rs.next()) {
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }

    //全查询
    public ArrayList<ScoreList> find(String name,int low,int high){
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist where score>=? and score<=? and name=?");
            pStat.setInt(1,low);
            pStat.setInt(2,high);
            pStat.setString(3,name);
            rs = pStat.executeQuery();
            while (rs.next()) {
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }

    //升序查询
    public ArrayList <ScoreList> findAllAsc() {
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist order by score asc");
            rs = pStat.executeQuery();
            while (rs.next()){
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }

    //降序查询
    public ArrayList <ScoreList> findAllDesc() {
        ArrayList <ScoreList> List = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from scorelist order by score desc ");
            rs = pStat.executeQuery();
            while (rs.next()) {
                ScoreList scoreList = new ScoreList();
                scoreList.setId(rs.getString(1));
                scoreList.setName(rs.getString(2));
                scoreList.setScore(rs.getInt(3));
                List.add(scoreList);
            }
            return List;
        } catch (Exception e) {
            return List;
        } finally {
            close();
        }
    }
}


/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: StudentDao
 * Author:   mac
 * Date:     2018/11/25 9:49 PM
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
public class StudentDao {
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

    //判断学号是否存在
    public boolean isIdExists(String id) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from student where id=?");
            pStat.setString(1, id);
            rs = pStat.executeQuery();
            if (rs.next()) {
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

    //查找学生(登录判读)
    public Student findStudent(String id, String psd) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from student where id=? and psd=?");
            pStat.setString(1, id);
            pStat.setString(2, psd);
            rs = pStat.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setPsd(rs.getString(3));
                return student;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            close();
        }
    }

    //添加学生
    public boolean addStudent(Student student) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("insert into student values(?,?,?)");
            pStat.setString(1, student.getId());
            pStat.setString(2, student.getName());
            pStat.setString(3, student.getPsd());
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

    //修改学生信息
    public boolean updateStudent(Student student, String id) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("update student set id=?,name=?,psd=? where id=?");
            pStat.setString(1, student.getId());
            pStat.setString(2, student.getName());
            pStat.setString(3, student.getPsd());
            pStat.setString(4, id);
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

    //删除学生信息
    public boolean deleteStudent(Student student) {
        ScoreDao scoreDao = new ScoreDao();
        Score score = scoreDao.findScore(student.getId());
        conn = getConnection();
        if (scoreDao.deleteScore(score)) {
            try {
                pStat = conn.prepareStatement("delete from student where id= ?");
                pStat.setString(1, student.getId());
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
        } else {
            return false;
        }
    }
    //查找全部学生
    public ArrayList <Student> findAll() {
        ArrayList <Student> students = new ArrayList <>();
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from student;");
            rs = pStat.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setPsd(rs.getString(3));
                students.add(student);
            }
            return students;
        }catch (Exception e){
            return null;
        }finally {
            close();
        }
    }
    //查找学生
    public Student findStudent(String id) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from student where id=?");
            pStat.setString(1, id);
            rs = pStat.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setPsd(rs.getString(3));
                return student;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            close();
        }
    }
}


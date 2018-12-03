/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: AdminDao
 * Author:   mac
 * Date:     2018/11/22 10:55 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static dao.GeneralTool.getConnection;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mac
 * @create 2018/11/22
 * @since 1.0.0
 */
public class AdminDao {
    private Connection conn = null;
    private PreparedStatement pStat = null;
    private ResultSet rs = null;


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

    public boolean isAdminExists(String username) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from admin where username=?");
            pStat.setString(1, username);
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

    public boolean findAdmin(String username, String password) {
        conn = getConnection();
        try {
            pStat = conn.prepareStatement("select * from admin where username=? and psd=?");
            pStat.setString(1, username);
            pStat.setString(2, password);
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
}


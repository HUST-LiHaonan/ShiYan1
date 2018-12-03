/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: GeneralTool
 * Author:   mac
 * Date:     2018/11/25 9:46 PM
 * Description: 数据库通用类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据库通用类〉
 *
 * @author mac
 * @create 2018/11/25
 * @since 1.0.0
 */
public class GeneralTool {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/ShiYan";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123";
    private Connection conn = null;
    private PreparedStatement pStat = null;
    private ResultSet rs = null;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER).newInstance();
            return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (Exception e) {
            return null;
        }
    }

}


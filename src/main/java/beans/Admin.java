/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: Admin
 * Author:   mac
 * Date:     2018/11/22 10:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package beans;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/22
 * @since 1.0.0
 */
public class Admin {
    private String username;
    private String psd;

    public Admin(){
        username="";
        psd="";
    }

    public Admin(String username, String psd) {
        this.username = username;
        this.psd = psd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}


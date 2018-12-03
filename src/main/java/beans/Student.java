/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: Student
 * Author:   mac
 * Date:     2018/11/25 9:50 PM
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
 * @create 2018/11/25
 * @since 1.0.0
 */
public class Student {
    private String  id;
    private String name;
    private String psd;

    public Student(){
        id="";
        name="";
        psd="";
    }

    public Student(String id, String name, String psd) {
        this.id = id;
        this.name = name;
        this.psd = psd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}


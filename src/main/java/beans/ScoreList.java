/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: ScoreList
 * Author:   mac
 * Date:     2018/11/25 11:16 PM
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
public class ScoreList {
    private String  id;
    private String name;
    private int score;

    public ScoreList() {
        id = "";
        name = "";
        score = 0;
    }

    public ScoreList(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", score=" + score +
                        '}';
    }
}


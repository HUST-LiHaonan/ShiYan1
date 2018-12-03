/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: Score
 * Author:   mac
 * Date:     2018/11/25 10:08 PM
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
public class Score {
    private String id;
    private int score;

    public Score(){
        id="";
        score=0;
    }

    public Score(String id, int score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


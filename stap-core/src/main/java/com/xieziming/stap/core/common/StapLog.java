package com.xieziming.stap.core.common;

import java.util.Date;

/**
 * Created by Suny on 5/9/16.
 */
public class StapLog {
    private String level;
    private String content;
    private Date time;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

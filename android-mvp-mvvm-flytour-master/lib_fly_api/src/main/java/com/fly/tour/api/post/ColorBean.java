package com.fly.tour.api.post;

import java.io.Serializable;

public class ColorBean implements Serializable {


    /**
     * start : 43
     * end : 53
     * type : 1
     * yes : 0
     * url : /n/%E6%B1%9F%E5%8D%93%E5%B0%94_%E8%8E%B1%E6%AF%94%E7%89%B9%E7%9F%BF%E6%B1%A0
     */

    private int start;
    private int end;
    private int type;
    private int yes;
    private String url;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.yx.utils;

/**
 * User: LiWenC
 * Date: 16-9-5
 */
public enum App {
    qq(1, "20160201"), wx(2, "20160105");

    private int id;
    private String time;

    private App(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

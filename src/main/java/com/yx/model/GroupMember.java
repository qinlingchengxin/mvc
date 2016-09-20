package com.yx.model;

import org.msgpack.annotation.Message;

/**
 * User: LiWenC
 * Date: 16-9-20
 */
@Message
public class GroupMember {
    private String phone;
    private String openid;
    private int areaCode = 0;
    private long uid;
    private String name;
    private String icon;

    public GroupMember() {
    }

    public GroupMember(String tel, String openid, int areaCode, long uid, String name, String icon) {
        this.phone = tel;
        this.openid = openid;
        this.areaCode = areaCode;
        this.uid = uid;
        this.name = name;
        this.icon = icon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "phone='" + phone + '\'' +
                ", openid='" + openid + '\'' +
                ", areaCode=" + areaCode +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

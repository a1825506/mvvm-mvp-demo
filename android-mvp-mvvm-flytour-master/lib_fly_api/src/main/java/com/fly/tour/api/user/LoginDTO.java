package com.fly.tour.api.user;

import com.fly.tour.api.user.entity.User;
/**
 * Description: <LoginDTO><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public class LoginDTO {
    private String user_uuid;

    private String head_img;

    private String notice;

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}

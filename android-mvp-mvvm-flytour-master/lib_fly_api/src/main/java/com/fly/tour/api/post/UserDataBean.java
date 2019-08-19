package com.fly.tour.api.post;

import java.io.Serializable;

/**
 * 社区用户实体
 */
public class UserDataBean implements Serializable {


    /**
     * id : 1
     * user_uuid : 111
     * name : 测试用户
     * mobile : 17211112222
     * role : 1
     * reg_source : 0
     * title : 资深自媒体
     * create_time : 2019-05-29 17:25:17
     * group_id : 0
     * emailstatus : 0
     * email : null
     * credits : 0
     * newpm : null
     * newprompt : null
     * head_img : http://portrait5.sinaimg.cn/6283658508/blog/180
     * onlyacceptfriendpm : null
     */


    private String user_uuid;
    private String name;
    private String title;
    private String head_img;
    private String des;
    private int is_my_follow;


    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getIs_my_follow() {
        return is_my_follow;
    }

    public void setIs_my_follow(int is_my_follow) {
        this.is_my_follow = is_my_follow;
    }
}

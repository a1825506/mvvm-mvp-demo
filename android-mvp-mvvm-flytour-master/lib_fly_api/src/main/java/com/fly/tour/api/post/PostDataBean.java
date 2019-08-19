package com.fly.tour.api.post;
import java.io.Serializable;
import java.util.List;

/**
 * 论坛-帖子数据实体
 */
public class PostDataBean implements Serializable {


    /**
     * post_uuid : 11111
     * type : 1
     * cate : 1
     * user_id : 1
     * pic : ['http://portrait5.sinaimg.cn/6283658508/blog/180','http://portrait5.sinaimg.cn/6283658508/blog/180']
     * content : 测试数据测试@aaa测试xxx
     * create_time : 3分钟前
     * count_comment : 0
     * count_like : 0
     * count_follow : 0
     * show_type : 1
     */
    private List<ColorBean> discoloration;
    private String title;
    private String post_uuid;
    private String type;
    private String cate;
    private List<String> pic;
    private String content;
    private String create_time;
    private String parent_post_id;
    private PostDataBean parent_post;
    private int count_comment;
    private int count_like;
    private int count_follow;
    private int show_type;
    private int show_type2;
    private int is_follow;
    private int is_like;
    private int count_zhuanfa;
    private UserDataBean user_data;
    private List<ForwardPostBean> follow_user_comment_list;

    public String getPost_uuid() {
        return post_uuid;
    }

    public void setPost_uuid(String post_uuid) {
        this.post_uuid = post_uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getCount_comment() {
        return count_comment;
    }

    public void setCount_comment(int count_comment) {
        this.count_comment = count_comment;
    }

    public int getCount_like() {
        return count_like;
    }

    public void setCount_like(int count_like) {
        this.count_like = count_like;
    }

    public int getCount_follow() {
        return count_follow;
    }

    public void setCount_follow(int count_follow) {
        this.count_follow = count_follow;
    }

    public int getShow_type() {
        return show_type;
    }

    public void setShow_type(int show_type) {
        this.show_type = show_type;
    }

    public UserDataBean getUser_data() {
        return user_data;
    }

    public void setUser_data(UserDataBean user_data) {
        this.user_data = user_data;
    }

    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    public int getCount_zhuanfa() {
        return count_zhuanfa;
    }

    public void setCount_zhuanfa(int count_zhuanfa) {
        this.count_zhuanfa = count_zhuanfa;
    }

    public int getIs_like() {
        return is_like;
    }

    public void setIs_like(int is_like) {
        this.is_like = is_like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent_post_id() {
        return parent_post_id;
    }

    public void setParent_post_id(String parent_post_id) {
        this.parent_post_id = parent_post_id;
    }

    public PostDataBean getParent_post() {
        return parent_post;
    }

    public void setParent_post(PostDataBean parent_post) {
        this.parent_post = parent_post;
    }

    public List<ForwardPostBean> getFollow_user_comment_list() {
        return follow_user_comment_list;
    }

    public void setFollow_user_comment_list(List<ForwardPostBean> follow_user_comment_list) {
        this.follow_user_comment_list = follow_user_comment_list;
    }


    public List<ColorBean> getDiscoloration() {
        return discoloration;
    }

    public void setDiscoloration(List<ColorBean> discoloration) {
        this.discoloration = discoloration;
    }

    public int getShow_type2() {
        return show_type2;
    }

    public void setShow_type2(int show_type2) {
        this.show_type2 = show_type2;
    }
}

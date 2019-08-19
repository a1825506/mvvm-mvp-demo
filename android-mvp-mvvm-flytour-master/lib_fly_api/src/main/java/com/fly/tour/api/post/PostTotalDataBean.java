package com.fly.tour.api.post;

import java.util.List;

public class PostTotalDataBean {

    private String currentPage;

    private int totalPage;

    private List<PostDataBean> list;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<PostDataBean> getList() {
        return list;
    }

    public void setList(List<PostDataBean> list) {
        this.list = list;
    }
}

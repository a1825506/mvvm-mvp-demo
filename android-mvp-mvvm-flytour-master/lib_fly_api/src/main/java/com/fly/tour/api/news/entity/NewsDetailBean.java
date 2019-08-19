package com.fly.tour.api.news.entity;

import java.util.List;

public class NewsDetailBean {

    private String currentPage;

    private int totalPage;

    private List<NewsDetail> list;

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

    public List<NewsDetail> getList() {
        return list;
    }

    public void setList(List<NewsDetail> list) {
        this.list = list;
    }


}

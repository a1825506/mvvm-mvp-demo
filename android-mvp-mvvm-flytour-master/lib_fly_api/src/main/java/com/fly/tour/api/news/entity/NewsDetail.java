package com.fly.tour.api.news.entity;

/**
 * Description: <NewsDetail><br>
 * Author:      mxdl<br>
 * Date:        2019/5/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsDetail {


    private String coin_uuid;

    private String symbol;

    private String name;

    private String name_en;

    private String cover_pic;

    private String market_value;

    private String usd_market_value;

    private String increase_range;

    private String now_rmb_price;

    private String now_us_price;

    private String key;

    public String getCoin_uuid() {
        return coin_uuid;
    }

    public void setCoin_uuid(String coin_uuid) {
        this.coin_uuid = coin_uuid;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getIncrease_range() {
        return increase_range;
    }

    public void setIncrease_range(String increase_range) {
        this.increase_range = increase_range;
    }

    public String getMarket_value() {
        return market_value;
    }

    public void setMarket_value(String market_value) {
        this.market_value = market_value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getNow_rmb_price() {
        return now_rmb_price;
    }

    public void setNow_rmb_price(String now_rmb_price) {
        this.now_rmb_price = now_rmb_price;
    }

    public String getNow_us_price() {
        return now_us_price;
    }

    public void setNow_us_price(String now_us_price) {
        this.now_us_price = now_us_price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUsd_market_value() {
        return usd_market_value;
    }

    public void setUsd_market_value(String usd_market_value) {
        this.usd_market_value = usd_market_value;
    }

}

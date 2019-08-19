package com.fly.tour.api;


import com.fly.tour.api.config.API;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.news.entity.NewsDetail;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.api.newstype.entity.NewsType;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsDetailService {

    @POST("api/app/marketRankListApi")
    @FormUrlEncoded
    Observable<RespDTO<NewsDetailBean>> getListNewsDetailByType(@FieldMap Map<String, String> map);

    @GET(API.URL_HOST_NEWS + "/newsdetail/{id}/detail")
    Observable<RespDTO<NewsDetail>> getNewsDetailById(@Header("Authorization") String tolen, @Path("id") int id);

    @POST(API.URL_HOST_NEWS + "/newsdetail/save")
    Observable<RespDTO<NewsDetail>> addNewsDetail(@Header("Authorization") String tolen, @Body NewsDetail newsDetail);
}

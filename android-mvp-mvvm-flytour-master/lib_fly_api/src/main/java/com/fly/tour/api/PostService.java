package com.fly.tour.api;

import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.api.post.PostTotalDataBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostService {
    @POST("api/app/communityIndexApi")
    @FormUrlEncoded
    Observable<RespDTO<PostTotalDataBean>> getListPostByType(@FieldMap Map<String, String> map);

}

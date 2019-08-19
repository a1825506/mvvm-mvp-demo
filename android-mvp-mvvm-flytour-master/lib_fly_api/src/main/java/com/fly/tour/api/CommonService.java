package com.fly.tour.api;

import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.user.LoginDTO;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CommonService {
    @POST("api/app/loginApi")
    @FormUrlEncoded
    Observable<RespDTO<LoginDTO>> login(@FieldMap Map<String, String> map);
}

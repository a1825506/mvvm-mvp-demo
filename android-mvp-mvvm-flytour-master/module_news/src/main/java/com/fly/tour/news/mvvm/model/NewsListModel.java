package com.fly.tour.news.mvvm.model;

import android.app.Application;
import android.content.Context;

import com.fly.tour.api.NewsDetailService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.api.news.entity.NewsDetail;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.common.mvvm.model.BaseModel;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Description: <NewsListModel><br>
 * Author:      mxdl<br>
 * Date:        2019/5/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListModel extends BaseModel {
    private NewsDetailService mNewsDetailService;

    public NewsListModel(Application application) {
        super(application);
        mNewsDetailService = RetrofitManager.getInstance().getNewsDetailService();
    }

    public Observable<RespDTO<NewsDetailBean>> getListNewsByType(Map map) {
        return mNewsDetailService.getListNewsDetailByType(map)
        .compose(RxAdapter.exceptionTransformer())
        .compose(RxAdapter.schedulersTransformer());
    }
}

package com.fly.tour.news.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.news.entity.NewsDetail;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.fly.tour.common.util.DateUtil;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.log.MyUtil;
import com.fly.tour.news.mvvm.model.NewsListModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <NewsListPresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/5/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListViewModel extends BaseRefreshViewModel<NewsDetail, NewsListModel> {
    private int newsType = 0;

    public NewsListViewModel(@NonNull Application application, NewsListModel model) {
        super(application, model);
    }







    public void refreshData() {
        postShowNoDataViewEvent(false);
        if (!NetUtil.checkNetToast()) {
            postShowNetWorkErrViewEvent(true);
            return;
        }

        Map map = new HashMap<>();

        map.put("source", "0");

        map.put("index", "1");

        map.put("sort_type", "1");

        map.put("sort_field", "market_value");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);


        map.put("time", timestamp);


        map.put("access_token", access_token);



        mModel.getListNewsByType(map).subscribe(new Observer<RespDTO<NewsDetailBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
//                postShowInitLoadViewEvent(true);
            }

            @Override
            public void onNext(RespDTO<NewsDetailBean> listRespDTO) {
                List<NewsDetail> datailList = listRespDTO.data.getList();
                if (datailList != null && datailList.size() > 0) {
                    mList.clear();
                    mList.addAll(datailList);
                } else {
                    postShowNoDataViewEvent(true);
                }
                postStopRefreshEvent();
            }

            @Override
            public void onError(Throwable e) {
                postShowInitLoadViewEvent(false);
            }

            @Override
            public void onComplete() {
                postShowInitLoadViewEvent(false);
            }
        });
    }

    @Override
    public void loadMore() {

        Map map = new HashMap<>();

        map.put("source", 0);

        map.put("index", 1);

        map.put("sort_type", 1);

        map.put("sort_field", "market_value");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);

        map.put("time", timestamp);

        map.put("access_token", access_token);


        mModel.getListNewsByType(map).subscribe(new Observer<RespDTO<NewsDetailBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<NewsDetailBean> listRespDTO) {
                List<NewsDetail> datailList = listRespDTO.data.getList();
                if (datailList != null && datailList.size() > 0) {
                    mList.addAll(datailList);
                }
            }

            @Override
            public void onError(Throwable e) {
                postStopLoadMoreEvent();
            }

            @Override
            public void onComplete() {
                postStopLoadMoreEvent();
            }
        });
    }


    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }
}

package com.fly.tour.discuz.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.news.entity.NewsDetail;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.common.mvvm.viewmodel.BaseRefreshViewModel;

import com.fly.tour.common.util.DateUtil;
import com.fly.tour.common.util.NetUtil;
import com.fly.tour.common.util.log.MyUtil;
import com.fly.tour.discuz.mvvm.model.PostModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PostViewModel extends BaseRefreshViewModel<PostDataBean,PostModel> {

    public PostViewModel(@NonNull Application application, PostModel model) {
        super(application, model);
    }

    @Override
    public void refreshData() {

        postShowNoDataViewEvent(false);
        if (!NetUtil.checkNetToast()) {
            postShowNetWorkErrViewEvent(true);
            return;
        }

        ArrayMap map = new ArrayMap<>();

        map.put("index", 1);

        map.put("cate", 1);

        map.put("keywords", "");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);


        map.put("time", timestamp);


        map.put("access_token", access_token);

        mModel.getListPostByType(map).subscribe(new Observer<RespDTO<PostTotalDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<PostTotalDataBean> postDataBeanRespDTO) {
                List<PostDataBean> datailList = postDataBeanRespDTO.data.getList();
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
                postStopRefreshEvent();
            }

            @Override
            public void onComplete() {

            }
        });



    }

    @Override
    public void loadMore() {

        ArrayMap map = new ArrayMap<>();
        
        map.put("index", 2);

        map.put("cate", 1);

        map.put("keywords", "");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);

        map.put("time", timestamp);

        map.put("access_token", access_token);


        mModel.getListPostByType(map).subscribe(new Observer<RespDTO<PostTotalDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<PostTotalDataBean> listRespDTO) {
                List<PostDataBean> datailList = listRespDTO.data.getList();
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
}

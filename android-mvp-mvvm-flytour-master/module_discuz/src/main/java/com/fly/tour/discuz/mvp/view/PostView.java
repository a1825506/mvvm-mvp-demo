package com.fly.tour.discuz.mvp.view;

import android.util.ArrayMap;

import com.fly.tour.api.dto.RespDTO;

import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.common.mvp.view.BaseRefreshView;


import io.reactivex.Observable;

public interface PostView {

    interface View<PostDataBean> extends BaseRefreshView<PostDataBean> {

    }
    interface Presenter{


    }

    interface Model{
        Observable<RespDTO<PostTotalDataBean>> getPostList(ArrayMap map);
    }


}

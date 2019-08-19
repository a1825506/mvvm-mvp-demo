package com.fly.tour.discuz.mvvm.model;

import android.app.Application;
import com.fly.tour.api.PostService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.common.mvvm.model.BaseModel;

import java.util.Map;

import io.reactivex.Observable;

public class PostModel extends BaseModel {

    private PostService postService;


    public PostModel(Application application) {
        super(application);

        postService = RetrofitManager.getInstance().getPostService();
    }

    public Observable<RespDTO<PostTotalDataBean>> getListPostByType(Map map) {
        return postService.getListPostByType(map)
                .compose(RxAdapter.exceptionTransformer())
                .compose(RxAdapter.schedulersTransformer());
    }
}

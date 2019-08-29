package com.fly.tour.discuz.mvp.model;

import android.content.Context;
import android.util.ArrayMap;
import com.fly.tour.api.PostService;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.http.RxAdapter;
import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.common.mvp.model.BaseModel;
import com.fly.tour.discuz.mvp.view.PostView;
import io.reactivex.Observable;

public class PostListModel extends BaseModel implements PostView.Model{

    private PostService postService;

    public PostListModel(Context context) {
        super(context);
        postService = RetrofitManager.getInstance().getPostService();
    }

    @Override
    public Observable<RespDTO<PostTotalDataBean>> getPostList(ArrayMap map) {
        return postService.getListPostByType(map)
                .compose(RxAdapter.exceptionTransformer())
                .compose(RxAdapter.schedulersTransformer());
    }
}

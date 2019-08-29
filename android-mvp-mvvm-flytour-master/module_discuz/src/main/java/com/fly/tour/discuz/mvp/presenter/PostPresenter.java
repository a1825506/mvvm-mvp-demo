package com.fly.tour.discuz.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.api.post.PostTotalDataBean;

import com.fly.tour.common.mvp.presenter.BaseRefreshPresenter;
import com.fly.tour.common.util.DateUtil;
import com.fly.tour.common.util.log.MyUtil;
import com.fly.tour.discuz.mvp.model.PostListModel;
import com.fly.tour.discuz.mvp.view.PostView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class PostPresenter extends BaseRefreshPresenter<PostListModel,PostView.View<PostDataBean>,PostDataBean> implements PostView.Presenter{


    private int index=1;

    public PostPresenter(Context context, PostView.View view, PostListModel model) {
        super(context, view, model);
    }

    @Override
    public void refreshData() {
        mView.hideNoDataView();

        ArrayMap map = new ArrayMap<>();

        map.put("index", 1);

        map.put("cate", 1);

        map.put("keywords", "");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);


        map.put("time", timestamp);


        map.put("access_token", access_token);


        mModel.getPostList(map).subscribe(new Observer<RespDTO<PostTotalDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<PostTotalDataBean> postDataBeanRespDTO) {

                List<PostDataBean> dataList = postDataBeanRespDTO.data.getList();

                if(dataList!=null&&dataList.size()!=0){

                    mView.refreshData(postDataBeanRespDTO.data.getList());

                }else
                    mView.showNoDataView();



                mView.stopRefresh();

            }

            @Override
            public void onError(Throwable e) {
                mView.showNetWorkErrView();
                mView.stopRefresh();
            }

            @Override
            public void onComplete() {

            }

        });

    }

    @Override
    public void loadMoreData() {

        mView.hideNoDataView();

        ArrayMap map = new ArrayMap<>();

        map.put("index", index);

        map.put("cate", 1);

        map.put("keywords", "");

        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);


        map.put("time", timestamp);


        map.put("access_token", access_token);


        mModel.getPostList(map).subscribe(new Observer<RespDTO<PostTotalDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<PostTotalDataBean> postDataBeanRespDTO) {

                if(!TextUtils.isEmpty(postDataBeanRespDTO.data.getCurrentPage())){

                    index = Integer.parseInt(postDataBeanRespDTO.data.getCurrentPage())+1;

                }

                List<PostDataBean> dataList = postDataBeanRespDTO.data.getList();
                mView.loadMoreData(dataList);
                mView.stopLoadMore();

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

        });

    }


}

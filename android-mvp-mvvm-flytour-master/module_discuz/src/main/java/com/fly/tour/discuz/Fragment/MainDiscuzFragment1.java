package com.fly.tour.discuz.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.common.mvp.BaseRefreshFragment;
import com.fly.tour.discuz.R;
import com.fly.tour.discuz.adapter.PostListAdapter;
import com.fly.tour.discuz.mvp.model.PostListModel;
import com.fly.tour.discuz.mvp.presenter.PostPresenter;
import com.fly.tour.discuz.mvp.view.PostView;

import java.util.List;

public class MainDiscuzFragment1 extends BaseRefreshFragment<PostListModel,PostView.View<PostDataBean>,PostPresenter,PostDataBean> implements PostView.View<PostDataBean>{



    private RecyclerView postrecview;

    private PostListAdapter postListAdapter;


    public static MainDiscuzFragment1 newInstance() {
        return new MainDiscuzFragment1();
    }



    @Override
    public PostPresenter injectPresenter() {

      return  new PostPresenter(mActivity,this,new PostListModel(getContext()));

    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_discuz_list1;

    }

    @Override
    public void initView(View view) {

        postrecview = view.findViewById(R.id.postrecview);

        postListAdapter = new PostListAdapter();

        postrecview.setLayoutManager(new LinearLayoutManager(getContext()));

        postrecview.setAdapter(postListAdapter);


    }

    @Override
    public void initData() {

        autoLoadData();
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }


    @Override
    protected int onBindRreshLayout() {
        return R.id.refview_post_type;
    }


    @Override
    public void refreshData(List<PostDataBean> data) {
        postListAdapter.setNewData(data);
    }

    @Override
    public void loadMoreData(List<PostDataBean> data) {
        postListAdapter.addData(data);
    }

    @Override
    public void onRefreshEvent() {
        mPresenter.refreshData();
    }

    @Override
    public void onLoadMoreEvent() {
        mPresenter.loadMoreData();
    }

    @Override
    public void onAutoLoadEvent() {
        mPresenter.refreshData();
    }
}

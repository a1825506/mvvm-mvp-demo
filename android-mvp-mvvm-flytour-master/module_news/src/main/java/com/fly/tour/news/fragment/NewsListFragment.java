package com.fly.tour.news.fragment;


import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.view.View;
import com.fly.tour.api.news.entity.NewsDetailBean;
import com.fly.tour.common.adapter.BaseBindAdapter;
import com.fly.tour.common.event.me.NewsDetailCurdEvent;
import com.fly.tour.common.mvvm.BaseMvvmRefreshFragment;
import com.fly.tour.common.util.ObservableListUtil;
import com.fly.tour.news.BR;
import com.fly.tour.news.R;
import com.fly.tour.news.adapter.NewsListAdatper;
import com.fly.tour.news.databinding.FragmentNewsListBinding;
import com.fly.tour.news.mvvm.factory.NewsViewModelFactory;
import com.fly.tour.news.mvvm.viewmodel.NewsListViewModel;
import com.refresh.lib.DaisyRefreshLayout;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class NewsListFragment extends BaseMvvmRefreshFragment<NewsDetailBean, FragmentNewsListBinding, NewsListViewModel> {
    private NewsListAdatper mNewsListAdatper;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_news_list;
    }


    @Override
    public void initView(View view) {

        mNewsListAdatper = new NewsListAdatper(mActivity, mViewModel.getList());
        mViewModel.getList().addOnListChangedCallback(ObservableListUtil.getListChangedCallback(mNewsListAdatper));
        mBinding.recview.setItemAnimator(null);
        mBinding.recview.setAdapter(mNewsListAdatper);
    }

    @Override
    public void initData() {

        autoLoadData();

    }

    @Override
    public void initListener() {
        mNewsListAdatper.setItemClickListener(new BaseBindAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {

            }
        });
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NewsDetailCurdEvent curdEvent) {
//        if (curdEvent.getCode() == mNewsType.getId()) {
            autoLoadData();
//        }
    }

    @Override
    public Class<NewsListViewModel> onBindViewModel() {
        return NewsListViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return NewsViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }

    @Override
    public DaisyRefreshLayout getRefreshLayout() {
        return mBinding.refviewNewsType;
    }



}

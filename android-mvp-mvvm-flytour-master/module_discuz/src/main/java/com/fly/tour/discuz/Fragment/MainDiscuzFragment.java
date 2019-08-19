package com.fly.tour.discuz.Fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.view.View;
import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.common.mvvm.BaseMvvmRefreshFragment;
import com.fly.tour.common.util.ObservableListUtil;
import com.fly.tour.discuz.PostAdapter;
import com.fly.tour.discuz.R;
import com.fly.tour.discuz.BR;
import com.fly.tour.discuz.mvvm.factory.DiscuzViewModelFactory;
import com.fly.tour.discuz.mvvm.viewmodel.PostViewModel;
import com.refresh.lib.DaisyRefreshLayout;
import com.fly.tour.discuz.databinding.FragmentDiscuzListBinding;

public class MainDiscuzFragment extends BaseMvvmRefreshFragment<PostTotalDataBean,FragmentDiscuzListBinding,PostViewModel> {
    private PostAdapter mPostAdapter;

    public static MainDiscuzFragment newInstance() {
        return new MainDiscuzFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public Class<PostViewModel> onBindViewModel() {
        return PostViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return DiscuzViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_discuz_list;
    }

    @Override
    public void initView(View view) {
        mPostAdapter = new PostAdapter(mActivity, mViewModel.getList());
        mViewModel.getList().addOnListChangedCallback(ObservableListUtil.getListChangedCallback(mPostAdapter));
        mBinding.postrecview.setItemAnimator(null);
        mBinding.postrecview.setAdapter(mPostAdapter);

    }

    @Override
    public void initData() {

        mViewModel.refreshData();

    }

    @Override
    public String getToolbarTitle() {
        return "社区";
    }

    @Override
    public DaisyRefreshLayout getRefreshLayout() {
        return mBinding.refviewPostType;
    }
}

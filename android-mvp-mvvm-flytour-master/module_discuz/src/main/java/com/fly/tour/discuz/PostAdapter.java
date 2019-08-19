package com.fly.tour.discuz;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.common.adapter.BaseBindAdapter;
import com.fly.tour.discuz.databinding.ItemPostListBinding;

public class PostAdapter extends BaseBindAdapter<PostDataBean, ItemPostListBinding> {


    public PostAdapter(Context context, ObservableArrayList<PostDataBean> items) {
        super(context, items);
    }

    @Override
    protected int getLayoutItemId(int viewType) {
        return R.layout.item_post_list;
    }

    @Override
    protected void onBindItem(ItemPostListBinding binding, final PostDataBean item, final int position) {
        binding.setPostData(item);
        Glide.with(context).load(item.getUser_data().getHead_img()).into((ImageView) binding.postImg);


    }
}

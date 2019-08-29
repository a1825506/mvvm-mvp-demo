package com.fly.tour.discuz.adapter;




import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fly.tour.api.post.PostDataBean;
import com.fly.tour.api.post.PostTotalDataBean;
import com.fly.tour.discuz.R;


public class PostListAdapter extends BaseQuickAdapter<PostDataBean,BaseViewHolder>{


    public PostListAdapter() {

        super(R.layout.item_post_list1);
    }

    @Override
    protected void convert(BaseViewHolder helper, PostDataBean item) {

        helper.setText(R.id.post_title,item.getTitle());

        helper.setText(R.id.post_content,item.getContent());

    }
}

package com.fly.tour.discuz.provider;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fly.tour.common.provider.IDiscuzProvider;
import com.fly.tour.discuz.Fragment.MainDiscuzFragment;

@Route(path = "/discuz/main",name = "社区")
public class DiscuzProvider implements IDiscuzProvider {

    @Override
    public Fragment getDiscuzFragment() {
        return MainDiscuzFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }

}

package com.fly.tour.common.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IDiscuzProvider extends IProvider {

    Fragment getDiscuzFragment();
}

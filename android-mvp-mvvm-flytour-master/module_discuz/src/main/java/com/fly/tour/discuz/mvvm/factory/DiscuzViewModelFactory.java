package com.fly.tour.discuz.mvvm.factory;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.fly.tour.discuz.mvvm.model.PostModel;
import com.fly.tour.discuz.mvvm.viewmodel.PostViewModel;

public class DiscuzViewModelFactory extends ViewModelProvider.NewInstanceFactory{

    @SuppressLint("StaticFieldLeak")
    private static volatile DiscuzViewModelFactory INSTANCE;
    private final Application mApplication;

    public static DiscuzViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (DiscuzViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DiscuzViewModelFactory(application);
                }
            }
        }
        return INSTANCE;
    }
    private DiscuzViewModelFactory(Application application) {
        this.mApplication = application;
    }
    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PostViewModel.class)) {
            return (T) new PostViewModel(mApplication, new PostModel(mApplication));
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

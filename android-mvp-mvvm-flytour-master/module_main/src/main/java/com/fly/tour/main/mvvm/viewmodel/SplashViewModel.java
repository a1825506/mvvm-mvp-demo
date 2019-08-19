package com.fly.tour.main.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;
import com.fly.tour.api.RetrofitManager;
import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.http.ExceptionHandler;
import com.fly.tour.api.user.LoginDTO;
import com.fly.tour.common.event.SingleLiveEvent;
import com.fly.tour.common.mvvm.viewmodel.BaseViewModel;
import com.fly.tour.common.util.DateUtil;
import com.fly.tour.common.util.log.MyUtil;
import com.fly.tour.main.mvvm.model.SplashModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <SplashPresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/6/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class SplashViewModel extends BaseViewModel<SplashModel>{
    public static String TAG = SplashViewModel.class.getSimpleName();
    private SingleLiveEvent<Void> mVoidSingleLiveEvent;
    public SplashViewModel(@NonNull Application application, SplashModel model) {
        super(application, model);
    }
    public void login() {

        Map map = new HashMap<>();

        map.put("username", "13764005641");

        map.put("password", "12345678a");


        String timestamp = String.valueOf(DateUtil.getTimestamp());

        String access_token =  MyUtil.md5(map,timestamp);


        map.put("time", timestamp);


        map.put("access_token", access_token);


        mModel.login(map).subscribe(new Observer<RespDTO<LoginDTO>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<LoginDTO> loginDTORespDTO) {
                if(loginDTORespDTO.status == ExceptionHandler.APP_ERROR.SUCC){
//                    Log.v(TAG,"tolen:"+loginDTORespDTO.data.getToken());
//                    RetrofitManager.getInstance().TOKEN = "Bearer "+loginDTORespDTO.data.getToken();
                }else{
                    Log.v(TAG,"error:"+loginDTORespDTO.message);
                }
            }

            @Override
            public void onError(Throwable e) {
                getmVoidSingleLiveEvent().call();
            }

            @Override
            public void onComplete() {
                getmVoidSingleLiveEvent().call();
            }
        });
    }
    public SingleLiveEvent<Void> getmVoidSingleLiveEvent() {
        return mVoidSingleLiveEvent = createLiveData(mVoidSingleLiveEvent);
    }
}
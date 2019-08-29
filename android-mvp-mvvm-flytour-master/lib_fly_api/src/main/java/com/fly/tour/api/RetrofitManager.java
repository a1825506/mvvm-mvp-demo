package com.fly.tour.api;

import android.app.Application;
import android.content.Context;
import com.fly.tour.api.bean.HttpHeadBean;
import com.fly.tour.api.config.API;
import com.fly.tour.api.util.SSLContextUtil;
import com.google.gson.Gson;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description: <RetrofitManager><br>
 * Author:      mxdl<br>
 * Date:        2019/6/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class RetrofitManager {
    public static RetrofitManager retrofitManager;
    public static Context mContext;
    private Retrofit mRetrofit;
    public String TOKEN;
    OkHttpClient.Builder okHttpBuilder;

    private RetrofitManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.interceptors().add(logging);

        SSLContext sslContext = SSLContextUtil.getDefaultSLLContext();
        if (sslContext != null) {
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            okHttpBuilder.sslSocketFactory(socketFactory);
        }

        //域名验证
        okHttpBuilder.hostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);

        addHead();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(API.URL_HOST_USER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void init(Application application) {
        mContext = application;
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }


    /**
     * 创建一个社区类服务
     *
     * @return
     */
    public PostService getPostService() {
        return mRetrofit.create(PostService.class);
    }


    /**
     * 创建一个公共服务
     *
     * @return
     */
    public CommonService getCommonService() {
        return mRetrofit.create(CommonService.class);
    }

    /**
     * 创建一个新闻类型服务
     *
     * @return
     */
    public NewsTypeService getNewsTypeService() {
        return mRetrofit.create(NewsTypeService.class);
    }

    /**
     * 创建一个新闻详情服务
     *
     * @return
     */
    public NewsDetailService getNewsDetailService() {
        return mRetrofit.create(NewsDetailService.class);
    }

    public void addHead() {
        if (okHttpBuilder != null)
            okHttpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {


                    HttpHeadBean httpHeadBean = new HttpHeadBean();

                    httpHeadBean.setVersion("1.0");

                    httpHeadBean.setSource("1");

                    httpHeadBean.setToken("");

                    httpHeadBean.setProduct("bichacha");

                    httpHeadBean.setUuid("");

                    Gson mGson = new Gson();

                    String http_head =  mGson.toJson(httpHeadBean);




                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Content-Type", "application/json; charset=UTF-8")
                            .addHeader("G-Access-Token", http_head);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
    }
}
package com.fly.tour.common.util.log;

import android.util.Log;

import com.fly.tour.common.util.AppConfig;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyUtil {


    /**
     * md5加密的方法
     */
    public static String md5(Map map, String timestamp) {


        String[] access_token_arr = CompareParam(map);

        StringBuffer params_str = new StringBuffer();

        for(int i=0;i<access_token_arr.length;i++){

//            Log.e("++++","排序后的参数为:"+map.get(access_token_arr[0])+map.get(access_token_arr[1]));

            params_str.append(map.get(access_token_arr[i]));
        }

        String  plainText = params_str+ AppConfig.APPID+ AppConfig.APPKEY+timestamp;


        Log.e("++++","排序后的参数为:"+params_str);

        Log.e("++++","md5的拼接参数为："+params_str+ AppConfig.APPID+AppConfig.APPKEY+timestamp);






        //定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(plainText.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }


        Log.e("++++","md5值为:"+md5code);


        return md5code;
    }

    /**
     *  接口参数 排序方法 按照key升序排序
     */
    public static String[] CompareParam(Map map){

//        List<String> param_list = new ArrayList<>();

        Set set = map.keySet();

        String[] key_arr  = new String[map.size()];

        int index=0;

        for(Iterator iter = set.iterator(); iter.hasNext();)
        {

            String key = (String)iter.next();

            key_arr[index]=key;

            index++;
        }


        for (int i = 0; i < key_arr.length; i++) {
            for (int j = i+1; j < key_arr.length; j++) {
                if(key_arr[i].compareTo(key_arr[j])>0){    //对象排序用camparTo方法
//                   交换两个元素的位置的方法
                    String t = key_arr[i];
                    key_arr[i] = key_arr[j];
                    key_arr[j] = t;
                }
            }
        }

        return key_arr;



    }

}

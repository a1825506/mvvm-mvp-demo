package com.fly.tour.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.fly.tour.common.R;

/**
 * 自定义textview
 * 1、重写构造方法
 *
 * 2、
 *
 */
public class MyTextView extends View{

    /**
     * 文本颜色
     */
    private int textColor;
    /**
     * 字体大小
     */
    private float textSize;
    /**
     * 文本
     */
    private String text;

    /**
     * 绘制时控制
     */
    private Paint mPaint;

    private Rect mBoud;


    public MyTextView(Context context) {
        super(context);
        init(null);
    }


    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);

            if(typedArray.hasValue(R.styleable.MyTextView_textColor)){

                textColor = typedArray.getColor(R.styleable.MyTextView_textColor, 0);
            }

            if(typedArray.hasValue(R.styleable.MyTextView_textSize)){

                textSize = typedArray.getDimensionPixelSize(R.styleable.MyTextView_textSize, 0);
            }

            if(typedArray.hasValue(R.styleable.MyTextView_text)){

                text = typedArray.getString(R.styleable.MyTextView_text);
            }


        }

    }





}

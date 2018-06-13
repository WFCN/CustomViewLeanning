package com.wjf.customviewlearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author wangfei
 * @datetime 2018-06-12 17:24 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawTextView extends View {
    public static final String TAG = "DrawTextView";

    private Paint mPaint;
    private Paint.FontMetrics mFontMetrics;
    private int mWidth;
    private int mHeight;
    private String mString;
    private Paint linePaint;

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mFontMetrics = mPaint.getFontMetrics();
        Log.d(TAG, "ascent" + mPaint.ascent());
        Log.d(TAG, "descent" + mPaint.descent());
        Log.d(TAG, mFontMetrics.ascent + "ascent");
        Log.d(TAG, mFontMetrics.bottom + "bottom");
        Log.d(TAG, mFontMetrics.descent + "descent");
        Log.d(TAG, mFontMetrics.leading + "leading");
        Log.d(TAG, mFontMetrics.top + "top");

        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mString = "我是一条测试数据";
        float measureText = mPaint.measureText(mString);
        float x=mWidth/2-measureText/2;
        float y=mHeight/2-(mPaint.descent()+mPaint.ascent())/2;
        canvas.drawText(mString, x, y, mPaint);

        canvas.drawLine(0,mHeight/2,mWidth,mHeight/2,linePaint);
    }
}

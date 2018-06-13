package com.wjf.customviewlearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * @author wangfei
 * @datetime 2018-06-13 16:05 GMT+8
 * @email wf_0310@163.com
 * @detail :饼状图
 */
public class PieChartView extends View {
    //半径大小
    public static final int R_SIZE = 200;

    //最大饼状图的偏移数值
    public static final int TRANS_SIZE = 20;

    public static final int SIZE = 4;

    private Paint mPaint;

    private RectF mRectF;

    private int mWidth;

    private int mHeight;
    private float mNowAngle = 0;
    private float mToAngle = 0;

    public PieChartView(Context context) {
        this(context, null);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSt();
    }

    private void initSt() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mRectF = new RectF();
        mRectF.set(-R_SIZE, -R_SIZE, R_SIZE, R_SIZE);
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
        canvas.translate(mWidth / 2, mHeight / 2);
        for (int i = 0; i < SIZE; i++) {
            mPaint.setColor(getRandomColor());
            mToAngle = (i + 1) * 36;
            canvas.drawArc(mRectF, mNowAngle, mToAngle, true, mPaint);
            mNowAngle += mToAngle;
        }
    }

    private int getRandomColor() {
        Random random = new Random();
        int a = random.nextInt(256);
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return Color.argb(a, r, g, b);
    }
}

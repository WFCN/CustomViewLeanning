package com.wjf.customviewlearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wjf.customviewlearn.R;

/**
 * @author wangfei
 * @datetime 2018-04-23 17:21 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawPointView extends View {
    public static final int DEFAULT_SIZE = 5;

    private Paint mPaint;
    private float pointSize;
    private int pointColor;
    private int mWidth;
    private int mHeight;

    public DrawPointView(Context context) {
        this(context, null);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawPointView);
        pointSize = typedArray.getDimension(R.styleable.DrawPointView_dpv_point_size, DEFAULT_SIZE);
        pointColor = typedArray.getColor(R.styleable.DrawPointView_dpv_point_color, Color.argb(0x00, 0xff, 0x00, 0x00));
        typedArray.recycle();
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(pointColor);
        mPaint.setStrokeWidth(pointSize);
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
        canvas.drawPoint(0, 0, mPaint);
    }


}

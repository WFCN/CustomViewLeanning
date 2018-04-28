package com.wjf.customviewlearn.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wjf.customviewlearn.R;

/**
 * @author wangfei
 * @datetime 2018-04-28 15:32 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawRentView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Rect mRect;
    private int mColor;

    public DrawRentView(Context context) {
        this(context, null);
    }

    public DrawRentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawRentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            @SuppressLint("CustomViewStyleable")
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawRentView);
            mColor = typedArray.getColor(R.styleable.DrawRentView_drv_color, Color.BLUE);
            typedArray.recycle();

        }
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mRect = new Rect();
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
        int stokenWidth = 10;
        mRect.set(stokenWidth, stokenWidth, (mWidth - stokenWidth), (mHeight - stokenWidth));
        canvas.drawRect(mRect, mPaint);
    }
}

package com.wjf.customviewlearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wjf.customviewlearn.R;

/**
 * @author wangfei
 * @datetime 2018-04-28 16:09 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawRoundRent extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private RectF mRect;
    private float mRX;
    private float mRY;

    public DrawRoundRent(Context context) {
        this(context,null);
    }

    public DrawRoundRent(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawRoundRent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawRoundRent);
            mRX = typedArray.getDimension(R.styleable.DrawRoundRent_drr_rx, 10);
            mRY = typedArray.getDimension(R.styleable.DrawRoundRent_drr_ry, 10);
            typedArray.recycle();
        }
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mRect=new RectF();
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
        mRect.set(2.5f, 2.5f,mWidth-2.5f,mHeight-2.5f);
        canvas.drawRoundRect(mRect,mRX,mRY,mPaint);
    }
}

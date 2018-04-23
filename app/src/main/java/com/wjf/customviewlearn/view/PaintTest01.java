package com.wjf.customviewlearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wjf.customviewlearn.paint.PaintStyle;

/**
 * @author wangfei
 * @datetime 2018-04-23 15:13 GMT+8
 * @email wf_0310@163.com
 * @detail :画笔测试
 */
public class PaintTest01 extends View {

    private Paint mPaint;
    private int mWidth;
    private int mheight;

    public PaintTest01(Context context) {
        this(context, null);
    }

    public PaintTest01(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintTest01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = initPaint();
    }

    private Paint initPaint() {
        return PaintStyle.getPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mheight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mheight / 2);

        canvas.drawCircle(0, 0, Math.min(mWidth, mheight) / 2, mPaint);
    }
}
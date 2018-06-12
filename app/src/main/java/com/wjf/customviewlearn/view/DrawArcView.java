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
 * @datetime 2018-06-12 11:25 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawArcView extends View {
    public static final int M_COLOR = Color.GREEN;
    private Paint mPaint;
    private int mLineColor;
    private int mShapeColor;
    private RectF mRectF;
    private int mWidth;
    private int mHeight;

    public DrawArcView(Context context) {
        this(context, null);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawArcView, defStyleAttr, 0);
            mLineColor = typedArray.getColor(R.styleable.DrawArcView_line_color, M_COLOR);
            mShapeColor = typedArray.getColor(R.styleable.DrawArcView_shape_color, M_COLOR);
            typedArray.recycle();
        }
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mLineColor);
        mRectF = new RectF();
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
        mRectF.set(0, 0, mWidth, mHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(mRectF,0,-120,true,mPaint);
    }
}

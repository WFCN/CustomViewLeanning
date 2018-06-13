package com.wjf.customviewlearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author wangfei
 * @datetime 2018-06-12 13:36 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
public class DrawPathView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Path mPath;

    public DrawPathView(Context context) {
        this(context, null);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mPath = new Path();

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.addCircle(mWidth / 2, 20, 20, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        canvas.translate(0, 40);
        mPath.lineTo(0, 40);//绝对坐标
        mPath.rLineTo(40, 0);//相对坐标
        mPath.moveTo(80, 40);//改变路径的起点
        mPath.lineTo(40, 0);
        mPath.lineTo(0, 0);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        canvas.translate(0, 40);
        mPath.lineTo(40, 40);
        /**
         * 最后一个参数的含义
         *
         * 如果当前path没有内容,true和false没有区别
         * 如果当前path有内容,false会强制连接path的重点和圆弧的起点
         */
        mPath.arcTo(40, 40, 240, 160, 0, 270, false);
        /**
         * 该方法和mPath.arcTo(40,40,240,160,0,270,true)
         * 效果等同
         */
        //mPath.addArc(40,40,240,160,0,270);
        canvas.drawPath(mPath, mPaint);
        /**
         * 设置填充方式
         */
        //奇偶原则,图形内任意点向任何方向发射一条直线和图像边界交叉的次数,如果是偶数为图形外部,奇数为图形内部
        mPath.setFillType(Path.FillType.EVEN_ODD);
        //非零环绕数原则,该原则和绘制图形的方向有关,图形内任意点向任何方向发射一条直线,基数为0,和顺时针方向边界交叉+1
        //和逆时针边界交叉则-1,结果不是0为内部,包含<0;
        mPath.setFillType(Path.FillType.WINDING);
        //两种原则都不会因为点的位置而影响结果
    }
}

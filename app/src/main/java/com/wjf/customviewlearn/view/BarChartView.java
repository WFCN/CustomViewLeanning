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
 * @datetime 2018-06-13 13:44 GMT+8
 * @email wf_0310@163.com
 * @detail :条形图联系
 */
public class BarChartView extends View {

    public static final int PADDING = 20;
    public static final int LINE_PADDING = 10;
    public static final int RECT_SIZE = 20;

    public static final int SIZE = 6;

    private Paint mLinePaint;
    private Paint mTextPaint;
    private Paint mRectPaint;

    private int mWidth;
    private int mHeight;

    private int shapeWidth;
    private int shapeHeight;

    private float fontHeight;

    private int[] xPoints = new int[SIZE];

    private String[] mStrings = new String[]{"C++", "JAVA", "PYTHON", "KOTLIN", "ANDROID", "IOS"};


    public BarChartView(Context context) {
        this(context, null);
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(2);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(40);
        mTextPaint.setStyle(Paint.Style.STROKE);
        fontHeight = -mTextPaint.getFontMetrics().top + mTextPaint.getFontMetrics().bottom;

        mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.GREEN);
        mRectPaint.setStrokeWidth(1);

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

        shapeWidth = mWidth - 2 * PADDING - 2 * LINE_PADDING;
        shapeHeight = (int) (mHeight - 2 * PADDING - fontHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //横向线
        canvas.drawLine(PADDING, mHeight - (PADDING + fontHeight), mWidth - PADDING, mHeight - (PADDING + fontHeight)
                , mLinePaint);
        //竖线
        canvas.drawLine(PADDING, PADDING, PADDING, mHeight - (PADDING + fontHeight), mLinePaint);

        //
        int dx = shapeWidth / SIZE;
        for (int i = 0; i < SIZE; i++) {
            xPoints[i] = i * LINE_PADDING + (i + 1) * dx - dx / 2;
        }

        //画字

        for (int i = 0; i < mStrings.length; i++) {
            float measureText = mTextPaint.measureText(mStrings[i]) / 2;
            canvas.drawText(mStrings[i], xPoints[i] - measureText, mHeight - PADDING - fontHeight - mTextPaint
                    .getFontMetrics().top, mTextPaint);
        }

        //画矩形

        for (int i = 0; i < SIZE; i++) {
            float y = (float) (shapeHeight * Math.random());
            Log.e("---------","y===="+y);
            canvas.drawRect(xPoints[i] - RECT_SIZE, PADDING+y, xPoints[i] + RECT_SIZE, mHeight - PADDING -
                    fontHeight-mLinePaint.getStrokeWidth()/2, mRectPaint);
        }
    }
}

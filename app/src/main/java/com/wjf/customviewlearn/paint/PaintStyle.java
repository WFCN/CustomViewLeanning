package com.wjf.customviewlearn.paint;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author wangfei
 * @datetime 2018-04-23 14:20 GMT+8
 * @email wf_0310@163.com
 * @detail :画笔描述
 */
public class PaintStyle {
    public static final String Tag = "PainStyle";


    public static Paint getPaint() {
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);//设置抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//填充+描边
        paint.setStyle(Paint.Style.STROKE);//描边
        paint.setColor(Color.argb(80,0,0,0));
        return paint;
    }

}

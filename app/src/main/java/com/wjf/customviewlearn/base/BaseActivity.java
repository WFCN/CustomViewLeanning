package com.wjf.customviewlearn.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author wangfei
 * @datetime 2018-04-23 15:55 GMT+8
 * @email wf_0310@163.com
 * @detail :
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    /**
     * [页面跳转]
     *
     * @param clz
     */
    protected void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    protected void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    protected void startActivityForResult(Class<?> cls, Bundle bundle,
                                          int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

}

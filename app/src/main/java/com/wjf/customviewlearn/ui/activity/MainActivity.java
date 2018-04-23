package com.wjf.customviewlearn.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wjf.customviewlearn.R;
import com.wjf.customviewlearn.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    /**
     * Lesson01
     */
    private Button mBtLesson01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_lesson01:
                startActivity(PaintTestActivity.class);
                break;
        }
    }

    private void initView() {
        mBtLesson01 = findViewById(R.id.bt_lesson01);
        mBtLesson01.setOnClickListener(this);
    }
}

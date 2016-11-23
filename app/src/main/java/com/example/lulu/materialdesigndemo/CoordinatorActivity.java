package com.example.lulu.materialdesigndemo;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        findViewById(R.id.coordinator_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Snackbar只有在和Coordinator连用的时候才会滑动删除
        Snackbar.make(v, "Snackbar in CoordinatorLayout", Snackbar.LENGTH_SHORT)
                //添加点击事件
                .setAction("exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.finishAffinity(CoordinatorActivity.this);
                    }
                }).show();
    }
}

package com.example.lulu.coordinatordemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.main_text);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.CHINA, "第%02d条数据", i));
        }
        recyclerView.setAdapter(new MyAdapter(this, list));
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //布局属性
        //第一种方式
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) textView.getLayoutParams();
//        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();//滑动删除事件
//        behavior.setListener(this);//设置 行为 监听
//        params.setBehavior(behavior);
        //使用自定义的behavior
//        MyBehavior myBehavior = new MyBehavior();
//        params.setBehavior(myBehavior);
        //FloatingActionButton的使用
        findViewById(R.id.fab).setOnClickListener(this);
        findViewById(R.id.ibtn).setOnClickListener(this);
    }

    // -------------------------------------------
    // behavior 的监听回调
    @Override
    public void onDismiss(View view) { //滑动消失的时候
        view.setVisibility(View.GONE);
        Snackbar.make(view, "删除了一个控件", Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.animate().alpha(1).start();
                        textView.setVisibility(View.VISIBLE);
                    }
                }).show();
    }

    @Override
    public void onDragStateChanged(int state) {// 状态改变的时候

    }

    // -----------------------------------------------
    // 点击事件处理
    @Override
    public void onClick(View v) {
        Snackbar.make(v, "点击事件触发", Snackbar.LENGTH_LONG).show();
    }
}

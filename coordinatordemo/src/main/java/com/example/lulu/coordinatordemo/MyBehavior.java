package com.example.lulu.coordinatordemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by lulu on 2016/11/23.
 *
 */
public class MyBehavior extends FloatingActionButton.Behavior {
    public MyBehavior() {
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //开始滚动, 返回值是否关心
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        return true;
    }

    //发生滚动
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        // 考虑垂直方向
        if (dy < 0) { //向下滚动
//            ViewCompat.animate(child).scaleY(1).scaleX(1).start();//出现
            child.show();
        } else { //向上滚动
//            ViewCompat.animate(child).scaleY(0).scaleX(0).start();// 小时
            child.hide();
        }
    }
}

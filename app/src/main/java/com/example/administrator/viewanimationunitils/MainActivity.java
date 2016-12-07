package com.example.administrator.viewanimationunitils;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //顶部透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //底部透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mly = (ImageView)findViewById(R.id.linearlayout);

        mly.post(new Runnable() {
            @Override
            public void run() {
                //设置初始位置的坐标为控件的中心点
                int x = (mly.getLeft()+mly.getRight())/2;
                int y = (mly.getTop()+mly.getBottom())/2;

                //最后两个参数分别是初始动画的半径，结束时动画的半径
                Animator animation = ViewAnimationUtils.createCircularReveal(mly,x,y,0,x);

//                设置动画逐渐加快
                animation.setInterpolator(new AccelerateInterpolator());
                //设置动画时长
                animation.setDuration(5000);
                //开始执行动画
                animation.start();
            }
        });
    }
}

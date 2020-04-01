package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        RelativeLayout rootview = findViewById(R.id.relativelayout);
        int count = getAllChildViewCount(rootview);
        TextView textView = findViewById(R.id.tv_center);
        textView.setText(count + "");
    }

    public int getAllChildViewCount(View view) {
        if(view == null)
            return 0;
        int viewCount = 0;

        if(view instanceof ViewGroup) {
            viewCount++;
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View temp = ((ViewGroup) view).getChildAt(i);
                if (temp instanceof ViewGroup) {
                    viewCount += getAllChildViewCount(temp);
                } else {
                    viewCount++;
                }
            }
        }
        return viewCount;
    }
}

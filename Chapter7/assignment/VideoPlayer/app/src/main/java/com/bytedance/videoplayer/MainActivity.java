package com.bytedance.videoplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;


import static android.widget.RelativeLayout.*;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private static int progress = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = getIntent().getData();
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        videoView = findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        if(uri == null)
            videoView.setVideoPath(getVideoPath(R.raw.bytedance));
        else
            videoView.setVideoURI(uri);

        if(progress != -1)
            videoView.seekTo(progress);

        videoView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        progress = videoView.getCurrentPosition();
    }

    private  String getVideoPath(int resId) {
        return "android.resource://" + this.getPackageName() + "/" + resId;
    }
}
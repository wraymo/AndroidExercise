package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private CheckBox box1, box2, box3;
    private Button button;
    private EditText text1, text2, text3;
    private boolean [] check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = new boolean[3];
        button = findViewById(R.id.button);
        box1 = findViewById(R.id.chk7);
        box2 = findViewById(R.id.chk8);
        box3 = findViewById(R.id.chk9);
        final TextView tv1 = findViewById(R.id.text1);
        text1 = findViewById(R.id.edit_text1);
        text2 = findViewById(R.id.edit_text2);
        text3 = findViewById(R.id.edit_text3);

        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check[0] = true;
                }else{
                    check[0] = false;
                }
            }
        });

        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check[1] = true;
                }else{
                    check[1] = false;
                }
            }
        });

        box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check[2] = true;
                }else{
                    check[2] = false;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String temp = "您的选择是：\n";
                if(check[0])
                    temp += "可乐 * " + text1.getText() + "\n";
                if(check[1])
                    temp += "奶茶 * " + text2.getText() + "\n";
                if(check[2])
                    temp += "咖啡 * " + text3.getText() + "\n";
                tv1.setText(temp);
                text1.setText("");
                text2.setText("");
                text3.setText("");
            }
        });

        Log.d(TAG, "MainActivity");
    }
}

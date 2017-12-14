package com.shunwang.lyutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shunwang.mylibrary.LyUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LyUtil bean=new LyUtil();
    }
}

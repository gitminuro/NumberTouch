package com.gitminuro.numbertouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutTitle();
    }

    /**
     * タイトル画面の表示
     */
    private void setLayoutTitle() {
        setContentView(R.layout.activity_title);

        Button exBtn = (Button)findViewById(R.id.ExBtn);
        exBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLayoutExplain();
            }
        });
        Button startBtn = (Button)findViewById(R.id.StartBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLayoutMain();
            }
        });
    }

    /**
     * 説明画面の表示
     */
    private void setLayoutExplain() {
        setContentView(R.layout.activity_ex);

        Button titleBtn = (Button)findViewById(R.id.TitleBtn);
        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLayoutTitle();
            }
        });
    }

    /**
     * メイン画面の表示
     */
    private void setLayoutMain() {
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLayoutTitle();
            }
        });
    }
}

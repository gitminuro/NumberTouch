package com.gitminuro.numbertouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] numArray;
    private int[] sortArray;

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

        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = (TextView) findViewById(R.id.TxtTest);
                txt.setText(((Button)v).getText());
            }
        };

        setRandomNum();
        setButton(event, R.id.button1, 1);
        setButton(event, R.id.button2, 2);
        setButton(event, R.id.button3, 3);
        setButton(event, R.id.button4, 4);
        setButton(event, R.id.button5, 5);
        setButton(event, R.id.button6, 6);
        setButton(event, R.id.button7, 7);
        setButton(event, R.id.button8, 8);
        setButton(event, R.id.button9, 9);
        setButton(event, R.id.button10, 10);
        setButton(event, R.id.button11, 11);
        setButton(event, R.id.button12, 12);
        setButton(event, R.id.button13, 13);
        setButton(event, R.id.button14, 14);
        setButton(event, R.id.button15, 15);
        setButton(event, R.id.button16, 16);
        setButton(event, R.id.button17, 17);
        setButton(event, R.id.button18, 18);
        setButton(event, R.id.button19, 19);
        setButton(event, R.id.button20, 20);

        Button b = (Button)findViewById(R.id.title);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLayoutTitle();
            }
        });
    }

    private void setRandomNum() {
        numArray = new int[20];
        for(int i = 0; i < 20; i++) {
            numArray[i] = new Random().nextInt(100) + 1;
        }
    }

    private void setButton(View.OnClickListener ev, int btnId, int renban) {
        Button numBtn = (Button)findViewById(btnId);
        numBtn.setOnClickListener(ev);
        numBtn.setText(new Integer(numArray[renban-1]).toString());
    }
}

package com.gitminuro.numbertouch;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int[] numArray;
    private int[] sortArray;
    private int nowNum;

    private Timer timer;
    private CountUpTimerTask timerTask;
    private Handler handler = new Handler();
    private long count, delay, period;

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
                TextView txtClear = (TextView)findViewById(R.id.TxtClear);
                if(nowNum < 0 || ((Button)v).getText().toString().equals("〇") || count >= 36000) return;
                if(Integer.parseInt(((Button)v).getText().toString()) == sortArray[nowNum]) {
                    ((Button)v).setBackgroundColor(Color.rgb(135, 206, 235));
                    ((Button)v).setText("〇");
                    nowNum--;
                    if(nowNum < 0) {
                        txtClear.setVisibility(View.VISIBLE);
                        timerStop();
                    }
                }
                else {
                    ((Button)v).setBackgroundColor(Color.rgb(220, 20, 60));
                }
            }
        };

        nowNum = 19;
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

        Button toTitle = (Button)findViewById(R.id.BtnEnd);
        toTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStop();
                setLayoutTitle();
            }
        });

        timerStart();

    }

    private void setRandomNum() {
        numArray = new int[20];
        sortArray = new int[20];
        int ran = 0;
        for(int i = 0; i < 20; i++) {
            ran = new Random().nextInt(100) + 1;
            numArray[i] = ran;
            sortArray[i] = ran;
        }
        Arrays.sort(sortArray);
    }

    private void setButton(View.OnClickListener ev, int btnId, int renban) {
        Button numBtn = (Button)findViewById(btnId);
        numBtn.setOnClickListener(ev);
        numBtn.setText(String.valueOf(numArray[renban-1]));
    }

    private void timerStart() {
        if(timer != null) {
            timer.cancel();
            timer = null;
        }

        timer = new Timer();
        timerTask = new CountUpTimerTask();
        delay = 0;
        period = 100;
        count = 0;
        timer.schedule(timerTask, delay, period);
        ((TextView)findViewById(R.id.TxtTimer)).setText("00:00.00");
    }

    private void timerStop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    class CountUpTimerTask  extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(count < 36000) {
                        count++;
                        long mm = count * 100 / 1000 / 60;
                        long ss = count * 100 / 1000 % 60;
                        long ms = (count * 100 - ss * 1000 - mm * 1000 * 60) / 100;
                        ((TextView) findViewById(R.id.TxtTimer)).setText(
                                String.format(Locale.JAPAN, "%1$02d:%2$02d.%3$01d", mm, ss, ms)
                        );
                    }
                    else {
                        ((TextView) findViewById(R.id.TxtClear)).setText("失敗！");
                        findViewById(R.id.TxtClear).setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}

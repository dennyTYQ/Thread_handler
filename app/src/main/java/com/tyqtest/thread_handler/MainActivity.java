package com.tyqtest.thread_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView_click ;

    Handler handler = new Handler(){
        @Override
        public String getMessageName(Message message) {
            return super.getMessageName(message);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Object data = msg.obj;
                    Log.i("date",""+msg.obj);
                    imageView_click.setImageResource(R.mipmap.ic_launcher);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_click = (ImageView) findViewById(R.id.image_click);
        imageView_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }
        });

    }
    private  void  Update(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.sendEmptyMessage(0);
                Message msg = new Message();
                msg.obj = R.mipmap.ic_launcher;

                handler.sendMessage(msg);
            }
        }).start();
    }
}

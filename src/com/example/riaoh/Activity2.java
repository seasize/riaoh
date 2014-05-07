package com.example.riaoh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;


public class Activity2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		final NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

		Button btn = new Button(this);
        btn.setText("計測を開始します");

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
			@Override
            public void onClick(View v) {
                RemoteViews rv = new RemoteViews(getPackageName(), R.layout.notify);
                rv.setTextViewText(android.R.id.title, "リア充力計測中…");

                Notification.Builder builder = new Notification.Builder(v.getContext());
                builder.setTicker("計測開始");
                builder.setContent(rv);
                builder.setSmallIcon(R.drawable.ic_launcher);

                /* 
                 * 今回、カスタムなViewを使うのでここらへんは省略
                builder.setContentTitle("ABC");
                */

                Notification n = builder.build();

                nm.notify(1, n);
            }
        });

        setContentView(btn);
    }

		
	
	
	public void switchActivity(View v){
		finish();
	}
	

}

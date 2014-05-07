package com.example.riaoh;

import android.accessibilityservice.AccessibilityService;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;


public class SampleAccessibilityService extends AccessibilityService {
	
	globals glo;
	
	
    private static final String TAG = "SampleAccessibilityService";
  
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    	
    	glo=(globals)this.getApplication();
    	
    	
        if (!(event.getClassName().toString().startsWith("android.widget.Toast"))) {
            for (CharSequence s : event.getText()) {
                Toast.makeText(this, "text: " + s, Toast.LENGTH_LONG).show();
            }
        }

        Notification n = (Notification)event.getParcelableData();

        if (n == null) {
            return;
        }

        RemoteViews rv = n.contentView;
        View view = rv.apply(this, null);

        if (view == null) {
            return;
        }

        TextView textView = (TextView)view.findViewById(android.R.id.title);

        if (textView == null) {
            return;
        }
        Log.v(TAG, "text: " + textView.getText());
        
        if(textView.getText().toString().equals("LINE")){
        	glo.Linecount++;
        	 Log.v(TAG, Integer.toString(glo.Linecount));
        } else if(textView.getText().toString().equals("spモードメール")){
        	glo.mail++;
        	Log.v(TAG, Integer.toString(glo.mail));
        }else if(textView.getText().toString().equals("Yahoo!メール")){
        	glo.Ymail++;
        	Log.v(TAG, Integer.toString(glo.Ymail));
        }else if(textView.getText().toString().equals("twicca")){
        	glo.twicca++;
        	Log.v(TAG, Integer.toString(glo.Ymail));
        }
    
       
    }

  

	@Override
    public void onInterrupt() {
    }
    
    
    
  
    
}

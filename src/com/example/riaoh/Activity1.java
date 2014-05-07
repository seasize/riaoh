package com.example.riaoh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

 
public class Activity1 extends Activity {
	

	private TextView textView;
	String output = "";
	public int n=0;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);
		
		
				textView=(TextView)findViewById(R.id.textView1);
				
		
		
	}
	
	public void onclick(View v){
	
		ContentResolver cr = this.getContentResolver();
		Cursor cursor = cr.query( ContactsContract.Contacts.CONTENT_URI,null,null, null, null);
		
		if(cursor.moveToFirst()){
			try{
				
				while(cursor.moveToNext()){
					
					n++;
				}
				cursor.close();
			} catch(Exception exp){
				exp.printStackTrace();
			}
		}
		textView.setText("登録人数"+Integer.toString(n)+"人");
		n=0;
	} 
	
	public void switchActivity(View v){
		finish();
	}
}



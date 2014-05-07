package com.example.riaoh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;;


public class Activity2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity3);
		
	
		
	}
	
	public void switchActivity(View v){
		finish();
	}
	

}

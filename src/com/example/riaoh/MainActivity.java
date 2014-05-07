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
import android.content.Intent;


 
public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//if (!TwitterUtils.hasAccessToken(this)) {
        //    Intent intent = new Intent(this, TwitterOAuthActivity.class);
         //   startActivity(intent);
        //    finish();
       // } 

	}
				
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	
		public void switchActivity1(View v){
			Intent varIntent=new Intent(this,Activity1.class);
			startActivity(varIntent);
		}
		
		public void switchActivity2(View v){
			Intent varIntent=new Intent(this,Activity2.class);
			startActivity(varIntent);
		}
		
		public void switchActivity3(View v){
			Intent varIntent=new Intent(this,Activity3.class);
			startActivity(varIntent);
		}
		
		
}
	
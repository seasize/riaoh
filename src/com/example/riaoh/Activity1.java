package com.example.riaoh;


import twitter4j.*; 
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.io.*; 
import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.Iterator; 
import java.util.List; import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import twitter4j.User;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


 
public class Activity1 extends Activity {
	
	globals glo;
	
	
	
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	String output = "";
	public int n=0;
	public int ria=0;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);
		
		
				textView1=(TextView)findViewById(R.id.textView1);
				textView2=(TextView)findViewById(R.id.textView2);
				textView3=(TextView)findViewById(R.id.textView3);
				
		
		
	}
	
	public void onclick(View v){
	
		ContentResolver cr = this.getContentResolver();
		Cursor cursor = cr.query( ContactsContract.Contacts.CONTENT_URI,null,null, null, null);
	/*		Twitter twitter = TwitterFactory.getSingleton();
		//認証 	
		IDs ids=null;
		List<Integer> followList = new ArrayList<Integer>();
		//フォローを取得するリスト。RAM節約にlongではなくint型で取る 
		try {
			ids = twitter.getFriendsIDs(-1L);
			} catch (TwitterException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				}  
		for(long id :ids.getIDs()){
			followList.add((int)id);
			} 
		int size = followList.size();
	
			textView.setText(Integer.toString(size));
		*/	   
		
		
	/*	int f=0;
		
		Twitter twitter = new TwitterFactory().getSingleton();
		try {
			User user = twitter.showUser("@wwwww_BOT");
			   f=user.getFollowersCount();
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} */
		

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
		
		glo=(globals)this.getApplication();
		ria=n*100+glo.Linecount*20+glo.mail*50+glo.Ymail*50+glo.twicca*30;
		
		textView1.setText("登録人数:"+Integer.toString(n)+"人 \n"+"LINE:"+Integer.toString(glo.Linecount)+"返信\n"+"spメール:"+Integer.toString(glo.mail)+"通\n"+"Y!メール:"+Integer.toString(glo.Ymail)+"通\n"+"twitter:"+Integer.toString(glo.twicca)+"リプライ\n");
		textView2.setText("リア充力:"+Integer.toString(ria)+"Ria");
		if(ria>=0&&ria<1000){
			textView3.setText("称号:愛と勇気すらともだちじゃない");
		}else if(ria>=1000&&ria<5000){
			textView3.setText("称号:リアカー");
		}else if(ria>=5000&&ria<10000){
			textView3.setText("称号:どこから見てもリア充");
		}else if(ria>=10000&&ria<15000){
			textView3.setText("称号:リア・ディゾン");
		}else if(ria>=15000&&ria<20000){
			textView3.setText("称号:石田純一");
		}else if(ria>=20000){
			textView3.setText("称号:リア王");
		}
		n=0;
	
	} 
	
	public void switchActivity(View v){
		finish();
	}
}



package com.example.pelicancross;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity  {

	public int speed;

	String msg = "Done MA: ";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		
		//Open 1st layout
		setContentView(R.layout.activity1);
		mainControls();	
		Log.d(msg, "Main Screen");
		
			
	}
	
	//Main Controls PeliCross
	protected void mainControls() {
		
		//find button PLAY
		Button button1 = (Button) findViewById(R.id.button1);		
		
	
		//register click event with button play
		 button1.setOnClickListener(new View.OnClickListener() {
	           public void onClick(View v) {
		           Intent i = new Intent(MainActivity.this, Database.class);
		           startActivity(i);
	           }
	        });
		 
			//find button RANKING
			Button button2 = (Button) findViewById(R.id.button2);
			//register click event with button play
			 button2.setOnClickListener(new View.OnClickListener() {
		           public void onClick(View v) {
			           Intent i = new Intent(MainActivity.this, Ranking.class);
			           startActivity(i);
		           }
		        });
			 
			 //find button INSTRUCTIONS
				Button button3 = (Button) findViewById(R.id.button3);
			
				//register click event with button play
				 button3.setOnClickListener(new View.OnClickListener() {
			           public void onClick(View v) {
		        	   //open instruction's page
			           Intent i = new Intent(MainActivity.this, Instructions.class);
			           startActivity(i);

			           }
			        });
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	//Actions on the actions bar
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
		
} //End MainActivity 

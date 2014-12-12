package com.example.pelicancross;


import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

public class Ranking extends Database {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.rank);
		
		String msg = "Done R: ";
		Log.d(msg, "Ranking Activity");
		
		//Finding all fields on the layout
		RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		TextView pspeed = (TextView) findViewById(R.id.currentspeed_db);
		TextView cspeed = (TextView) findViewById(R.id.speed_db);
		ratingBar.setRating(3f);

		//fitting values on EditTexts of ranking screen
		
		pspeed.setText(Integer.toString(speed));
		cspeed.setText(Integer.toString(Champion()));
		
			
	}
	
	
}
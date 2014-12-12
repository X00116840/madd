package com.example.pelicancross;

//import java.util.List;

import java.util.List;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class Database extends MainActivity{	
	
	EditText player_name;
	public String playername;
	int playerspeed;
	String msg = "Debugging Database: ";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		setContentView(R.layout.database_entry);	
		
		//find EditText player name on the screen
		player_name = (EditText)findViewById(R.id.player_name);
			
	}
	

    public void newPlayer (View view) {
    	
	   DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
	
	   //temporary speed random
	   Random rm = new Random();
	   speed = rm.nextInt(50);
	
	   Player player = new Player();
	   player.setPlayerName(player_name.getText().toString());
	   player.setPlayerSpeed(speed);
	   
	   dbHandler.addPlayer(player);
	   
	  List<Player> list = dbHandler.getAllPlayers();
	  Log.d(msg, list.toString());
	   
	   Intent i = new Intent(Database.this, Accelerometer.class);
       startActivity(i);
               		   	
  }
    
    public void clearPlayers (View view){
    	   
    	   DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
    	   dbHandler.dropTable();
    	   Log.d(msg, "Rank Cleared (drop table)");
    }


    public int Champion(){
    	
    	   DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
    	   
    	   int champion = (dbHandler.findChampion());
    	   
		return champion;
    }
}

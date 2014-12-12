package com.example.pelicancross;

import java.util.LinkedList;
import java.util.List;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;


public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "playerDB.db";
	private static final String TABLE_PLAYERS = "players";
	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_PLAYERNAME = "playername";
	public static final String COLUMN_SPEED = "speed";
	
	public static final String[] COLUMNS = {COLUMN_ID,COLUMN_PLAYERNAME,COLUMN_SPEED};
	
	String msg = "Debugging MDBH: ";
	
	public DatabaseHandler(Context context, String name, 
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_PLAYERS_TABLE = "CREATE TABLE " +
	             TABLE_PLAYERS + "("
	             + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PLAYERNAME 
	             + " TEXT," + COLUMN_SPEED + " INTEGER" + ")";
	      db.execSQL(CREATE_PLAYERS_TABLE);
	     
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
		onCreate(db);
	}

	public void addPlayer(Player player) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_PLAYERNAME, player.getPlayerName());
        values.put(COLUMN_SPEED, player.getPlayerSpeed());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PLAYERS, null, values);
        db.close();
	}

	public Player findPlayer(String playername) {
		String query = "Select * FROM " + TABLE_PLAYERS + " WHERE " + COLUMN_PLAYERNAME + " =  \"" + playername + "\"";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		Player player = new Player();
		
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			player.setID(Integer.parseInt(cursor.getString(0)));
			player.setPlayerName(cursor.getString(1));
			player.setPlayerSpeed(Integer.parseInt(cursor.getString(2)));
			cursor.close();
		} else {
			player = null;
		}
		db.close();
		return player;
	}
	
	public boolean deletePlayer(String playername) {
		
		boolean result = false;
		
		String query = "Select * FROM " + TABLE_PLAYERS + " WHERE " + COLUMN_PLAYERNAME + " =  \"" + playername + "\"";

		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		Player player = new Player();
		
		if (cursor.moveToFirst()) {
			player.setID(Integer.parseInt(cursor.getString(0)));
			db.delete(TABLE_PLAYERS, COLUMN_ID + " = ?",
		            new String[] { String.valueOf(player.getID()) });
			cursor.close();
			result = true;
		}
		db.close();
		return result;
	}


	 public List<Player> getAllPlayers() {
		 
	       List<Player> players = new LinkedList<Player>();
	 
	       // 1. build the query
	       String query = "SELECT  * FROM " + TABLE_PLAYERS;
	 
	       // 2. get reference to writable DB
	       SQLiteDatabase db = this.getWritableDatabase();
	       Cursor cursor = db.rawQuery(query, null);
	 
	       // 3. go over each row, build book and add it to list
	       Player item = null;
	       if (cursor.moveToFirst()) {
	           do {
	        	   item = new Player();
	        	   item.setID(Integer.parseInt(cursor.getString(0)));
	        	   item.setPlayerName(cursor.getString(1));
	        	   item.setPlayerSpeed(cursor.getInt(2));
	        	    
	               // Add book to books
	               players.add(item);
	           } while (cursor.moveToNext());
	       }
	 
	       
	       return players;
	   }
	 
	 public void dropTable(){
		 
	      SQLiteDatabase db = this.getWritableDatabase();
	      db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
	      onCreate(db);
	    

		 	 	     
	}
	
		public int findChampion() {

			String query = "Select  MAX("+ COLUMN_SPEED + ") FROM " + TABLE_PLAYERS;

			SQLiteDatabase db = this.getWritableDatabase();
			
			Cursor cursor = db.rawQuery(query, null);
			
			cursor.moveToFirst();
			
			return cursor.getInt(0);
		}

	
}

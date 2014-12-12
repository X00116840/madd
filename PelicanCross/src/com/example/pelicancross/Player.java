package com.example.pelicancross;


public class Player {
	private int _id;
	private String _playername;
	private int _speed;

	public Player() {
		
	}
	
	public Player(int id, String playername, int speed) {
		this._id = id;
		this._playername = playername;
		this._speed = speed;
	}
	
	public Player(String playername, int speed) {
		this._playername = playername;
		this._speed = speed;
	}
	
	public void setID(int id) {
		this._id = id;
	}
	
	public int getID() {
		return this._id;
	}
	
	public void setPlayerName(String playername) {
		this._playername = playername;
	}
	
	public String getPlayerName() {
		return this._playername;
	}
	
	public void setPlayerSpeed(int speed) {
		this._speed = speed;
	}
	
	public int getPlayerSpeed() {
		return this._speed;
	}
	
	@Override
	public String toString(){
		return 	"Player [id = " + _id + " Player=" + _playername + ", speed=" + _speed + "]"; 
	}

}

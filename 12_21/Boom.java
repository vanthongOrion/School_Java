package game;

import java.util.*;

public class Boom{
	private int x,y;
	int[][] arr = MainGame.arr;
	int boomKey = MainGame.boomKey;
	int len = arr.length;

	public Boom(){
		this.init();
	}

	public void init(){
		Random ran = new Random();
		this.setX((ran.nextInt(len)));
		this.setY((ran.nextInt(len)));
		if(!MainGame.isEmpty(this.getX(),this.getY())){
			this.setX((ran.nextInt(len)));
			this.setY((ran.nextInt(len)));
		}
		arr[this.getX()][this.getY()] = -1; 
	}

	public int getX(){
		return  this.x;
	}

	public void setX(int x){
		this.x = x;
	}	

	public int getY(){
		return  this.y;
	}

	public void setY(int y){
		this.y = y;
	}

}
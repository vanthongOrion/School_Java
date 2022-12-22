package game;

import java.util.*;

public class Boom{
	private int x,y;
	int[][] arr = Ui.arr;
	int boomKey = Ui.boomKey;
	int len = arr.length;

	public Boom(){
		this.init();
		this.createRound();
	}

	public void init(){
		Random ran = new Random();
		this.setX((ran.nextInt(len)));
		this.setY((ran.nextInt(len)));
		if(this.isBoom(this.getX(),this.getY())){
			this.setX((ran.nextInt(len)));
			this.setY((ran.nextInt(len)));
		}
		arr[this.getX()][this.getY()] = this.boomKey; 
	}

	public void createRound(){
		int x = this.getX();
		int y = this.getY();
		for(int i=x-1;(i<(x+2))&&(i<len);i++){
			if(i<0) continue;
			for(int j=y-1;(j<(y+2))&&(j<len);j++){
				if(j<0) continue;
				if(!isBoom(i,j)){
					arr[i][j] += 1;
				}
			}
		}
	}
	
	public boolean isBoom(int x,int y){
		if(arr[x][y] == this.boomKey) {
			return true;
		}
		return false;
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


	public String toString(){
		return "{x=" + this.getX() + ",y=" + this.getY() + "}";
	}

}
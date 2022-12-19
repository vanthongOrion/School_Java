package game;

import java.util.*;
import java.lang.*;

public class Player {
	private String name;
	private int ownNum;
	private Map map;

	private final static int[][] arr = MainGame.arr;
	private final static int len = arr.length;
	private final static HashMap<Integer,HashMap<String,HashMap<Integer,Integer>>> loadMap= MainGame.loadMap;


	public Player(String name, int ownNum){
		this.setName(name);
		this.setOwnNum(ownNum);
		this.setMap(new Map(ownNum));
		this.autoLoad();
	}

	public Map getMap(){
		return this.map;
	}

	public void setMap(Map map){
		this.map = map;
	}

	public String getName(){
		return this.name;
	}	

	public int getOwnNum(){
		return this.ownNum;
	}	

	public void setName(String name){
		this.name = name;
	}

	public void setOwnNum(int ownNum){
		this.ownNum = ownNum;
	}	

	public String toString(){
		return "[PlayerName=" + this.getName() + ",OwnNum=" + this.getOwnNum() + "]";
	}

	public boolean isEmpty(int x, int y) {
		if(arr[x][y]!=0){
			return false;
		}
		return true;
	}
	
	public void play(Player rival){
		HashMap<String,ArrayList<Integer>> mapWarning = new HashMap<String,ArrayList<Integer>>();
		mapWarning = MainGame.checkWarning(rival);
		for(String i : mapWarning.keySet()){
			switch (i) {
			case "column" :
				ArrayList<Integer> values = new ArrayList<Integer>();
				values = mapWarning.get(i);
				for(int j = 0; j<values.size();j++){
					for(int n=0;n<arr.length;n++){
						if(arr[n][values.get(j)]==0){
							arr[n][values.get(j)]= this.getOwnNum();
							System.out.println("Player "+ this.getOwnNum() + " successfully wrote at [x=" + n + ",y=" + values.get(j) + "]"  );
							this.autoLoad();
							return;
						}
					}
				}
				break;
			case "row" :
				ArrayList<Integer> value = new ArrayList<Integer>();
				value = mapWarning.get(i);
				for(int j = 0; j<value.size();j++){
					for(int n=0;n<arr.length;n++){
						if(arr[value.get(j)][n]==0){
							arr[value.get(j)][n]= this.getOwnNum();
							System.out.println("Player "+ this.getOwnNum() +" successfully wrote at [x=" + value.get(j) + ",y=" + n + "]"  );
							this.autoLoad();
							return;
						}
					}
				}
				break;
			}
		}

		Random ran = new Random();
		int r = ran.nextInt(len);
		int c = ran.nextInt(len);
		while(isEmpty(r,c)==false){
			r = ran.nextInt(len);
			c = ran.nextInt(len);
		}

		arr[r][c] = this.getOwnNum();
		this.autoLoad();
		System.out.println("Player " + this.getOwnNum() + " successfully wrote at [x=" + r + ",y=" + c +"]" );
	}

	public void autoLoad(){
		loadMap.put(this.getOwnNum(),this.getMap().load());
	}

}
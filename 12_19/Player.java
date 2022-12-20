package game;

import java.util.*;
import java.lang.*;

public class Player {
	private String name;
	private int ownNum;
	private Map map;

	private int[][] arr = MainGame.arr;
	private int len = arr.length;
	private HashMap<Integer,HashMap<String,HashMap<Integer,Integer>>> loadMap= MainGame.loadMap;


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
	
	public void play(int num){
		if(this.attack()==false){
			if(this.defend(num)==false){
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
		}
	}

	public void autoLoad(){
		MainGame.loadMap.put(this.getOwnNum(),this.getMap().load());
	}

	public HashMap<String,ArrayList<Integer>> checkWarning(int num){
		HashMap<String,ArrayList<Integer>> warningMap = new HashMap<String,ArrayList<Integer>>();
		// int num = player.getOwnNum();
		for(String i: loadMap.get(num).keySet()){
			warningMap.put(i,new ArrayList<Integer>());
			for(int j: loadMap.get(num).get(i).keySet()){
				if(loadMap.get(num).get(i).get(j)==(len-1)){
					warningMap.get(i).add(j);
				}
			}
		}
		return warningMap;
	}

	public boolean defend(int num){
		HashMap<String,ArrayList<Integer>> mapWarning = new HashMap<String,ArrayList<Integer>>();
		mapWarning = this.checkWarning(num);
		for(String i : mapWarning.keySet()){
			switch (i) {
			case "column" :
				ArrayList<Integer> values1 = new ArrayList<Integer>();
				values1 = mapWarning.get(i);
				for(int j = 0; j<values1.size();j++){
					for(int n=0;n<len;n++){
						if(arr[n][values1.get(j)]==0){
							arr[n][values1.get(j)]= this.getOwnNum();
							System.out.println("Defending __ Player "+ this.getOwnNum() + " successfully wrote at [x=" + n + ",y=" + values1.get(j) + "]"  );
							this.autoLoad();
							return true;
						}
					}
				}
				break;
			case "row" :
				ArrayList<Integer> values2 = new ArrayList<Integer>();
				values2 = mapWarning.get(i);
				for(int j = 0; j<values2.size();j++){
					for(int n=0;n<len;n++){
						if(arr[values2.get(j)][n]==0){
							arr[values2.get(j)][n]= this.getOwnNum();
							System.out.println("Defending __ Player "+ this.getOwnNum() +" successfully wrote at [x=" + values2.get(j) + ",y=" + n + "]"  );
							this.autoLoad();
							return true;
						}
					}
				}
				break;
			case "crossDown" :
				ArrayList<Integer> values3 = new ArrayList<Integer>();
				values3 = mapWarning.get(i);
				for(int j = 0; j<values3.size();j++){
					if(arr[j][j]==0){
						arr[j][j]= this.getOwnNum();
						System.out.println("Defending __ Player "+ this.getOwnNum() +" successfully wrote at [x=" + j + ",y=" + j + "]"  );
						this.autoLoad();
						return true;
					}
				}
				break;

			case "crossUp" :
				ArrayList<Integer> values4 = new ArrayList<Integer>();
				values4 = mapWarning.get(i);
				for(int j = 0; j<values4.size();j++){
					if(arr[len-1-j][j]==0){
						arr[len-1-j][j]= this.getOwnNum();
						System.out.println("Defending __ Player "+ this.getOwnNum() +" successfully wrote at [x=" + (len-1-j) + ",y=" + j + "]"  );
						this.autoLoad();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean attack(){
		HashMap<String,ArrayList<Integer>> mapWarning = new HashMap<String,ArrayList<Integer>>();
		mapWarning = this.checkWarning(this.getOwnNum());
		for(String i : mapWarning.keySet()){
			switch (i) {
			case "column" :
				ArrayList<Integer> values1 = new ArrayList<Integer>();
				values1 = mapWarning.get(i);
				for(int j = 0; j<values1.size();j++){
					for(int n=0;n<len;n++){
						if(arr[n][values1.get(j)]==0){
							arr[n][values1.get(j)]= this.getOwnNum();
							System.out.println("Attacking __ Player "+ this.getOwnNum() + " successfully wrote at [x=" + n + ",y=" + values1.get(j) + "]"  );
							this.autoLoad();
							return true;
						}
					}
				}
				break;
			case "row" :
				ArrayList<Integer> values2 = new ArrayList<Integer>();
				values2 = mapWarning.get(i);
				for(int j = 0; j<values2.size();j++){
					for(int n=0;n<len;n++){
						if(arr[values2.get(j)][n]==0){
							arr[values2.get(j)][n]= this.getOwnNum();
							System.out.println("Attacking __ Player "+ this.getOwnNum() +" successfully wrote at [x=" + values2.get(j) + ",y=" + n + "]"  );
							this.autoLoad();
							return true;
						}
					}
				}
				break;
			case "crossDown" :
				ArrayList<Integer> values3 = new ArrayList<Integer>();
				values3 = mapWarning.get(i);
				for(int j = 0; j<values3.size();j++){
					if(arr[j][j]==0){
						arr[j][j]= this.getOwnNum();
						System.out.println("Attacking __ YPlayer "+ this.getOwnNum() +" successfully wrote at [x=" + j + ",y=" + j + "]"  );
						this.autoLoad();
						return true;
					}
				}
				break;

			case "crossUp" :
				ArrayList<Integer> values4 = new ArrayList<Integer>();
				values4 = mapWarning.get(i);
				for(int j = 0; j<values4.size();j++){
					if(arr[len-1-j][j]==0){
						arr[len-1-j][j]= this.getOwnNum();
						System.out.println("Attacking __ YYYPlayer "+ this.getOwnNum() +" successfully wrote at [x=" + (len-1-j) + ",y=" + j + "]"  );
						this.autoLoad();
						return true;
					}
				}
			}
		}
		return false;


	}

}
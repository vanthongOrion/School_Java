package game;

import java.util.*;

public class MainGame {
	final static HashMap<Integer,HashMap<String,HashMap<Integer,Integer>>> loadMap= new HashMap<Integer,HashMap<String,HashMap<Integer,Integer>>>();
	final static int len = 3;
	final static int[][] arr = new int[len][len];

	public static void main(String[] args){

		Player player1 = new Player("Player1",1);
		Player player2 = new Player("Player2",2);


		while(winCheck()==0){
			player1.play(player2.getOwnNum());
			player2.play(player1.getOwnNum());
		}

		System.out.println(winCheck());
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int winCheck(){
		for(int i : loadMap.keySet()){
			for(String j : loadMap.get(i).keySet()){
				for(int m : loadMap.get(i).get(j).keySet()){
					if(loadMap.get(i).get(j).get(m)==len){
						return i;
					}					
				}
			}
		}
		return 0;
	}

}
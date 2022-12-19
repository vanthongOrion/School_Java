package game;

import java.util.*;

public class Map {
	private int ownNum;

	public Map(int ownNum) {
		this.ownNum = ownNum;
	}

	private final static int[][] arr = MainGame.arr;

	public HashMap<String,HashMap<Integer,Integer>> load(){
	 	HashMap<String,HashMap<Integer,Integer>> map = new HashMap<String,HashMap<Integer,Integer>>();
		map.put("row",new HashMap<Integer,Integer>());
		map.put("column",new HashMap<Integer,Integer>());
		map.put("crossDown",new HashMap<Integer,Integer>());
		map.put("crossUp",new HashMap<Integer,Integer>());
		ownNum = this.ownNum;

		int countCrossUp = 0;
		int countCrossDown = 0;
		int len = arr.length;

		for(int i=0;i<arr.length;i++){
			//load row and column
			int countRow=0;
			int countColumn=0;		

			for(int j=0;j<arr[i].length;j++){
				//load row
				if(arr[i][j]==ownNum){
					countRow++;
				}

				//load column
				if(arr[j][i]==ownNum){
					countColumn++;
				}				

			}
				
				//load Cross
				if(arr[i][i]==ownNum){
					countCrossDown ++; 
				}				

				if(arr[len-i-1][i]==ownNum){
					countCrossUp ++; 
				}			

			map.get("row").put(i,countRow);
			map.get("column").put(i,countColumn);
		}
			map.get("crossDown").put(0,countCrossDown);
			map.get("crossUp").put(2,countCrossUp);

		return map;
	}

}
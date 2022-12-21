package game;

import java.util.*;

public class MainGame {
	public final static int len = 5;
	public final static int[][] arr = new int[len][len];
	public final static Array<Integer> arrBoom = new Array<Integer>();
	public final static int boomKey = -1;

	public static void main(String[] args){

		Boom b1 = new Boom();
		Boom b2 = new Boom();
		Boom b3 = new Boom();






	for(int i=0;i<len;i++){
		for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean isEmpty(int x, int y){
		if(arr[x][y] != 0){
			return false;
		}
		return true;
	}

	public static boolean isBoom(int x, int y){
		if(arr[x][y] == boomKey){
			return true;
		}
		return false;
	}

	public static void createRound(){

	} 

	public void createBoom(){
		Random ran = new Random();
		int x = ran.nextInt(len);
		int y = ran.nextInt(len);
		if(!isEmpty(x,y)){
			x = ran.nextInt(len);
			y = ran.nextInt(len);
		}
		arr[this.getX()][this.getY()] = boomKey; 
	}

}
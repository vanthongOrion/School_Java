package game;

import java.util.*;

public class Ui {
	private final static int len = 6;
	protected final static int[][] arr = new int[len][len];
	protected final static int boomKey = -1;
	protected final static String[][] uiArr = new String[len][len];
	protected final static int unLookedKey = 9;

	public static void init(){
		for(int i=0;i<uiArr.length;i++){
			for(int j=0;j<uiArr[i].length;j++){
				uiArr[i][j] = "-";
			}
		}
	}

	public static int checkPos(int x, int y){
		return arr[x][y];
	}

	public static void setStr(int x,int y, String str){
		uiArr[x][y] = str;
	}

	public static void setInt(int x, int y, int num){
		arr[x][y] = num;
	}

	public static void unLook(int x,int y){
		uiArr[x][y] = "0";
		for(int i=x-1;(i<(x+2))&&(i<len);i++){
			if(i<0) continue;
			for(int j=y-1;(j<(y+2))&&(j<len);j++){
				if(j<0||arr[i][j]==9) continue;
				if(arr[i][j]== 0){
					arr[i][j] = 9;
					uiArr[i][j] = "0";
					unLook(i,j);
				}else{
					if(isEmpty(i,j)){
						uiArr[i][j] = Integer.toString(arr[i][j]);
					}
				}

			}
		}
	}

	public static void markBoom(int x,int y){
		if(uiArr[x][y]== "-") {
			uiArr[x][y] = "?";
		}
			printUiArr();
	}

	public static void reMark(int x, int y){
		if(uiArr[x][y]=="?"){
			uiArr[x][y] = "-";
		}
		printUiArr();
	}
	public static boolean isEmpty(int x, int y){
		if(uiArr[x][y] != "-") return false;
		return true;
	}

	public static void printUiArr(){
		for(int i=0;i<uiArr.length;i++){
			for(int j=0;j<uiArr[i].length;j++){
				System.out.print(uiArr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void printArr(){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean isWon(){
		for(int i=0;i<uiArr.length;i++){
			for(int j=0;j<uiArr[i].length;j++){
				if(uiArr[i][j]=="-"){
					if(arr[i][j]!= boomKey) return false;
				}
			}
		}
		System.out.println("You are won\n Congratulation");
		printArr();
		return true;

	}

}
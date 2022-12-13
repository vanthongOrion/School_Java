package game;

import java.util.*;

public class Player {
	int ownNum;
	String name;

	public Player(String name, int ownNum){
		this.name = name;
		this.ownNum = ownNum;
	}

	Random ran = new Random();
	static int point1 = 0;
	static int point2 = 0;

	public boolean isValueNotSetAt(int[][] arr,int r,int c){
		if(arr[r][c]==0) return true;
		return false;
	}

	public boolean isFull(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]==0) return false;
			}
		}
		return true;
	}

	public boolean insertCheck(int[][] arr){
		int r,c;

		r = ran.nextInt(3);
		c = ran.nextInt(6);

		if(isValueNotSetAt(arr,r,c)){
			arr[r][c]= this.ownNum;
			System.out.println("Player '" + this.name + "' successfully wrote at (" + r +  "," + c + ")");
			return true;
		} 

		System.out.println("Player '" + this.name + "' NOT successfully wrote at (" + r +  "," + c + ")");
		return false;
	}

	public void insert(int[][] arr){
		boolean isDone = false;
		if(isFull(arr)){
			System.out.println("Array is full. Cannot insert anymore ");
		}else{
			do{
			isDone = insertCheck(arr);
			}while(isDone == false);
		}
	}

	public static void checkPointRow(int[][] arr){
		for(int i=0;i<arr.length;i++){
			boolean hasPoint = true;
			int a = arr[i][0];

			for(int j=1;j<arr[i].length;j++){
				if(a != arr[i][j]){
					hasPoint = false;
					break;
				}
			}	

			if(hasPoint){
				System.out.println("Have point at row " + i + " for player" + a);
				if(a==1){
					point1 += 1;
				}else{
					point2 += 1;
				}
			}
		}
	}	

	public static void checkPointColumn(int[][] arr){
		for(int j=0;j<arr[0].length;j++){
			boolean hasPoint = true;
			int a = arr[0][j];

			for(int i=0;i<arr.length;i++){
				if(a != arr[i][j]){
					hasPoint = false;
					break;
				}
			}	

			if(hasPoint){
				System.out.println("Have point at column " + (j+1) + " for player " + a);
				if(a==1){
					point1 += 1;
				}else{
					point2 += 1;
				}
			}
		}
	}

	public static void checkPointDiagona(int[][] arr){
		int halfLen = arr[0].length-2;
		for(int i=0;i<halfLen;i++){
			boolean hasPoint1 = true;
			boolean hasPoint2 = true;
			int a = arr[0][i];
			int b = arr[2][i];
			int m = i;
			int e = i;
			
			for(int n=1;n<arr.length;n++){
				m++;
				if(arr[n][m]!= a){
					hasPoint1 = false;
					break;
				}
			}

			if(hasPoint1){
				System.out.println("Have point from arr[0," + i + "] for player " + a );
				if(a==1){
					point1 += 1;
				}else{
					point2 += 1;
				}
			}			

			for(int w=1;w>= 0;w--){
				e++;
				if(b != arr[w][e]){
					hasPoint2 = false;
					break;
				}
			}

			if(hasPoint2){
				System.out.println("Have point from bottom[2," + i + "] for player " + b );
				if(b==1){
					point1 += 1;
				}else{
					point2 += 1;
				}
			}
		}
	} 

	public static void checkPoint(int[][] arr){
		checkPointRow(arr);
		checkPointColumn(arr);
		checkPointDiagona(arr);

		System.out.println("point1= " + point1 );
		System.out.println("point2= " + point2 );
	}

	public static void printArray(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}


}
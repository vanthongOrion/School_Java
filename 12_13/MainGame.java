package game;

import java.util.*;

public class MainGame {
	public static void main(String[] args){
		int[][] arr = new int[3][6];

		Player player1 = new Player("thong",1);
		Player player2 = new Player("minh",2);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);		

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		player1.insert(arr);
		player2.insert(arr);

		Player.printArray(arr);
		Player.checkPoint(arr);
	}
}
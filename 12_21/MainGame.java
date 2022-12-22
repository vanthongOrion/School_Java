package game;

import java.util.*;

public class MainGame {
	private final static int unLookedKey = Ui.unLookedKey;

	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		Boom b1 = new Boom();
		Boom b2 = new Boom();
		Boom b3 = new Boom();
		Boom b4 = new Boom();

		Ui.init();
		int x,y,request;
		do{
			System.out.println("To Mark Boom, press 3\nTo Remark Boom press 2\nTo Play press 1");
			request = scn.nextInt();
			if(request==3){
				System.out.print("Mark at x=");
				x = scn.nextInt();
				System.out.print(",y=");
				y = scn.nextInt();
				Ui.markBoom(x,y);
			}else if(request==2){
				System.out.print("Mark at x=");
				x = scn.nextInt();
				System.out.print(",y=");
				y = scn.nextInt();
				Ui.reMark(x,y);
			}else if(request==1){
				System.out.print("Select at x=");
				x = scn.nextInt();
				System.out.print(",y=");
				y = scn.nextInt();
				if(selectAt(x,y)==-1){
					break;
				}
			}else{
				System.out.println("Syntax error");
			}
		}while(!Ui.isWon());
	}

	public static int selectAt(int x, int y){
		if(Ui.checkPos(x,y)==-1){
			System.out.println("This is Boom, Game over");
			Ui.setStr(x,y,"BOOM");
			Ui.printUiArr();
			return -1;
		}
		if(Ui.checkPos(x,y)== 0){
			System.out.println("Congratulation. This is blank cell");
			Ui.setInt(x,y,unLookedKey);
			Ui.unLook(x,y);
			Ui.printUiArr();
			return 1;
		}
		if(Ui.checkPos(x,y)!= unLookedKey){
			System.out.println("This is " + Ui.checkPos(x,y));
			Ui.setStr(x,y,Integer.toString(Ui.checkPos(x,y)));
			Ui.printUiArr();
			return 1;
		}
		Ui.printUiArr();
		return 1;
	}
}
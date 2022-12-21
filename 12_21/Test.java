
public class Test {
	final static int len = 5;
	final static int[][] arr = new int[len][len];

	public static void main(String[] args){
		int x=1;
		int y=1;
		int x1=2;
		int y1=3;
		int x3=3;
		int y3=2;

		arr[x][y] = -1;
		arr[x1][y1] = -1;
		arr[x3][y3] = -1;

	for(int i=x-1;(i>=0)&&(i<(x+2)&&(x<len));i++){
		for(int j=y-1;(j>=0)&&(j<(y+2)&&(j<len));j++){
			if(!isBoom(i,j)){
				arr[i][j] += 1;
			}
		}
	}	

	for(int i=x1-1;(i>=0)&&(i<(x1+2)&&(x1<len));i++){
		for(int j=y1-1;(j>=0)&&(j<(y1+2)&&(y1<len));j++){
			if(!isBoom(i,j)){
				arr[i][j] += 1;
			}
		}
	}
	for(int i=x3-1;(i>=0)&&(i<(x3+2)&&(x3<len));i++){
		for(int j=y3-1;(j>=0)&&(j<(y3+2)&&(y3<len));j++){
			if(!isBoom(i,j)){
				arr[i][j] += 1;
			}
		}
	}

	for(int i=0;i<len;i++){
		for(int j=0;j<arr[i].length;j++){
			System.out.print(arr[i][j] + "\t");
		}
		System.out.println();
	}


	}


	public static boolean isBoom(int x, int y){
		if(arr[x][y] == -1){
			return true;
		}
		return false;
	}
}
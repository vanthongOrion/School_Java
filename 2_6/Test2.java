public class Test2 {
	public static void main(String[] args) {
		for (int i=0; i < 3;i++) {
			int x = 10;
			int y = 10;
			for (int j=0; j < 3; j++) {
				System.out.println("x=" + (x+(j*100)));
				System.out.println("y=" + (x+(i*100)));
			}
			System.out.println("----------");
		}
	}
}
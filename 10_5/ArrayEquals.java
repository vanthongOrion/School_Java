import java.util.*;

public class ArrayEquals {
	public static void main (String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {1, 2, 3, 4, 5};

		System.out.println(a.equals(b));
		System.out.println(Arrays.equals(a, b));

	}
}
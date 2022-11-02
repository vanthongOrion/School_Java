package mondai;

import java.text.*;
import java.util.*;

public class MainBook {
	public static void main(String[] args) {
		String formatDate = "yyyy-MM-dd";
		SetUpDate set = new SetUpDate();
		Date d1 = set.setDate(formatDate,"2022-11-03");
		Date d2 = set.setDate(formatDate,"2022-11-02");

		Book b1 = new Book();
		b1.setTitle("book");
		b1.setPublishDate(d1);	
		System.out.println(b1.getPublishDate());	

		Book b2 = new Book();
		b2.setTitle("book");
		b2.setPublishDate(d2);
		System.out.println(b2.getPublishDate());
		
		System.out.println(b1.equals(b2));

	}
}
package mondai;

import java.text.*;
import java.util.*;

public class MainBook {
	public static void main(String[] args) {
		String formatDate = "yyyy-MM-dd";
		SetUpDate set = new SetUpDate();
		Date d1 = set.setDate(formatDate,"2022-11-09");
		Date d2 = set.setDate(formatDate,"2022-11-04");
		Date d3 = set.setDate(formatDate,"2022-11-06");
		Date d4 = set.setDate(formatDate,"2022-11-05");


		// System.out.println(d1.compareTo(d2));


		Book b1 = new Book();
		b1.setTitle("thong");
		b1.setPublishDate(d1);		

		Book b2 = new Book();
		b2.setTitle("thuyet");
		b2.setPublishDate(d2);


		Book b3 = new Book();
		b3.setTitle("anh");
		b3.setPublishDate(d3);	

		Book b4 = new Book();
		b4.setTitle("binh");
		b4.setPublishDate(d4);	


		//using hashcode to asign value

		// Set<Hero> list = new HashSet<>();
		// list.add(b1);
		// list.add(b2);

		//using sort method of collection to sort ArrayList through super of Comparator 
		// List<Book> list = new ArrayList<>();
		// list.add(b1);
		// list.add(b2);
		// list.add(b3);
		// list.add(b4);	
		// Collections.sort(list, new DateComparator());

		//using treeset to sort through Compartor

		// TreeSet<Book> tree = new TreeSet<>(new DateComparator());
		// tree.add(b1);
		// tree.add(b2);
		// tree.add(b3);
		// tree.add(b4);

		//using clone() - deep copy

		// Book bClone = b1.clone();
		// bClone.setTitle("newBook");
		// System.out.println(b1);
		// System.out.println(bClone);

		//sort with title as comparator
		List<Book> list2 = new ArrayList<>();
		list2.add(b1);
		list2.add(b2);
		list2.add(b3);
		list2.add(b4);

		Collections.sort(list2, new TitleComparator());

		System.out.println(list2);

	}
}
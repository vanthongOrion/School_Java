package lesson2;

import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainBook {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Book b1 = new Book();
		b1.setTitle("7effect");
		b1.setPublishDate(format.parse("1986-12-30"));
		List<Book> list = new ArrayList<>();
		list.add(b1);
		System.out.println("Size of list before remove :" + list.size());
		b1 = new Book();
		b1.setTitle("7effect");
		b1.setPublishDate(format.parse("1986-12-30"));
		list.remove(b1);
		System.out.println("Size of list after remove :" + list.size());
	}
}
package lesson1;

import java.util.*;

public class MainLesson1 {
	public static void main(String[] args){
		List<Account> list = new ArrayList<>();
		Account ac1 = new Account();
		ac1.number = 3333;
		Account ac2 = new Account();
		ac2.number = 2222;
		Account ac3 = new Account();
		ac3.number = 1111;
		list.add(ac1);
		list.add(ac2);
		list.add(ac3);
		Collections.sort(list);
		for(Account a: list){
			System.out.println(a.number);
		}
	}
}
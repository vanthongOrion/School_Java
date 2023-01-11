package lesson2;

import lesson1.Account;
import java.util.*;

public class MainLesson2 {
	public static void main(String[] args){
		List<Account> list = new ArrayList<>();
		Account ac1 = new Account();
		ac1.number = 1;
		ac1.zandaka = 9999; 		
		Account ac2 = new Account();
		ac2.number = 2;
		ac2.zandaka = 3333; 		
		Account ac3 = new Account();
		ac3.number = 3;
		ac3.zandaka = 8888;
		list.add(ac1); 
		list.add(ac2); 
		list.add(ac3);

		Collections.sort(list,new ZandakaComparator());

		for(Account a : list){
			System.out.println(a.number);
		}
	}
}
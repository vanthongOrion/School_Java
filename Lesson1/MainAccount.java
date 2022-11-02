package bank;

import java.util.*;

public class MainAccount {
	public static void main(String[] args) {

		Account ac1 = new Account();
		ac1.accountNo = "ac1";
		ac1.number = 300;
		ac1.zandaka = 400;
		Account ac2 = new Account();
		ac2.accountNo = "ac2";
		ac2.number = 200;
		ac2.zandaka = 300;

		//using collectins.sort to sort list

		// List<Account> list = new ArrayList<>();
		// list.add(ac1);
		// list.add(ac2);

		// Collections.sort(list, new ZandakaComparator());
		// System.out.println(list);


		//using treeset to sort list through ZandakaComparator
		// TreeSet<Account> accounts1 = new TreeSet<>();
		// accounts1.add(ac1);
		// accounts1.add(ac2);

		// System.out.println(accounts1);

		TreeSet<Account> accounts2 = new TreeSet<>(new ZandakaComparator());
		accounts2.add(ac1);
		accounts2.add(ac2);
		System.out.println(accounts2);



		
	}
}
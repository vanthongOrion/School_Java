package bank;

import java.util.*;

public class MainAccount {
	public static void main(String[] args) {

		Account ac1 = new Account();
		ac1.accountNo = "ac1";
		ac1.number = 300;
		ac1.zandaka = 200;
		Account ac2 = new Account();
		ac2.accountNo = "ac2";
		ac2.number = 200;
		ac2.zandaka = 300;

		List<Account> list = new ArrayList<>();
		list.add(ac1);
		list.add(ac2);

		Collections.sort(list, new ZandakaComparator());
		System.out.println(list);



		
	}
}
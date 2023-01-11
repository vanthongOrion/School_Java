package lesson2;

import java.util.Comparator;
import lesson1.Account;

public class ZandakaComparator implements Comparator<Account>{
	public int compare(Account x, Account y) {
		return (x.zandaka - y.zandaka);
	}
}
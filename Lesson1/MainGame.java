package game;

import bank.Account;

public class MainGame {
	public static void main(String[] args) {
		Account a = new Account();
		Account b = new Account();

		a.accountNo = "a";
		b.accountNo = "b";

		System.out.println(a.equals(b));

	} 
}
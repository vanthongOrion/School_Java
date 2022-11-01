package bank;

public class MainAccount {
	public static void main(String[] args) {
		Account ac1 = new Account();
		ac1.accountNo = "ac1";
		Account ac2 = new Account();
		ac2.accountNo = "ac1";

		System.out.println(ac1.equals(ac2));

		
	}
}
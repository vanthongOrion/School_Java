package bank;

public class Account  implements Comparable<Account> {
	public String accountNo;
	public int number;
	public int zandaka;

	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Account)) return false;
		Account r = (Account) o;
		if (!this.accountNo.trim().equals(r.accountNo.trim())) {
			return false;
		}
		return true;
	}

	public int compareTo(Account o){
		if (this.number < o.number){
			return -1;
		}
		if (this.number > o.number) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString(){
		return "Account=[accountNo=" + this.accountNo + ",number=" + this.number + ",zandaka=" + this.zandaka + "]";
	}
}

package lesson1;

public class Account implements Comparable<Account>{
	public int number;
	public int zandaka;
	public int compareTo(Account o){
		if (this.number < o.number) {
			return -1;
		}
		if (this.number > o.number) {
			return 1;
		}
		return 0;
	}
}
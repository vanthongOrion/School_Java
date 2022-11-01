package game;

public class Hero {
	public String name;

	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Hero)) return false;
		Hero h = (Hero) 

		if (!(o.name.trim().equals(this.name.trim()))) return false;

	}
	
}
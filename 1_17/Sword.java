package lesson1;

public class Sword implements Cloneable {
	private String name;

	public Sword(){};

	public Sword(String name) {
		this.setName(name);
	}

	public Sword clone(){
		Sword result = new Sword();
		result.name = this.name;
		return result;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
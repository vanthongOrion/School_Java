package game;

public class Sword implements Cloneable{
	private String name;

	public Sword(String name) {
		this.name = name;
	}

	public Sword(){
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	@Override
	public Sword clone(){
		Sword s = new Sword();
		s.setName(this.getName());
		return s;
	}

	@Override
	public String toString(){
		return "Sword=[name=" + this.getName() + "]";
	}
}
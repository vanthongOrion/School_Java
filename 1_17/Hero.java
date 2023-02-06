package lesson1;

public class Hero implements Cloneable {
	private String name;
	private int hp;
	private Sword sword;

	public Hero(){

	}

	public Hero(String name) {
		this.setName(name);
	}

	public Hero clone() {
		Hero result = new Hero();
		result.name = this.name;
		result.hp = this.hp;
		result.sword = this.sword.clone();
		return result;		
	}

	public String getName() {
		return this.name;
	}

	public int getHp() {
		return this.hp;
	}

	public Sword getSword() {
		return this.sword;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
	}

}
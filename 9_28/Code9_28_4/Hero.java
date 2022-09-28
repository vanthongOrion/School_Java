
public class Hero {
	private String name;
	private int hp;
	
	public Hero(String name, int hp) {
		this.setName(name);
		this.setHp(hp);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		return "Hero={name=" + this.getName() + ",HP=" + this.getHp() + "}";
 	} 
	
}

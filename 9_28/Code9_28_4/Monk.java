
public class Monk {
	private String name;
	private int hp;
	
	public Monk(String name, int hp) {
		this.setHp(hp);
		this.setName(name);
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
	
	
}

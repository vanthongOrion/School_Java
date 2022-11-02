package game;

public class Hero implements Cloneable{
	private String name;
	private int hp;
	private Sword sword;

	public Hero(String name, int hp, Sword s){
		this.setName(name);
		this.setHp(hp);
		this.setSword(s);
	}

	public Hero(String name){
		this.setName(name);
	}

	public Hero(){

	}

	public Hero clone() {
		Hero result = new Hero();
		result.setName(this.getName());
		result.setHp(this.getHp()) ;
		result.setSword(this.getSword().clone());
		return result;
	}


	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Hero)) return false;

		Hero h = (Hero) o;
		if (!this.name.trim().equals(h.name.trim())) {
			return false;
		}
		return true;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp(){
		return this.hp;
	}

	public void setSword(Sword s){
		this.sword = s;
	}

	public Sword getSword(){
		return this.sword;
	}

	@Override
	public String toString(){
		return "Hero={name=" + this.getName() + ",Hp=" + this.getHp() + ",Sword=" + this.getSword() + "]";
	}
}
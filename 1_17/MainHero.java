package lesson1;

public class MainHero {
	public static void main(String[] args) {
		Hero h1 = new Hero("minato");
		Sword s = new Sword("hagane");

		h1.setSword(s);
		System.out.println("sword=" + h1.getSword().getName());
		System.out.println("clone by clone() method");
		Hero h2 = h1.clone();

		System.out.println("Change the name of original sword ");
		h1.getSword().setName("hinoki");
		System.out.println("Original sword is: " + h1.getSword().getName() + 
			"\n The new Sword is :" + h2.getSword().getName());
	}
}
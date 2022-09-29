
import java.util.*;


public class NestMain {

	public static void main(String[] args) {


		Hero hero1 = new Hero("ミナト",2000);
		Hero hero2 = new Hero("朝霞", 6000);
		Hero hero3 = new Hero("すがわら", 10000);
		
		ArrayList<Hero> heroes = new ArrayList<>();	
		
		heroes.add(hero1);
		heroes.add(hero2);
		heroes.add(hero3);
		
		
		Map<String, ArrayList<Hero>> group = new HashMap<>();
		System.out.println(group.entrySet());
		
		// group.put("グルップ", heroes);
		// System.out.println(group.keySet());
		// hero1.setName("tanaka");
		
		// for (String k: group.keySet()) {
		// 	ArrayList<Hero> h = group.get(k);
			
		// 	for(Hero hero: h) {
		// 		System.out.println(hero.getName());
		// 	}
		// }
		
	}
}

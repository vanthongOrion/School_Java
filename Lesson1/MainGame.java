package game;

import bank.Account;
import java.util.*;

public class MainGame {
	public static void main(String[] args) {

		//remove with hashset
		// Set<Hero> list = new HashSet<>();
		// Hero h1 = new Hero();
		// h1.name = "ミナト";
		// list.add(h1);
		// System.out.println("要素数=" + list.size());
		// h1 = new Hero();
		// h1.name = "ミナト";
		// list.remove(h1);
		// System.out.println("要素数=" + list.size());

		// clone Hero with Coloneable and compare 
		// Hero h1 = new Hero("ミナト");
		// Hero h2 = h1.clone();

		// System.out.println(h1.equals(h2));

		//Clone hero without cloning sword and cloning sword
		Hero h1 = new Hero("ミナト");
		Sword s = new Sword("はがねのケン");

		h1.setSword(s);
		System.out.println("装置：" + h1.getSword().getName());
		System.out.println("clone()で複製します");
		Hero h2 = h1.clone();

		System.out.println("コビー元の勇者の剣の名前を変えます");
		h1.getSword().setName("ひのきの棒");
		System.out.println("コビー元とコピーの装置を表示します");
		System.out.println("コピー元：" + h1.getSword().getName() + "\nコピー先：" + h2.getSword().getName());
	} 
}

public class CynWaterHorse extends Monster {
	
	public CynWaterHorse() {
		super();
		name = "Cynical Water Horse";
		monsterID = "M06";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("Magic Key");
		healthPoints = 200;
		// some monster abilities thing
		monsterDesc = "You come across a strange hobble and hear cackling nearby."
				+ " You notice a large pot boiling and turn to notice the most beautiful"
				+ " woman you’ve ever seen. She attempts to lure you into the pot, but"
				+ " you catch the trick. The witch reveals her nasty face as the spell is removed.";
	}

	public void FirstAttack(Player p) {
		String attackName = "Waterspout";
		double attackDmg = 35;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Submerge";
		super.invulnerable = true;
		System.out.println(name + " has used " + attackName + ". It will be immune to your attacks next turn!");
	}
	
	public void ThirdAttack(Player p) {
		String attackName = "Bite";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
}

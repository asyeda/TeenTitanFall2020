
public class WoodlandWitch extends Monster {
	public WoodlandWitch() {
		super();
		name = "Woodland Witch";
		monsterID = "M07";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("Resurrection Scroll");
		healthPoints = 150;
		// some monster abilities thing
		monsterDesc = "You come across a strange hobble and hear cackling nearby."
				+ " You notice a large pot boiling and turn to notice the most beautiful"
				+ " woman you’ve ever seen. She attempts to lure you into the pot, but"
				+ " you catch the trick. The witch reveals her nasty face as the spell is removed.";
	}

	public void FirstAttack(Player p) {
		String attackName = "Fireball";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		/*
		 * if player has fire resistance, attack has no effect --> display to user
		 */
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Ice Spike";
		double attackDmg = 35;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
	}
	
}

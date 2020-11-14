
public class TheDoctor extends Monster{
	public TheDoctor() {
		super();
		name = "The Doctor";
		monsterID = "M03";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("Doctor's Syringe");
		healthPoints = 150;
		// some monster abilities thing
		monsterDesc = "The Doctor towers above most with a height of 6’3”. His raggedy white coat reeks of death"
				+ " and decay. Known as a dangerous man, it would be unwise to approach him. Many of his patients"
				+ " have been known to disappear. ";
	}
	public void FirstAttack(Player p) {
		String attackName = "Bone Saw Slash";
		double attackDmg = 35;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Confuse";
		p.confuse();
		System.out.println(name + " has used " + attackName);
	}
	
	public void ThirdAttack(Player p) {
		String attackName = "Roundhouse Kick";
		double attackDmg = 30;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
}

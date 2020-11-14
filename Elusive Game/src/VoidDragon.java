
public class VoidDragon extends Monster {
	public VoidDragon() {
		super();
		name = "Void Dragon";
		monsterID = "M04";
		//super.itemDrops = new Item[1];
		//no items dropped (releases Dad of protagonist and game ends)
		healthPoints = 300;
		// some monster abilities thing
		monsterDesc = "This appears to be the beast who abducted your father. It glows red with golden scales,"
				+ " impenetrable with any regular weapon. It appears to breathe some sort of void fire. "
				+ "I would need some sort of magical armor before tending to this enemy." ;
		flyingEnemy = true;
	}
	
	public void FirstAttack(Player p) {
		String attackName = "Void Blast";
		double attackDmg = 70;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Tail Slash";
		double attackDmg = 50;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
	}
	
	public void ThirdAttack(Player p) {
		String attackName = "Roar";
		System.out.println(name + " has used " + attackName);
		System.out.println("Your attack become slightly weaker!");
		damageReduction = true;
	}
}

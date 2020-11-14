
public class Cerberus extends Monster{
	public Cerberus() {
		super();
		name = "Cerberus";
		monsterID = "M02";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("3-Skull Crown");
		healthPoints = 200;
		// some monster abilities thing
		monsterDesc = "A giant 15-foot 3 headed canine sleeps on the floor. The beast is chained, "
				+ "but clearly dangerous. It breathes smoke and has a light blue glow, although its "
				+ "fur is pitch black. It would be best not to approach unless properly prepared.";
	}
	public void FirstAttack(Player p) {
		String attackName = "Maul";
		double attackDmg = 50;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Chain Slam";
		double attackDmg = 30;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	public void ThirdAttack(Player p) {
		String attackName = "Terrify";
		double attackDmg = 2;
		System.out.println(name + " has used " + attackName);
		System.out.println("You are too terrified to attack!");
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
		p.terrified = true;
	}
}


public class PosKnightArm extends Monster {
	
	public PosKnightArm() {
		super();
		name = "Possessed Knight Armor";
		monsterID = "M05";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("Royal Knight Armor");
		healthPoints = 200;
		// some monster abilities thing
		monsterDesc = "The soul of a deceased knight possesses this armor. The spirit of the knight left its body"
				+ " violently and involuntarily. The knight armor sputters around wielding a large metal mace, too heavy"
				+ " for any normal being to wield.";
		flyingEnemy = true;
	}

	public void FirstAttack(Player p) {
		String attackName = "Bash";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Sword Boomerang";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		int randomAttackNum = super.rand.nextInt(10) + 1;
		int randomReAttackNum = super.rand.nextInt(10) + 1;
		
		if (randomAttackNum < 9) {
			p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
			if (randomReAttackNum < 4) {
				p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
				System.out.println("The " + attackName + " returns and hits you dealing more damage!");
			}
		}
		else {
			System.out.print("The " + attackName + "missed you as " + name + "threw it" );
			if (randomReAttackNum < 4) {
				p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
				System.out.println(" but it returns and hits you dealing damage!");
			}
		}
		
		damagedHealth = p.getCurrentHealth();
	}
}

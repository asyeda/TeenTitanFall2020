import java.util.ArrayList;
import java.util.Scanner;

public class Blacksmith extends NPC {
	public Blacksmith() {
		npcID = "N02";
		npcName = "Blacksmith";
		npcDesc = "Hey Adventurer, welcome to my smithy. Take a look around, you can buy or sell items here.";
		sales = new ArrayList<>();
	}


	@Override
	public void talkTo(Player p) {
		System.out.println(npcDesc);
		System.out.println("What do you want to do?");
		System.out.println(">Buy\n>Sell\n>Exit");
		Scanner scan = new Scanner(System.in);
		String playerResponse = scan.nextLine();
		while(!playerResponse.equalsIgnoreCase("exit")) {
			if(playerResponse.equalsIgnoreCase("sell")) {
				sell(p);
			}
			
			else if(playerResponse.equalsIgnoreCase("buy")){
				buy(p);
			}
			
			else {
				System.out.println("invalid response");
			}
			
			System.out.println("What do you want to do?");
			System.out.println(">Buy\n>Sell\n>Exit");
			playerResponse = scan.nextLine();
		}
	}
	
	public void sell(Player p) {
		p.playerInventory();
		Scanner scan = new Scanner(System.in);
		System.out.println("What do you want to sell?");
		String item = scan.nextLine();
		
		if(item.equalsIgnoreCase("potion") || item.equalsIgnoreCase("health potion")) {
			p.sellPotion();
			return;
		}
		
		for(int i = 0; i < p.getPlayerInventory().size(); i++) {

			if(p.getPlayerInventory().get(i).getItemName().equalsIgnoreCase(item)) {
				if(p.getPlayerInventory().get(i).getSellValue() < 0) {
					System.out.println("That item isn't sellable!");
					return;
				}
				System.out.println("You sold " + p.getPlayerInventory().get(i).getItemName());
				p.coins += p.getPlayerInventory().get(i).getSellValue();
				System.out.println("You earned " + p.getPlayerInventory().get(i).getSellValue() + " Elusive Coins");
				p.getPlayerInventory().remove(p.getPlayerInventory().get(i));
				return;
			}
			
		}
		
		
		System.out.println("This isn't in your inventory");
	}
	
	public void buy(Player p) {
		System.out.println("Items for sale: ");
		for(Items i: sales) {
			System.out.println(i.getItemName() + " - " + i.getSellValue() + " Elusive Coins");
		}
		System.out.println("What do you want to buy?");
		Scanner s = new Scanner(System.in);
		String item = s.nextLine();
		
		if(item.equalsIgnoreCase("potion")) {
			if(p.coins >= 5) {
				p.potions += 1;
				p.coins -= 5;
				return;
			}
		}
		
		for(Items i: sales) {
			if(item.equalsIgnoreCase(i.getItemName())) {
				if(p.coins >= i.getSellValue()) { //FIX BUY VALUE FOR ITEM
					System.out.println("You bought " + i.getItemName());
					p.getPlayerInventory().add(i);
					p.coins -= i.getSellValue();
					return;
				}
				else {
					System.out.println("You don't have enough coins");
					return;
				}
			}
		}
		System.out.println("That item does not exist in the shop.");
	}
}

import java.util.ArrayList;
public abstract class NPC 
{
	protected String npcID;
	protected String npcName;
	protected String npcDesc;
	protected boolean potions = false;
	protected ArrayList<Items> sales;
	
	public ArrayList<Items> getSales() {
		return sales;
	}
	
	public void setPotions(boolean potions) {
		this.potions = potions;
	}


	public String getNpcID() {
		return npcID;
	}


	public String getNpcName() {
		return npcName;
	}


	public String getNpcDesc() {
		return npcDesc;
	}
	
	public abstract void talkTo(Player p);


}
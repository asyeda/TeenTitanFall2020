import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Map {
	private ArrayList<Room> room;

	public Map() throws FileNotFoundException{
		room = new ArrayList<Room>();
			readMap("map.txt");
			readMonster("monster.txt");
			readPuzzle("puzzle.txt");
			readNPC("NPC.txt");
			readItem("items.txt");
	}

	public Map(ArrayList<Room> room) {
		this.room = room;
	}
	
	
	
	public ArrayList<Room> getRoom() {
		return room;
	}


	public void readMap(String mapFile) throws FileNotFoundException{
		FileReader mapReader;
		Scanner in;
		try {
			mapReader = new FileReader(mapFile);
			in = new Scanner(mapReader);
			String[] number;
			while(in.hasNextLine()) {
				
				number = in.nextLine().split(",");
				room.add(new Room(number[0],number[1],number[2],Boolean.parseBoolean(number[3]), number[4], number[5], number[6], number[7]));

			}
			in.close();
		
		}
		catch(FileNotFoundException e) {
			System.out.println("Wrong file. Retry!");
		}
	}
	
	public void readNPC(String itemFile) throws FileNotFoundException{
		FileReader itemReader;
		Scanner in;
		try {
			itemReader = new FileReader(itemFile);
			in = new Scanner(itemReader);
			String[] number;
			while(in.hasNextLine()) {
				number = in.nextLine().split(",");
				
				if(number[0].equals("N01")) {
					for(Room r: room) {
						if (r.getRoomID().equals(number[1])) {
							r.setNpc(new ShopKeeper());
							break;
						}
					}
				}
				
				else if(number[0].equals("N02")) {
					for(Room r: room) {
						if (r.getRoomID().equals(number[1])) {
							r.setNpc(new Blacksmith());
							break;
						}
					}
					
				}
				
				else if(number[0].equals("N03")) {
					for(Room r: room) {
						if (r.getRoomID().equals(number[1])) {
							r.setNpc(new BarTender());
							break;
						}
					}
				}
				
				else if(number[0].equals("N04")) {
					for(Room r: room) {
						if (r.getRoomID().equals(number[1])) {
							r.setNpc(new InnKeeper());
							break;
						}
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	public void readItem(String itemFile) throws FileNotFoundException{
			FileReader itemReader;
			Scanner in;
			try {
				itemReader = new FileReader(itemFile);
				in = new Scanner(itemReader);
				String[] number;
				while(in.hasNextLine()) {
					number = in.nextLine().split(",");
					
					//if monster drop
					if(number[0].equals("Monster")) {
						for(Room r : room) {
							if(r.getMonster() != null) {
								if(r.getMonster().monsterID.equals(number[4])) {
									r.getMonster().setItemDrop(new Items(number[1],number[2],number[3]));
								}
							}
						}
					}
					
					//if puzzle reward
					else if(number[0].equals("Puzzle")) {
						if(number[1].equals("Potion")) {
							for(Room r: room) {
								if(r.getPuzzle().getPuzzleID().equals(number[3])) {
									r.getPuzzle().setPotionDrop(Integer.parseInt(number[2]));
								}
							}
						}
						else {
							for(Room r : room) {
								if(r.getPuzzle().getPuzzleID() != "-1") {
									if(r.getPuzzle().getPuzzleID().equals(number[4])) {
										r.getPuzzle().setItemDrop(new Items(number[1],number[2],number[3]));
									}
								}
							}
						}
					}
					
					//if in NPC shop
					else if(number[0].equals("NPC")) {
						if(number[1].equals("Potion")) {
							for(Room r: room) {
								if(r.getNpc() != null) {
									if(r.getNpc().getNpcID().equals(number[2])) {
										r.getNpc().setPotions(true);
									}
								}
							}
						}
						
						else {
							for(Room r : room) {
								if(r.getNpc() != null) {
									if(r.getNpc().getNpcID().equals(number[4])) {
										r.getNpc().getSales().add(new Items(number[1],number[2],number[3]));
									}
								}
							}
						}
					}
					
					//if adding sell value, defense value, and/or attack value
					else if(number[0].equals("AddOn")) {
						for(int i = 0; i < room.size(); i++) {
							if(number[1].equals("Room")) {
								for(int j = 0; j < room.get(i).getItem().size(); j++) {
									if(number[2].equals(room.get(i).getItem().get(j).getItemID())) {
										room.get(i).getItem().get(j).setSellValue(Integer.parseInt(number[3]));
										if(number[4].equals("Weapon")) {
											room.get(i).getItem().get(j).setWeapon(true);
											room.get(i).getItem().get(j).setDamage(Double.parseDouble(number[5]));
											break;
										}
										else if(number[4].equals("Armor")) {
											room.get(i).getItem().get(j).setArmor(true);
											room.get(i).getItem().get(j).setDefense(Double.parseDouble(number[5]));
											break;
										}
									}
								}
							}
							
							else if(number[1].equals("Puzzle")) {
								if(room.get(i).getPuzzle().getItemDrop() != null) {
									if(number[2].equals(room.get(i).getPuzzle().getItemDrop().getItemID())) {
										room.get(i).getPuzzle().getItemDrop().setSellValue(Integer.parseInt(number[3]));
										if(number[4].equals("Weapon")) {
											room.get(i).getPuzzle().getItemDrop().setWeapon(true);
											room.get(i).getPuzzle().getItemDrop().setDamage(Double.parseDouble(number[5]));
											break;
										}
										else if(number[4].equals("Armor")) {
											room.get(i).getPuzzle().getItemDrop().setArmor(true);
											room.get(i).getPuzzle().getItemDrop().setDefense(Double.parseDouble(number[5]));
											break;
										}
									}
								}
							}
	
							else if(number[1].equals("NPC")) {
								if(room.get(i).getNpc() != null) {
									if(room.get(i).getNpc().sales != null) {
										for(Items j: room.get(i).getNpc().sales) {
											if(number[2].equals(j.getItemID())) {
												j.setSellValue(Integer.parseInt(number[3]));
												if(number[4].equals("Weapon")) {
													j.setWeapon(true);
													j.setDamage(Double.parseDouble(number[5]));
													break;
												}
												else if(number[4].equals("Armor")) {
													j.setArmor(true);
													j.setDefense(Double.parseDouble(number[5]));
													break;
												}
											}
										}
									}
								}
							}

							else if(number[1].equals("Monster")) {
								if(room.get(i).getMonster() != null) {
									if(room.get(i).getMonster().getItemDrop() != null) {
										if(room.get(i).getMonster().getItemDrop().getItemID().equals(number[2])) {
											room.get(i).getMonster().getItemDrop().setSellValue(Integer.parseInt(number[3]));
											if(number[4].equals("Weapon")) {
												room.get(i).getMonster().getItemDrop().setWeapon(true);
												room.get(i).getMonster().getItemDrop().setDamage(Double.parseDouble(number[5]));
												break;
											}
											else if(number[4].equals("Armor")) {
												room.get(i).getMonster().getItemDrop().setArmor(true);
												room.get(i).getMonster().getItemDrop().setDefense(Double.parseDouble(number[5]));
												break;
											}
										}
									}
								}
							}
						}
					}
					
					//if in room
					else {
						for(Room r : room) {
							if(r.getRoomID().equals(number[3])) {
								
								r.getItem().add(new Items(number[0], number[1], number[2]));
							}
						}
					}

				}
				in.close();
			
			}
			catch(FileNotFoundException e) {
				System.out.println("Wrong file. Retry!");
			}
		}
	 public void readPuzzle(String puzzleFile) throws FileNotFoundException{
			 FileReader puzzleReader;
			 Scanner in;
			 try {
				 puzzleReader = new FileReader(puzzleFile);
				 in = new Scanner(puzzleReader);
				 String[] number;
				 while(in.hasNextLine()) {
					 number = in.nextLine().split(",");
					 
					 for(Room r : room) {
						 if(r.getRoomID().equals(number[4])) {
							 r.setPuzzle(new Puzzle(number[0], number[1], number[2],Integer.parseInt(number[3]),number[5])); //added hint which is number[5]
						 }
					 }
				 }
				 in.close();
			 }
			 catch(FileNotFoundException e) {
				 System.out.println("Wrong file.Retry!");
			 }
		 }

	public void readMonster(String monsterFile) {
		FileReader monsterReader;
		Scanner in;
		try {
			monsterReader = new FileReader(monsterFile);
			in = new Scanner(monsterReader);
			String[] number;
			while(in.hasNextLine()) {
				Monster m;
				
				number = in.nextLine().split(",");
				
				//find monster data
				if(number[0].equals("M01")) {
					m = new Oozlum();
				}
				
				else if(number[0].equals("M02")) {
					m = new Cerberus();
				}
				
				else if(number[0].equals("M03")) {
					m = new TheDoctor();
				}
				
				else if(number[0].equals("M04")) {
					m = new VoidDragon();
				}
				
				else if(number[0].equals("M05")) {
					m = new PosKnightArm();
				}
				
				else if(number[0].equals("M06")) {
					m = new CynWaterHorse();
				}
				
				else if(number[0].equals("M07")) {
					m = new WoodlandWitch();
				}
				
				else if(number[0].equals("M08")) {
					m = new Ghoul();
				}
				
				else {
					m = new Monster(number[2],number[0],Double.parseDouble(number[3]),number[4]);
				}
				
				//if monster has potion or coin drops
				
				if(number.length > 5) {
					if(number[5].equals("Coin")) {
						m.setCoinDrop(Integer.parseInt(number[6]));
					}
					
					if(number[5].equals("HP")) {
						m.setPotionDrop(Integer.parseInt(number[6]));
					}
				}
				
				if(number.length > 7) {
					if(number[7].equals("Coin")) {
						m.setCoinDrop(Integer.parseInt(number[8]));
					}
					
					if(number[7].equals("HP")) {
						m.setPotionDrop(Integer.parseInt(number[8]));
					}
				}
				
				//find room where monster is
				
				for(Room r: room) {
					if(r.getRoomID().equals(number[1])) {
						r.setMonster(m);
					}
				}
				
			}
			
			
		}
		catch(FileNotFoundException e) {
		
		}
			
	}

	
	public Room getRooms(String roomNo) {
		
		Room newRoom = null;
		for(int i = 0; i < room.size(); i++) {
			if(room.get(i).getRoomID().equals(roomNo)) {
				newRoom = room.get(i);
			}
		}
		return newRoom;
	}
	

}


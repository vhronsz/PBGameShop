import java.util.Scanner;
import java.util.Vector;

public class Main {

	Boolean menu_loop = true;
	Scanner scan = new Scanner(System.in);
	RetroGame retro = new RetroGame("Chrono Trigger", 1995, "SNES","BNIB","Rare");
	Game next = new Nextgen("Call of Duty : New releases", 2021, "Ps5", "Multiplayer");
	Vector<Game> gamelist = new Vector<>();
	
	public void cls() {
		for(int i=0;i<30;i++) {
			System.out.println("");
		}
	}
	
	public RetroGame insertRetro(String title,String platform,Integer release_year) {
		boolean input_check = false;
		String condition = "";
		String rarity = "";
		
		while(input_check == false) {
			System.out.print("Input game condition [BNIB|average|bad] : ");
			condition = scan.nextLine();
			
			if(condition.equals("BNIB")||condition.equals("average")||condition.equals("bad")) {
				input_check = true;
			}
		}
		
		input_check = false;
		while(input_check == false) {
			System.out.print("Input game rarity [rare|common] : ");
			rarity = scan.nextLine();
			
			if(rarity.equalsIgnoreCase("Rare") || rarity.equalsIgnoreCase("common")) {
				input_check = true;
			}
		}	
		
		return new RetroGame(title, release_year, platform, condition, rarity);
	
	}
	
	public Nextgen insertNextGen(String title,String platform,Integer release_year) {
		boolean input_check = false;
		String game_type = "";
		
		while(input_check == false) {
			System.out.print("Input game type [singleplayer|multiplayer] : ");
			game_type = scan.nextLine();
			
			if(game_type.equalsIgnoreCase("singleplayer") || game_type.equalsIgnoreCase("multiplayer")) {
				input_check = true;
			}
		}	

		return new Nextgen(title, release_year, platform, game_type);
	}
	
	public void insertGame() {
		String title = "";
		String platform = "";
		Integer release_year = 0;
		
		//Retro game attribute
		String condition = "";
		String rarity = "";

		//Next gen game attribute
		String type = "";
		
		boolean input_check = false;
		while(input_check == false) {
			System.out.print("Input game title [3-15 Characters] : ");
			title = scan.nextLine();
			if(title.length() >= 3 && title.length() <= 15) {
				input_check = true;
			}
		}
		
		input_check = false;
		while(input_check == false) {
			System.out.print("Input game release year [1990-2021]: ");
			release_year = scan.nextInt();scan.nextLine();
			if(release_year >= 1982 && release_year <= 2021) {
				input_check = true;
			}
		}
		
		input_check = false;
		while(input_check == false) {
			System.out.print("Input platform [SNES|PS5|PC] : ");
			platform = scan.nextLine();
			if (platform.equals("SNES") || platform.equals("PS5") || platform.equals("PC")) {
				input_check = true;
			}
		}
		if(release_year < 2011) {
			gamelist.add(insertRetro(title, platform, release_year));
		}else {
			gamelist.add(insertNextGen(title, platform, release_year));
		}
		cls();
		System.out.println("Insert new game success");
		scan.nextLine();
		cls();
	}
	
	public void viewGame() {
		int count = 0;
		
		if(gamelist.size() == 0) {
			System.out.println("No game added yet");
		}else {
			System.out.println("+==+=================+======+==========+===========+========+==============+");
			System.out.printf ("|No|%-17s| Year | Platform | Condition | Rarity | %-12s |\n","     Title","    Type");
			System.out.println("+==+=================+======+==========+===========+========+==============+");
			
			while(count < gamelist.size()) {
				if(gamelist.get(count).getRelease_year() <= 2010) {
					RetroGame data = (RetroGame) gamelist.get(count);
					System.out.printf ("|%2d|%-17s| %-5d| %-9s| %-10s| %-7s| %-13s|\n",count+1,data.getGame_title(),data.getRelease_year(),data.getPlatform(),data.getCondition(),data.getRarity(),"Singleplayer");
				}else {
					Nextgen next = (Nextgen) gamelist.get(count);
					System.out.printf ("|%2d|%-17s| %-5d| %-9s| %-10s| %-7s| %-13s|\n",count+1,next.getGame_title(),next.getRelease_year(),next.getPlatform(),"BNIB","Common",next.getGameType());
				}
				count++;
			}
			System.out.println("+==+=================+======+==========+===========+========+==============+");
		}
	}
	
	public void deleteGame() {
		viewGame();
		if(gamelist.size() == 0) {
			scan.nextLine();
		}else {
			int delete = -1;
			while(delete < 1 && delete > gamelist.size()) {
				System.out.println("Choose game to delete [1-"+gamelist.size()+"]");
				delete = scan.nextInt();scan.nextLine();				
			}
			delete = delete--;
			gamelist.remove(delete);
			cls();
			System.out.println("Success on deleting the data");
			scan.nextLine();
			cls();
		}
	}
	
	Main(){
		Integer menu_input = 0;
		// Insert, view, exit
		while(menu_loop) {
			System.out.println("Welcome to PBGameShop");
			System.out.println("1.Add new game");
			System.out.println("2.View game catalog");
			System.out.println("3.Delete game from catalog");
			System.out.println("4.Exit");
			System.out.print("Choice : ");
			menu_input = scan.nextInt();scan.nextLine();
			
			switch (menu_input) {
			case 1:
				//Add game to cart
				cls();
				insertGame();
				break;
			case 2:
				cls();
				viewGame();
				scan.nextLine();
				cls();
				break;
			case 3:
				cls();
				deleteGame();
				break;
			case 4:
				menu_loop = false;
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

import java.util.Scanner;
import java.util.Vector;

public class Main {

	Boolean menu_loop = true;
	Scanner scan = new Scanner(System.in);
	Vector<Game> gamelist = new Vector<>();
	
	public void cls() {
		for(int i=0;i<30;i++) {
			System.out.println("");
		}
	}
	
	public RetroGame insertRetro(String title,String platform,Integer release_year) {
		boolean input_check = false;
		String media = "";
		String rarity = "";
		
		while(input_check == false) {
			System.out.print("Input game media [cartridge|disc] : ");
			media  = scan.nextLine();
			
			if(media.equals("cartridge")||media.equals("disc")) {
				input_check = true;
			}
		}
		
		input_check = false;
		while(input_check == false) {
			System.out.print("Input game rarity [Rare|Common] : ");
			rarity = scan.nextLine();
			
			if(rarity.equalsIgnoreCase("Rare") || rarity.equalsIgnoreCase("Common")) {
				input_check = true;
			}
		}	
		//Price
		RetroGame game = new RetroGame(title, release_year, platform, media, rarity);
		game.priceCalculation();
		return game;
	
	}
	
	public Nextgen insertNextGen(String title,String platform,Integer release_year) {
		boolean input_check = false;
		String services = "";
		
		while(input_check == false) {
			System.out.print("Input game type [Online|Offline] : ");
			services = scan.nextLine();
			
			if(services.equalsIgnoreCase("Online") || services.equalsIgnoreCase("Offline")) {
				input_check = true;
			}
		}	
		
		//Price
		Nextgen game = new Nextgen(title, release_year, platform, services);
		game.priceCalculation();
		return game;
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
			if(release_year >= 1990 && release_year <= 2021) {
				input_check = true;
			}
		}
		
		input_check = false;
		
		while(input_check == false) {
			System.out.print("Input platform [Ends with 'system' max 12 Character long] : ");
			platform = scan.nextLine();
			if (platform.endsWith("system") && platform.length() <=12) {
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
/*		System.out.println("+==+=================+======+==============+==========+========+==============+=========+");
		System.out.printf ("|No|%-17s| Year |   Platform   |   Media  | Rarity | %-12s |  %-7s|\n","     Title","  Service","Price");
		System.out.println("+==+=================+======+==============+==========+========+==============+=========+");
		System.out.printf ("|%2d| %-16s| %-5d| %-13s| %-9s| %-7s| %-13s| %-8d|\n",count+1,"Testing a",2020,"PC system","BNIB","rare","offline",200000);
*/
		if(gamelist.size() == 0) {
			System.out.println("No game added yet");
		}else {
			System.out.println("+==+=================+======+==============+==========+========+==============+=========+");
			System.out.printf ("|No|%-17s| Year |   Platform   |   Media  | Rarity | %-12s |  %-7s|\n","     Title","  Service","Price");
			System.out.println("+==+=================+======+==============+==========+========+==============+=========+");
			
			while(count < gamelist.size()) {
				if(gamelist.get(count).getRelease_year() <= 2010) {
					RetroGame data = (RetroGame) gamelist.get(count);
					System.out.printf ("|%2d| %-16s| %-5d| %-13s| %-9s| %-7s| %-13s| %-8d|\n",count+1,data.getGame_title(),data.getRelease_year(),data.getPlatform(),data.getMedia(),data.getRarity(),"No service",data.getPrice());
//					System.out.printf ("|%2d|%-17s| %-5d| %-9s| %-10s| %-7s| %-13s| %-8d|\n",count+1,data.getGame_title(),data.getRelease_year(),data.getPlatform(),data.getCondition(),data.getRarity(),"Singleplayer",data.getPrice());
				}else {
					Nextgen next = (Nextgen) gamelist.get(count);
					System.out.printf ("|%2d| %-16s| %-5d| %-13s| %-9s| %-7s| %-13s| %-8d|\n",count+1,next.getGame_title(),next.getRelease_year(),next.getPlatform(),"Download","Unrated",next.getServices(),next.getPrice());
//					System.out.printf ("|%2d|%-17s| %-5d| %-9s| %-10s| %-7s| %-13s| %-8d|\n",count+1,next.getGame_title(),next.getRelease_year(),next.getPlatform(),"BNIB","Common",next.getGameType(),next.getPrice());
				}
				count++;
			}
			System.out.println("+==+=================+======+==============+==========+========+==============+=========+");
		}
	}
	
	public void deleteGame() {
		viewGame();
		if(gamelist.size() == 0) {
			scan.nextLine();
		}else {
			int delete = -1;
			while(delete < 1 || delete > gamelist.size()) {
				System.out.print("Choose game to delete [1-"+gamelist.size()+"]: ");
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

import java.util.Scanner;

public class Main {

	Boolean menu_loop = true;
	Scanner scan = new Scanner(System.in);
	
	RetroGame retro = new RetroGame("Chrono Trigger", 1995,450000, "SNES","Square Soft","BNIB","Rare");
	
	Main(){
		Integer menu_input = 0;
		// Insert, view, exit
		while(menu_loop) {
			System.out.println("Welcome to PBGameShop");
			System.out.println("1.Testing");
			menu_input = scan.nextInt();scan.nextLine();

			switch (menu_input) {
			case 1:
				//Add game to cart
				retro.priceCalculation();
				break;
			case 2:
				//Game view
				break;
			case 0:
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

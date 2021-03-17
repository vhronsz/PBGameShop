
public class RetroGame extends Game {

	private String condition;
	private String rarity;
	
	public RetroGame(String game_title, int release_year, int price, String platform, String publisher,String condition,String rarity) {
		super(game_title, release_year, price, platform, publisher);
		this.condition = condition;
		this.rarity = rarity;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int priceCalculation() {
		// TODO Auto-generated method stub
		System.out.println(this.getGame_title());
		return 0;
	}

}

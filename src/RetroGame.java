
public class RetroGame extends Game {

	private String condition;
	private String rarity;
	

	public RetroGame(String game_title, int release_year, String platform,String condition,String rarity) {
		// TODO Auto-generated constructor stub
		super(game_title, release_year, platform);
		this.condition = condition;
		this.rarity = rarity;
	}



	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}



	public String getRarity() {
		return rarity;
	}



	public void setRarity(String rarity) {
		this.rarity = rarity;
	}



	@Override
	public int priceCalculation() {
		// TODO Auto-generated method stub
		System.out.println(this.getGame_title());
		return 0;
	}

}

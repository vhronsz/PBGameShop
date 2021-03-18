
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
	public void priceCalculation() {
		// TODO Auto-generated method stub
		
		int rarity_value = 150000;
		int condition_value = 100000;
		
		if(this.condition.equals("BNIB")) {
			condition_value= condition_value*5;
		}else if(this.condition.equals("Average")) {
			condition_value= condition_value*2;
		}else {
			condition_value= condition_value/2;
		}
		
		if(this.rarity.equalsIgnoreCase("rare")) {
			rarity_value = rarity_value* 5;
		}else {
			rarity_value= rarity_value * 2;
		}
		
		int final_price = this.getPrice()+condition_value+rarity_value;
		this.setPrice(final_price);
		
	}

}

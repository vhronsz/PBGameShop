
public class RetroGame extends Game {
	
	private String rarity;
	private String media;

	public RetroGame(String game_title, int release_year, String platform,String media,String rarity) {
		// TODO Auto-generated constructor stub
		super(game_title, release_year, platform);
		this.media = media;
		this.rarity = rarity;
	}



	public String getMedia() {
		return media;
	}



	public void setMedia(String media) {
		this.media = media;
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
		int media_value = 100000;
		
		if(this.media.equals("cartridge")) {
			media_value = media_value *5;
		}else if(this.media.equals("disc")) {
			media_value = media_value *2;
		}
		
		if(this.rarity.equalsIgnoreCase("rare")) {
			rarity_value = rarity_value* 5;
		}else {
			rarity_value= rarity_value * 2;
		}
		
		int final_price = this.getPrice()+media_value+rarity_value;
		this.setPrice(final_price);
		
	}

}

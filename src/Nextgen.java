
public class Nextgen extends Game{
	
	
	private String game_type;
	
	public Nextgen(String game_title, int release_year, String platform,String game_type) {
		super(game_title, release_year, platform);
		// TODO Auto-generated constructor stub
		this.game_type = game_type;
	}

	
	public String getGameType() {
		return game_type;
	}


	public void setGameType(String game_type) {
		this.game_type = game_type;
	}


	@Override
	public void priceCalculation() {
		// TODO Auto-generated method stub
		
		int service_price = 100000;
		if(this.game_type.equalsIgnoreCase("multiplayer")) {
			service_price = service_price *2;
		}
		int final_price = this.getPrice()+service_price;
	}
}

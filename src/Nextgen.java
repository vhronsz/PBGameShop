
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
	public int priceCalculation() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

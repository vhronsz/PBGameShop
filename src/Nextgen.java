
public class Nextgen extends Game{
	
	
	private String services;
	
	public Nextgen(String game_title, int release_year, String platform,String services) {
		super(game_title, release_year, platform);
		// TODO Auto-generated constructor stub
		this.services = services;
	}

	
	public String getServices() {
		return services;
	}


	public void setGameType(String services) {
		this.services = services;
	}


	@Override
	public void priceCalculation() {
		// TODO Auto-generated method stub
		
		int service_price = 100000;
		if(this.services.equalsIgnoreCase("offline")) {
			service_price = service_price *2;
		}
		int final_price = this.getPrice()+service_price;
		this.setPrice(final_price);
	}
}

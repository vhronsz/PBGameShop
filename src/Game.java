
public abstract class Game {

	private String game_title;
	private int release_year;
	private int price;
	private String platform;
	private String publisher;
	
	
	public Game(String game_title, int release_year, int price, String platform, String publisher) {
		super();
		this.game_title = game_title;
		this.release_year = release_year;
		this.price = price;
		this.platform = platform;
		this.publisher = publisher;
	}

	public abstract int priceCalculation();
	
	public String getGame_title() {
		return game_title;
	}
	public void setGame_title(String game_title) {
		this.game_title = game_title;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}

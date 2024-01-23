
public class Item {

	private String name;
	private int priceItem;
	private String ozellik;
	private int power;
	
	
	public Item(String name, int priceItem, int power, String ozellik) {
		this.name = name;
		this.priceItem = priceItem;
		this.ozellik = ozellik;
		this.power=power;
	}
	public int getPower() {
		return power;
	}
	public String getName() {
		return name;
	}
	public int getPriceItem() {
		return priceItem;
	}
	public String getOzellik() {
		return ozellik;
	}
	public String infoItem() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return RenkCode.BLUE+this.name+RenkCode.RESET+"\nSaldırı Gücü: "+this.power+"\nFiyat: "+this.priceItem+" Altın"+"\nÖzellik: "+this.ozellik+"\n";
	}
	
	
	
}

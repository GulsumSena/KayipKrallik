
public class Place {
	
	private String name;
	private String ozellik;
	
	public Place(String name, String ozellik) {
		this.name=name;
		this.ozellik=ozellik;
	}
	
	public String getName() {
		return name;
	}
	public String getOzellik() {
		return ozellik;
	}
	
	public void info() {
		System.out.println("\n"+this.name+"\nÖZELLİK: "+this.ozellik);
	}

	@Override
	public String toString() {
		return this.name;
	}
}

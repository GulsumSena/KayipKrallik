import java.util.Random;

public class Esya {

	private String isim;
	private int adet;
	
	public Esya(String isim) {
		Random ran=new Random();
		this.isim=isim;
		this.adet=ran.nextInt(10)+1;
	}
	
	public int getAdet() {
		return adet;
	}
	public String getIsim() {
		return isim;
	}
	
	@Override
	public String toString() {
		return this.adet+" adet "+this.isim;
	}
}

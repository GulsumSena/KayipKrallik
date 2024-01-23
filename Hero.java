import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hero {
	
	private String isim;
	private String silah;
	private String zirh;
	private static int wallet;
	private int saglikHero;
	private int ilkSaglik;
	private static ArrayList<Item> muhimmat=new ArrayList<Item>();
	private static ArrayList<Esya> yukler=new ArrayList<Esya>();

	public Hero(String isim, int saglikHero, String silah, String zirh) {
		Random ran=new Random();
		
		this.isim=isim;
		this.silah = silah;
		this.zirh = zirh;
		this.saglikHero=saglikHero;
		this.ilkSaglik=saglikHero;
	}
	public static ArrayList<Esya> getYukler() {
		return yukler;
	}
	public static ArrayList<Item> getMuhimmat() {
		return muhimmat;
	}
	public int getIlkSaglik() {
		return ilkSaglik;
	}
	public int getSaglikHero() {
		return saglikHero;
	}
	public String getSilah() {
		return silah;
	}
	public String getZirh() {
		return zirh;
	}
	public String getIsim() {
		return isim;
	}
	public static int getWallet() {
		return wallet;
	}
	public void setSaglikHero(int guncelSaglik) {
		saglikHero = guncelSaglik;
	}
	public static void setWallet(int yeniwallet) {
		Hero.wallet = yeniwallet;
	}
			
	@Override
	public String toString() {
		return this.isim+"\nSAĞLIK DURUMU: "+this.getSaglikHero()+"\nSİLAHI: "+this.silah+"\nZIRHI: "+this.zirh+"\n";
	}
	
		
	
}

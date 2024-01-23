import java.util.Random;

public class Monster {
	
	private String isim;
	private String ozellik;
	private int saglikMonster;
	
	
	public Monster(String isim, int saglikMonster, String ozellik) {
		Random ran=new Random();
		this.isim=isim;
		this.saglikMonster=saglikMonster;
		this.ozellik=ozellik;
	
	}
	public int getSaglikMonster() {
		return saglikMonster;
	}
	public String getOzellik() {
		return ozellik;
	}
	public String getIsim() {
		return isim;
	}
	public void setSaglikMonster(int guncelSaglik) {
		saglikMonster = guncelSaglik;
	}

	public void infoMonster() {
		System.out.println("\n"+this.isim+"\nÖzellik: "+this.ozellik);
	}
	

}

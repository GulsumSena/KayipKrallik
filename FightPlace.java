import java.util.Random;

public class FightPlace extends Place{
	
	private Monster monster;
	private Esya esya;
	private int ganimet;
	
	public FightPlace(String name, String ozellik, Monster monster, Esya esya) {
		super(name, ozellik);
		Random ran=new Random();
		this.monster = monster;
		this.esya = esya;
		this.ganimet=ran.nextInt(50)+1;
	}
	
	public void infoFight() {
		System.out.println("\n"+super.getName()+"\nCanavar: "+monster.getIsim()+"\nToplanabilecek Ürün: "+this.esya+"\nÖzellik: "+super.getOzellik());
	}
	public Monster getMonster() {
		return monster;
	}
	public int getGanimet() {
		return ganimet;
	}
	public Esya getEsya() {
		return esya;
	}
	
	@Override
	public String toString() {
		return super.getName();
	}
}

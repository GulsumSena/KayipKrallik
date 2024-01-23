import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class GamePage implements IGame {
	
	private Hero hero;
	private Place yer;
	private FightPlace savas;
	
	public GamePage(Hero hero, FightPlace savas) {
		this.hero=hero;
		this.savas=savas;
	}
	
	public GamePage(Hero hero, Place yer) {
		this.hero=hero;
		this.yer=yer;
	}

	@Override
	public void startGame() {
		Random rnd=new Random();
		Scanner scn=new Scanner(System.in);
		
		int numberMonster=rnd.nextInt(3)+1;
		System.out.println(this.savas.getName()+"'da "+numberMonster+" tane "+this.savas.getMonster().getIsim()+" var");
		
		while(1==1) {
			
			int attackH=(rnd.nextInt(this.hero.getSaglikHero())+1)/2;
			int defenceM=numberMonster*(rnd.nextInt(savas.getMonster().getSaglikMonster())+1);
			
			if(defenceM>attackH) {
				defenceM=attackH;
			}
			
			savas.getMonster().setSaglikMonster(savas.getMonster().getSaglikMonster()-(attackH-defenceM));
			System.out.println("-------------------------------");
			System.out.println(this.hero.getIsim()+", "+savas.getMonster().getIsim()+"'a saldırdı: "+attackH);
			System.out.println(numberMonster+" tane "+savas.getMonster().getIsim()+" savunma yaptı: "+defenceM);
			System.out.println(RenkCode.RED+savas.getMonster().getIsim()+" kalan canı: "+savas.getMonster().getSaglikMonster()+RenkCode.RESET);
			
			if(savas.getMonster().getSaglikMonster()<=0) {
				System.out.println(RenkCode.CYAN+savas.getMonster().getIsim()+" ÖLDÜRÜLDÜ! BÖLÜM TAMAMLANDI."+RenkCode.RESET);
				pickUp();
				hero.setWallet(hero.getWallet()+savas.getGanimet());
				
				System.out.println(RenkCode.YELLOW+"Kazanılan ödül: "+savas.getGanimet()+" altın"+RenkCode.RESET);
				System.out.println(RenkCode.RED+"Güncel bakiye: "+hero.getWallet()+" altın"+RenkCode.RESET);
				System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->");
				break;
			}else {			
				int attackM=numberMonster*(rnd.nextInt(savas.getMonster().getSaglikMonster())+1);
				int defenceH=(rnd.nextInt(this.hero.getSaglikHero())+1)/4;
				if(defenceH>attackM) {
					defenceH=attackM;
				}
				
				this.hero.setSaglikHero(this.hero.getSaglikHero()-(attackM-defenceH));
				System.out.println("-------------------------------");
				System.out.println(numberMonster+" tane "+savas.getMonster().getIsim()+", "+this.hero.getIsim()+"'e saldırdı: "+attackM);
				System.out.println(this.hero.getIsim()+" savunma yaptı: "+defenceH);
				System.out.println(RenkCode.RED+this.hero.getIsim()+" kalan canı: "+this.hero.getSaglikHero()+RenkCode.RESET);
				
					if(this.hero.getSaglikHero()<=0) {
						System.out.println(this.hero.getIsim()+" ÖLDÜ. KRALLIK ELLERE KALDI !");
						System.out.println("*-* *-* *-* *-* *-* *-* *-* *-*");
						break;
					}
				}
			}
		}

	@Override
	public void fixHealth() {
		System.out.println("Güvenli Eve Hoşgeldiniz!");
		this.hero.setSaglikHero(hero.getIlkSaglik());
		System.out.println(RenkCode.YELLOW+"Sağlık Durumunuz Güncellendi: "+this.hero.getSaglikHero()+RenkCode.RESET);			
	}

	@Override
	public void shop() {
		Scanner in=new Scanner(System.in);
		Item kilic=new Item("Kılıç", 15, 10, "Hafif ve taşınabilir");
		Item yay=new Item("Yay", 10, 8, "Uzaktan saldırı yapabilir");
		Item mizrak=new Item("Mızrak", 20, 12, "Güçlü saldırılar yapabilir");
		Item hafif=new Item("Hafif Zırh", 10, 5, "Hafif ve taşınabilir");
		Item orta=new Item("Orta Zırh", 15, 8, "Hafif ve taşınabilir");
		Item agir=new Item("Ağır Zırh", 20, 13, "Hafif ve taşınabilir");
		
		Item[] urunDizi= {kilic, yay, mizrak, hafif, orta, agir};
		
		ArrayList<Item> urunler=new ArrayList<Item>();
		urunler.add(kilic);urunler.add(yay);urunler.add(mizrak);urunler.add(hafif);urunler.add(orta);urunler.add(agir);
		
		
		System.out.println(RenkCode.RED+"\n"+"Bakiyeniz: "+this.hero.getWallet()+" altın"+RenkCode.RESET+"\n");
		System.out.println(RenkCode.BLUE+"ÜRÜNLER: "+RenkCode.RESET);
		
		show(urunler);
			
		System.out.print("\nAlmak istediğiniz ürün nedir? Çıkış [0]: ");
		int shop=in.nextInt();
			
		while(1==1) {
			if(shop==0) {
				break;
			}else {
				if(this.hero.getWallet()>=urunler.get(shop-1).getPriceItem()) {
					this.hero.getMuhimmat().add(urunDizi[(shop-1)]);
					this.hero.setWallet(this.hero.getWallet()-urunler.get(shop-1).getPriceItem());
					addSaglik(urunDizi[(shop-1)]);
					
					System.out.println(RenkCode.PURPLE+urunler.get(shop-1).getName()+" aldınız!"+RenkCode.RESET);
					System.out.println("Sağlık durumunuz "+urunDizi[(shop-1)].getPower()+" kadar iyileşti.");
					System.out.println("Kalan bakiyeniz: "+this.hero.getWallet()+" TL");
					break;
				}else {
					System.out.println(RenkCode.RED+"Bakiyeniz Yetersiz!"+RenkCode.RESET);
					break;
				}
			}
		}
	}
	
	public void addSaglik (Item a) {
		this.hero.setSaglikHero(this.hero.getSaglikHero()+a.getPower());
	}
			
	public <T> void show(ArrayList<T>type) {
			for (int i = 0; i < type.size(); i++) {
				System.out.print("\n"+(i+1)+"-"+type.get(i));
			}
		}

	@Override
	public void pickUp() {
		Random ran=new Random();		
		int paket=ran.nextInt(5)+1;
		System.out.println("\n"+RenkCode.GREEN+this.savas.getName()+"'de "+paket+" paket "+this.savas.getEsya().getIsim()+" topladınız."+RenkCode.RESET);
		this.hero.getYukler().add(this.savas.getEsya());		
	}
	}



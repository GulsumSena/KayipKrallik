import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Esya su=new Esya("Su");
		Esya yemek=new Esya("Yemek");
		Esya odun=new Esya("Odun");
		
		Hero savasci=new Hero("Savaşçı", 100, "Kılıç", "Hafif Zırh");
		Hero okcu=new Hero("Okçu", 80, "Yay", "Orta Zırh");
		Hero sovalye=new Hero("Şövalye", 120, "Mızrak","Ağır Zırh");
		
		Monster zombi=new Monster("Zombi", 15, "Isırabilir");
		Monster ayi=new Monster("Ayi", 20, "Pençeleyebilir");
		Monster vampir=new Monster("Vampir", 25, "Isırabilir");
		
		Place oynandi=new Place("Bu Etabı Tamamladınız.", null);
		Place guvenliEv=new Place("Güvenli Ev", "Sağlık fullenir");
		Place magaza=new Place("Mağaza", "Silah / Zırh satın alabilirsin");
		
		FightPlace orman=new FightPlace("Orman", "Vampirlerle savaşıp odun toplayabilirsin", vampir, odun);
		FightPlace nehir=new FightPlace("Nehir", "Ayılarla savaşıp su toplayabilirsin", ayi, su);
		FightPlace magara=new FightPlace("Mağara", "Zombilerle savaşıp yemek toplayabilirsin", zombi, yemek);
				
		ArrayList<Place> places=new ArrayList<>();
		places.add(guvenliEv); places.add(magaza); places.add(orman); places.add(nehir); places.add(magara);
		
		ArrayList<FightPlace> savasAlani=new ArrayList<FightPlace>();
		savasAlani.add(orman); savasAlani.add(nehir); savasAlani.add(magara);
		
		ArrayList<Hero> heros=new ArrayList<Hero>();
		heros.add(savasci); heros.add(okcu); heros.add(sovalye);
		
		System.out.println();
		System.out.println(RenkCode.RED+"KRALLIĞINIZ TEHLİKEDE! YARDIMIN GEREKİYOR."+RenkCode.RESET);
		System.out.println("\nHalkını ve krallığını kurtarmak için canavarları öldürmen gerek."+RenkCode.PURPLE+ " Orman'a, Nehir'e ve Mağara'ya gitmelisin."+RenkCode.RESET);
		System.out.println(RenkCode.GREEN+"Ormanda vampir ile,"+RenkCode.RESET+RenkCode.BLUE+" Nehirde ayı ile,"+RenkCode.RESET
				+RenkCode.YELLOW+" Mağarada zombi ile karşılaşacaksın."+RenkCode.RESET);
		System.out.println("Ormandan odun, Nehirden su, Mağaradan yemek toplayabilirsin.");
		System.out.println("Öldürdüğün her canavar için ganimet kazanacaksın.");
		System.out.println("Bu ganimetlerle"+ RenkCode.BLUE +" Mağaza"+RenkCode.RESET+"'ya gidip silah ya da zırh alabilirsin.");
		System.out.println(RenkCode.BLUE+"Güvenli Ev"+RenkCode.RESET+"'e giderek sağlığını güncelleyebilirsin.");
		System.out.println("Tüm canavarları öldürdüğünde krallık kurtulacak."+RenkCode.RESET);
		System.out.println(RenkCode.RED+"UYARI: "+"Gideceğin yerlerdeki canavar sayısı 1-3 arasında olacak.");
		System.out.println("Kaç canavar varsa saldırı seviyesi o kadar fazla olacaktır."+RenkCode.RESET);
		
			
		System.out.println(RenkCode.RED+"\nOYUNA BASLA: 1"+RenkCode.RESET);
		int kural=input.nextInt();
	
		if(kural==1) {		
			System.out.println(RenkCode.GREEN+"\nOYUNCU SEÇİNİZ: "+RenkCode.RESET);
			
			for (int i=0; i<heros.size(); i++) {
				System.out.println((i+1)+" - "+heros.get(i));			
			}
			int oyuncu=input.nextInt();
			
			while(heros.get(oyuncu-1).getSaglikHero()>0) {
				System.out.println(RenkCode.GREEN+"\nGİDECEĞİNİZ YERİ SEÇİNİZ: "+RenkCode.RESET);
	
				for (int i=0; i<places.size(); i++) {
					System.out.println((i+1)+" - "+places.get(i));			
				}
	
				int mekan=input.nextInt();
					
				if(places.contains(oynandi)&&(mekan-1)==places.indexOf(oynandi)) {
					System.out.println("Burada canavar kalmadı. Diğer yerlere gitmelisin.");
					System.out.println();
				}
				
				if(places.get(mekan-1) instanceof FightPlace) {
					GamePage g1=new GamePage(heros.get(oyuncu-1), savasAlani.get(mekan-3));
					g1.startGame();
					places.remove(mekan-1);
					places.add(mekan-1, oynandi);
				}else if(places.get(mekan-1)==guvenliEv) {
					GamePage g1=new GamePage(heros.get(oyuncu-1), places.get(mekan-1));
					g1.fixHealth();
				}else if(places.get(mekan-1)==magaza) {
					GamePage g1=new GamePage(heros.get(oyuncu-1), places.get(mekan-1));						
					g1.shop();
				}
					
				if(!places.contains(orman)&&!places.contains(nehir)&&!places.contains(magara)&&heros.get((oyuncu-1)).getSaglikHero()>0) {
					System.out.println(RenkCode.RED+"TEBRİKLER KAZANDINIZ! KRALLIK KURTULDU."+RenkCode.RESET);
					break;
				}
				}
			}
		}
	}

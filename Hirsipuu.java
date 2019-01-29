import java.util.*;

public class Hirsipuu{

	private int arvaus;
	private String sana;
	private int score; //Muuttuja joka pitää yllä pelin kulkua, selitän tarkemmin metodin sisällä

	//Ihan perus lista hommia
	private List kaikkiSanat = new ArrayList();
	private List oikeat = new ArrayList();
	private List vaarat = new ArrayList();
	private List piilotus = new ArrayList();

	public Hirsipuu(int quess, String word){

		arvaus = quess;
		sana = word;
		score = 0;

	}

	public void piilotus(){

		for(int i = 0; i < sana.length(); i++){
			piilotus.add('-');
		}
		System.out.println(piilotus);
	}


	//Metodi joka ylläpitää pelin pääsäntöistä kulkua
	public boolean arvaa(char merkki){

		kaikkiSanat.add(merkki); //iskee arvatun kirjaimen listaan

		//Looppi joka tarkistaa että esiintyykö merkkiä useamman kerran sanassa, eli siis score nousee jokaisesta oikeasta kirjaimesta
		for(int i = 0; i<sana.length(); i++){
			if(sana.charAt(i) == merkki){
				score = score + 1;
				oikeat.add(merkki); //Isketään vielä oikein menneet omaan listaan
				piilotus.set(i, merkki);
			}
		}
		//Palauttaa true jos meni oikein tai false jos väärin.	
		if(sana.indexOf(merkki) >= 0){//Homma toimii siten että ehto palauttaa -1 jos kirjain ei ilmene sanassa
			return true;
		}	
		else{
			arvaus = arvaus - 1;
			vaarat.add(merkki); // ja täällä isketään väärät kirjaimet omaan listaan
			return false;
		}
	}

	//Tulostetaan kaikki kirjaimet, oikein menneet ja väärin menneet selkeytääkseen pelin kulkua.
	public void arvaukset(){
		System.out.println(piilotus);
		System.out.println("kaikki vastaukset:\n" + kaikkiSanat);
		//Ehto lause että mitään ei tulosteta jos sisällä ei ole mitään
		if(!oikeat.isEmpty()){
			System.out.println("Oikeat vastaukset (useampi sama kirjain tarkoittaa että sanassa on monta samaa kirjainta):\n" + oikeat);
		}
		if(!vaarat.isEmpty()){
			System.out.println("Väärät vastaukset:\n" + vaarat);
		}
	}
	//Tulostaa arvausten määrän ja returnaa sen
	public int arvauksiaOnJaljella(){
		System.out.println("Sinulla on " +arvaus+ " arvausta jäljellä");
		return arvaus;
	}
	//Tarkistaa onko peli ohi vielä. Eli siis jos score on sama kuin sanan pituus on jokainen sana arvattu oikein. Ei aivan täydellinen jos pelaaja
	//huijaa ja laittaa saman kirjaimen useasti
	public boolean onLoppu(){

		if(score == sana.length()){
			return true;
		}
		else{
			return false;
		}
	}
	//Tulostaa haetun sanan pelin lopussa
	public void sana(){
		System.out.println("Oikea sana on: " +sana);
	}
}
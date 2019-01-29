import java.util.*;
import java.io.*;

public class HirsiMain{

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){

		int arvausten_maara;
		String tiedosto;
		char arvaus;

		//While looppeja varten
		boolean pelilooppi = false;
		boolean olikoOikein = false;
		boolean onkoPeliLoppu = false;
		String sana;

		System.out.println("Anna arvausten määrä");
		arvausten_maara = reader.nextInt();
		reader.nextLine();

		System.out.println("Anna tiedoston nimi muotoa tiedoston_nimi.txt (mukana tulee sanat.txt)");
		tiedosto = reader.nextLine();
		Sanalista sanat = new Sanalista(tiedosto);
	
		//Kokeillaan onko tiedoston avaaminen validi ja catchataan se jos ei
		try{
			sanat.openFile();
		} catch (FileNotFoundException fnfe){
			System.out.println(fnfe);
		}
		//Tempaistaan random sana listalta peliä varten
		sana = sanat.annaSana();

		Hirsipuu peli = new Hirsipuu(arvausten_maara, sana);
		peli.piilotus();

		while(!pelilooppi){ //Looppi joka pyörittää koko peliä

			System.out.println("Arvaa kirjain");
			arvaus = reader.next().charAt(0);

			//Katsotaan oliko vastaus oikein ja tulostellaan sen mukaan
			olikoOikein = peli.arvaa(arvaus);
			if(olikoOikein == true){
				System.out.println("Arvaus oli oikein");
			}
			else{
				System.out.println("Arvaus oli väärin");
			}

			//Tulostellaan arvaukset ja arvausten määrä. Myös vilkaistaan että onko arvauksia enää jäljellä, jos ei niin peli päättyy
			peli.arvaukset();
			arvausten_maara = peli.arvauksiaOnJaljella();
			if(arvausten_maara == 0){
				System.out.println("Arvauksesi loppuivat\nHävisit pelin");
				pelilooppi = true;
			}
			//Vilkaistaan että onko sana ratkaistu, jos kyllä niin peli päättyy
			onkoPeliLoppu = peli.onLoppu();
			if(onkoPeliLoppu){
				System.out.println("Löysit kaikki kirjaimet\nOnneksi olkoon, voitit pelin");
				pelilooppi = true;
			}
		}

		//Lopussa tulostellaan haettu sana ja listan kaikki sanat
		peli.sana();
		sanat.kaikkiSanat();
		System.out.println("Kiitos kun pelasit");
	}
}
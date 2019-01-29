import java.util.*;
import java.io.*;

public class Sanalista{
	
	private String tiedosto;
	private String random_sana;
	private List sanalista = new ArrayList(); //Ihan perus lista hommia minne nakella tiedostosta saadut sanat
	private Random random = new Random(); //Randomointi olio, että saadaan arvottua sana

	public Sanalista(String file){

		tiedosto = file;	
	}

	//Avaa tiedoston ja lätkii sanat tiedostosta arraylistiin.
	public void openFile() throws FileNotFoundException{

		Scanner buffer = new Scanner(new FileReader(tiedosto)); // Scannerin nimeksi jäi buffer jäänteenä yrityksestä käyttää bufferReaderiä
		while(buffer.hasNext()){
			sanalista.add(buffer.nextLine());
		}
	}

	//Metodi randomoi indexin paikan sanalistan koosta ja returnaa sittemmin siinä paikalla olevan sanan mainiin
	public String annaSana(){
			
			int index = random.nextInt(sanalista.size());
			return sanalista.get(index).toString(); // muutetaan myös sana objektista Stringiksi

	}
	//Tulostellaan vielä pelin lopussa koko lista
	public void kaikkiSanat(){
		System.out.println("Tiedoston kaikki sanat:");
		System.out.println(sanalista);
	}
}
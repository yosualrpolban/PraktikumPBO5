package Soal2;

public class Sasuke extends Itachi{
	String Dojutsu = "Sharingan"; 
	void printDojutsu() {
		super.printDojutsu(); //mengakses parent class nya 
		System.out.println(this.Dojutsu);
	}
}

package Soal1;
import java.util.*;

public class RestaurantMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurant menu = new Restaurant();
		menu.tambahMenuMakanan("Bala-Bala", 1_000,20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Gehu", 1_000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Tahu", 1_000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Molen", 1_000, 20);
		
		for(;;) {
			System.out.println("----- Menu Pemesanan -------");
			menu.tampilMenuMakanan();
			@SuppressWarnings("resource")
			Scanner userInput = new Scanner (System.in);
			System.out.println("Masukkan nomer dari makanan yang ingin dipesan :");
			byte id = userInput.nextByte();
			System.out.println("Masukkan Stok Pemesanan : ");
			int stokMakanan = userInput.nextInt();
			menu.pemesananMakanan(id, stokMakanan);
			System.out.print("\n");
		}
	}

}

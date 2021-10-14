package Soal1;

class Makanan {
	private String[] nama_makanan;
	private double[] harga_makanan;
	private int[] stok;
	
	//Constructor
	Makanan(){
		nama_makanan = new String[10];
		harga_makanan = new double[10];
		stok = new int[10];
	}
	
	//Setter
	public void setNamaMakanan(String nama, byte id){
		this.nama_makanan[id] = nama;
	}
	
	public void setHargaMakanan(double harga, byte id){
		this.harga_makanan[id] = harga;
	}

	public void setStok(int stok, byte id){
		this.stok[id] = stok;
	}
	
	//Getter
	public String getNamaMakanan(byte id){
		return nama_makanan[id];
	}
	
	public double getHargaMakanan(byte id){
		return harga_makanan[id];
	}
	
	public int getStok(byte id){
		return stok[id];
	}
	
	public void removeStok(byte id, int stokMakanan) {
		this.stok[id] -= stokMakanan;
	}
	
}
public class Restaurant {
	private static Makanan dataMakanan;
	private static byte id = 1;
	
	public Restaurant() {
		dataMakanan = new Makanan();
	}
	
	public void tambahMenuMakanan(String nama, double harga, int stok) {
			dataMakanan.setNamaMakanan(nama, id);
			dataMakanan.setHargaMakanan(harga, id);
			dataMakanan.setStok(stok,id);
		}
	
	public void tampilMenuMakanan(){
		for(byte i = 1; i<=id;i++){
			if(!isOutOfStock(i)){
				System.out.println(i + ")" + dataMakanan.getNamaMakanan(i) +"["+dataMakanan.getStok(i)+"]"+"\tRp. "+dataMakanan.getHargaMakanan(i));
				
			}
		}
	}
	
	public static boolean isOutOfStock(byte id){
		if(dataMakanan.getStok(id) == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void nextId(){
		id++;
	}
	
	public void pemesananMakanan(byte id, int stokMakanan) {
		if(stokMakanan<0) {
			System.out.println("Masukkan stok pemesanan makanan dengan benar");
		}else if(isOutOfStock(id) == true) {
			System.out.println("Mohon maaf stok makanan telah habis");
		}else if((dataMakanan.getStok(id)-stokMakanan) < 0){
			System.out.println("Mohon maaf pemesanan yang diajukan melebihi stok yang tersedia");
		}else {
			int totalHarga = (int) (dataMakanan.getHargaMakanan(id)*stokMakanan);
			System.out.println("---------------DETAIL PEMESANAN -------------");
			System.out.println("Nama makanan : " + dataMakanan.getNamaMakanan(id));
			System.out.println("Stok Makanan terpesan : " + stokMakanan);
			System.out.println("Harga : " + totalHarga);
			System.out.println("------------------------------------------------");
			dataMakanan.removeStok(id, stokMakanan);
		}
	
	
	}
}

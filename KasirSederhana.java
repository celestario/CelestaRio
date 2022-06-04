import java.util.ArrayList;
import java.util.Scanner;


//class transaksi yang nantinya akan dibuat arraylist dan menampung hasil dari transaksi
class Transaksi{
    String idTransaksi, namaBarang;
    int hargaBarang, jumlahBarang;

    public Transaksi(String idTransaksi, String namaBarang, int hargaBarang, int jumlahBarang) {
        this.idTransaksi = idTransaksi;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

}

public class KasirSederhana {

    private static ArrayList<String> namaBarang, kategoriBarang; //arrayList untuk menyimpan nama barang
    private static ArrayList<Integer> hargaBarang; //arrayList untuk menyimpan harga barang
    private static ArrayList<Transaksi> transaksi; //arrayList dari kelas Transaksi untuk menyimpan
    private static int jumlahTransaksi = 0; //untuk menghitung jumlahTransaksinya ada berapa dan digunakan untuk generate idTransaksi
    private static Scanner scanner;
    
    public static void main(String[] args) {
        namaBarang = new ArrayList<>();
        kategoriBarang = new ArrayList<>();
        hargaBarang = new ArrayList<>();
        
        transaksi = new ArrayList<>();
        
        scanner = new Scanner(System.in);
        
        String nama, kategori, harga, edit_nama; //digunakan untuk menyimpan data yang diinputkan nantinya
    
        menu : while(true){
            System.out.println("==================================================");
            System.out.println("|                                                |");
            System.out.println("|   SELAMAT DATANG DI APLIKASI KASIR SEDERHANA   |");
            System.out.println("|                                                |");
            System.out.println("==================================================");
            System.out.println("1. Lihat List Barang");
            System.out.println("2. Tambah Barang");
            System.out.println("3. Edit Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Transaksi");
            System.out.println("6. Exit");
            System.out.print(">> ");
            String pilihan = scanner.nextLine();
            switch(pilihan){
                //case 1 digunakan untuk melihat data barang
                case "1":
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("|                                                |");
                    System.out.println("|   DATA BARANG                                  |");
                    System.out.println("|                                                |");
                    System.out.println("==================================================");
                    if(namaBarang.isEmpty()){ //jika pada data nama barang kosong
                        System.out.println("|   Tidak ada Data                               |");
                        System.out.println("==================================================");
                    }else{
                        System.out.printf("| %-20s | %-14s | %-6s |\n", "Nama Barang", "Kategori", "Harga");
                        System.out.println("==================================================");
                        //looping untuk mencetak nama barang, kategori dan harga
                        for (int i = 0; i < namaBarang.size(); i++) {
                            System.out.printf("| %-20s | %-14s | %-6d |\n", namaBarang.get(i), kategoriBarang.get(i), hargaBarang.get(i));
                        }
                        System.out.println("==================================================");
                    }
                    break;
                case "2":
                    //input nama, kategori dan harga untuk penambahan data barang
                    System.out.print("Masukkan nama Barang : ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan kategori Barang : ");
                    kategori = scanner.nextLine();
                    System.out.print("Masukkan harga Barang : ");
                    harga = scanner.nextLine();
                    
                    //digunakan untuk mengecek apakah nama barang sudah ada atau belum
                    boolean checkAvailableName = true;
                    if(!namaBarang.isEmpty()){
                        for (int i = 0; i < namaBarang.size(); i++) {
                            if(namaBarang.get(i).equals(nama)){
                                checkAvailableName = false;
                            }
                        }
                    }
                    
                    //jika nama barang belum ada akan ditambahkan datanya
                    if(checkAvailableName){
                        namaBarang.add(nama);
                        kategoriBarang.add(kategori);
                        hargaBarang.add(Integer.parseInt(harga));
                        System.out.println("Berhasil menambahkan data barang.");
                    }else{ //jika nama barang tidak ada maka data tidak akan ditambahkan
                        System.out.println("Nama barang tersebut sudah ada.");
                    }
                    break;
                case "3":
                    //input nama barang yang akan diedit
                    System.out.print("Masukkan nama Barang yang akan diedit : ");
                    edit_nama = scanner.nextLine();
                    
                    //digunakan untuk melakukan pengecekan barang dimana jika barang berhasil di edit atau tidak
                    boolean checkEdited = false;
                    if(!namaBarang.isEmpty()){
                        for (int i = 0; i < namaBarang.size(); i++) {
                            if(namaBarang.get(i).equals(edit_nama)){
                                System.out.print("Masukkan nama Barang : ");
                                nama = scanner.nextLine();
                                System.out.print("Masukkan kategori Barang : ");
                                kategori = scanner.nextLine();
                                System.out.print("Masukkan harga Barang : ");
                                harga = scanner.nextLine();
                                
                                namaBarang.set(i, nama);
                                kategoriBarang.set(i, kategori);
                                hargaBarang.set(i, Integer.parseInt(harga));
                                checkEdited = true;
                            }
                        }
                        
                        if(checkEdited){
                           System.out.println("Berhasil merubah data barang."); 
                        }else{
                           System.out.println("Nama barang yang dicari tidak ada."); 
                        }
                    }else{
                        System.out.println("Data barang tidak ada.");
                    }
                    break;
                case "4":
                    //memasukkan nama barang yang akan dihapus
                    System.out.print("Masukkan nama Barang yang akan dihapus : ");
                    edit_nama = scanner.nextLine();
                    
                    //pengecekan apakah barang berhasil dihapus atau tidak
                    boolean checkDeleted = false;
                    if(!namaBarang.isEmpty()){
                        for (int i = 0; i < namaBarang.size(); i++) {
                            if(namaBarang.get(i).equals(edit_nama)){
                                namaBarang.remove(i);
                                kategoriBarang.remove(i);
                                hargaBarang.remove(i);
                                checkDeleted = true;
                                break;
                            }
                        }
                        
                        if(checkDeleted){
                           System.out.println("Berhasil menghapus data barang."); 
                        }else{
                           System.out.println("Nama barang yang dicari tidak ada."); 
                        }
                    }else{
                        System.out.println("Data barang tidak ada.");
                    }
                    break;
                case "5":
                    String idTransaksi = String.valueOf(jumlahTransaksi+1); //generate idTransaksi dari jumlah transaksi yang tersedia
                    if(!namaBarang.isEmpty()){ //jika barang ada maka akan dilakukan transaksi
                        transaksi : while(true){
                            if(namaBarang.isEmpty()){
                                break;
                            }else{

                                System.out.println("========================================================");
                                System.out.printf("| %-3s | %-20s | %-14s | %-6s |\n", "No", "Nama Barang", "Kategori", "Harga");
                                System.out.println("========================================================");
                                for (int i = 0; i < namaBarang.size(); i++) {
                                    System.out.printf("| %-3d | %-20s | %-14s | %-6d |\n", (i+1), namaBarang.get(i), kategoriBarang.get(i), hargaBarang.get(i));
                                }
                                System.out.println("========================================================");
                                System.out.print("Masukkan nomor barang : ");
                                //memasukkan nomor barang
                                int nomor = Integer.parseInt(scanner.nextLine());
                                if(nomor < 1 || nomor > namaBarang.size()){
                                    System.out.println("Nomor tidak tersedia.");
                                }else{ //jika nomor barang ada maka akan memasukkan jumlah dan menambahkannya ke transaksi
                                    System.out.print("Masukkan jumlah barang : ");
                                    int jumlah = Integer.parseInt(scanner.nextLine());
                                    transaksi.add(new Transaksi(idTransaksi, namaBarang.get(nomor-1), hargaBarang.get(nomor-1), jumlah));
                                }

                                //pertanyaan apakah ingin menambah barang lagi pada transaksi yang berjalan atau tidak
                                while(true){
                                    System.out.print("Apakah ingin menambahkan barang pada transaksi ini [Yes/No]? ");
                                    String inputanyesno = scanner.nextLine();
                                    if(inputanyesno.equals("Yes")){
                                        break;
                                    }else if(inputanyesno.equals("No")){
                                        break transaksi;
                                    }
                                }
                            }
                        }

                        //menghitung total bayar
                        int total_bayar = 0;
                        for (int i = 0; i < transaksi.size(); i++) {
                            if(transaksi.get(i).getIdTransaksi().equals(idTransaksi)){
                                total_bayar += (transaksi.get(i).getHargaBarang() * transaksi.get(i).getJumlahBarang());
                            }
                        }

                        System.out.println(" Total bayar : " + total_bayar);
                        int bayar;
                        //looping untuk penginputan bayar, jika bayar lebih dari sama dengan total bayar maka akan selesai untuk loopingnya
                        while(true){
                            System.out.print(" Bayar : ");
                            bayar = Integer.parseInt(scanner.nextLine());
                            if(bayar < total_bayar){
                                System.out.println("Uang bayar harus lebih dari atau sama dengan total bayar.");
                            }else{
                                break;
                            }
                        }
                        
                        //cetak nota transaksi
                        System.out.println("");
                        System.out.println("==================================================");
                        System.out.println("|                                                |");
                        System.out.println("|   Nota Transaksi                               |");
                        System.out.println("|                                                |");
                        System.out.println("==================================================");
                        System.out.printf("| %-20s | %-14s | %-6s |\n", "Nama Barang", "Harga Barang", "Jumlah");
                        System.out.println("==================================================");
                        for (int i = 0; i < transaksi.size(); i++) {
                            if(transaksi.get(i).getIdTransaksi().equals(idTransaksi)){
                                System.out.printf("| %-20s | %-14d | %-6d |\n", 
                                        transaksi.get(i).getNamaBarang(), 
                                        transaksi.get(i).getHargaBarang(), 
                                        transaksi.get(i).getJumlahBarang());
                            }
                        }
                        System.out.println("==================================================");
                        System.out.printf("| %-11s : %-32d |\n", "Total Bayar", total_bayar);
                        System.out.printf("| %-11s : %-32d |\n", "Bayar", bayar);
                        System.out.printf("| %-11s : %-32d |\n", "Kembalian", Math.abs((total_bayar - bayar)));
                        System.out.println("==================================================");
                        jumlahTransaksi += 1;
                    }else{
                        System.out.println("Belum ada data barang.");
                    }
                    break;
                case "6":
                    System.out.println("Terimakasih telah menggunakan sistem ini.");
                    break menu;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
            System.out.println("");
        }
    }
    
}
import java.util.Scanner;
public class GameMain{
public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
            System.out.println("=========PACMAN=========");
            System.out.print("\nTentukan jumlah Pacman: ");
            int jum=in.nextInt();
            Pacman [] pArray=new Pacman[jum];
            for(int i=0;i<pArray.length;i++){
                System.out.println("\nTentukan jumlah pil untuk setiap Pacman: ");
                int pi=in.nextInt();
            }

            System.out.println("\n\n=========KUMAN=========");
            System.out.println("\nTentukan jumlah Kuman: ");


            System.out.println("\n\n======GAME PACMAN VS KUMAN=====");

            System.out.println("\nPilih Pacman yang kamu mainkan!");
            System.out.println("Pilih Pacman ke: ");

            System.out.println("\nTentukan jumlah pil yang dimakan oleh Pacman ke-"+ p+"!");

            System.out.println("\nTentukan kuman yang kamu mainkan!");
            System.out.println("Pilih kuman ke:");

}
}

public class Kuman {
    int powerKuman;
    
    Kuman (int power){
        
    }
    
    void makanPacman(Pacman p){
       
        
        System.out.println("\nKekuatan kuman bertambah sebesar: " );
        
    }
}

public class Pacman {
    int pil;
    int pac;
    
    Pacman (int p){
        pac = p
        System.out.println("Energi default sebesar: " + this.p + " diberikan kepada ");
    }
    
    
    
    void makanPil(int n){
        
        System.out.println("Energi yang diperoleh Pacman: " + pil);
    }
}
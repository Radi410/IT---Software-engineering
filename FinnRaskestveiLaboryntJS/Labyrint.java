import java.util.Scanner;
import java.io.*;

public class Labyrint {
    private int ant_Cols, ant_Rader;
    private Rute [][] rute;
    public  Labyrint(String filnavn) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filnavn));
        String[] stoerrelse = input.nextLine().strip().split(" ");
        int radnr = 0;
        ant_Rader = Integer.parseInt(stoerrelse[0]);
        ant_Cols = Integer.parseInt(stoerrelse[1]);
        rute = new Rute[ant_Rader][ant_Cols];
        //  teller for linjenummer
        int linjenummer = 1;
        while (input.hasNextLine()) {
            String[] linje = input.nextLine().strip().split("");
            for (int i = 0; i < linje.length; i++) {
                Rute nyrute = null;
                // sjekker forste og siste linje for aapninger
                if (linjenummer == 1 || linjenummer == ant_Rader + 1) {
                    if (linje[i].equals(".")) nyrute = new Aapning(radnr, i, this);
                    else if (linje[i].equals("#")) nyrute = new SortRute(radnr, i, this); 
                }

                else {
                    if (linje[i].equals(".") && (i == linje.length - 1 || i == 0)) nyrute = new Aapning(radnr, i, this);
                    else if (linje[i].equals(".")) nyrute = new HvitRute(radnr, i, this);
                    else if (linje[i].equals("#")) nyrute = new SortRute(radnr, i, this);
                }

                rute[radnr][i] = nyrute;
            }
            linjenummer++;
            radnr++;
        }
        for(int i = 0; i < ant_Rader; i++){
            for(int x = 0; x < ant_Cols; x++){
                Rute nord = null;
                Rute syd = null;
                Rute vest = null;
                Rute oest = null;
                // Starter med å sjekke nord,
                if(i - 1 >= 0){
                    nord = rute[i - 1][x];
                }
                if(i + 1 <= ant_Rader - 1){
                    syd = rute[i + 1][x];
                }
                if(x - 1 >= 0){
                    vest = rute[i][x - 1];
                }
                if(x + 1 <= ant_Cols - 1){
                    oest = rute[i][x + 1];
                }
                rute[i][x].naboer(nord, syd, vest, oest);
            }
        }

    }
    public Rute hentRute(int radnummer, int kolonnenummer){
        return rute[radnummer][kolonnenummer];
    }
    @Override
    public String toString(){
        String utskrift = "";
        for(int i = 0; i < ant_Rader; i++){
            for(int x = 0; x < ant_Cols; x++){
                char rep = rute[i][x].hentKarakter();
                utskrift += Character.toString(rep);
            }
            if(i < ant_Rader - 1){
                utskrift += "\n";
            }
        }
        return utskrift;
    }
    public void finnUtVeiFra(int rad, int kol){
        if(rute[rad][kol] instanceof SortRute){
            System.out.println("Ikke mulig aa starte i sort rute.");
            return;
        }
        rute[rad][kol].finn(null);
    }
}  
       

    

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Hoved {
    public static void main (String [] args){
        
        try {
            File fil = new File("dataklynge3.txt");
            Scanner myReader = new Scanner(fil);

        
        }
        while (myReader.hasNextLine()){
            String line = myReader.nextLine();
            String [] biter = line.split(" ");
            int biterlengde = biter.length;

        }
        } catch (FileNotFoundException e){
        System.out.println("Kan ikke lese filen");
        System.exit(1);
        }
        int antNoder = Integer.parseINt(biter[0]);
        int antPros = Integer.parseInt(biter[1]);
        int minne = Integer.parseInt(biter[2]);


        //Maks 4096 gb
        if (minne >4096){
            System.out.println("Feilmelding: Høy gb");
            System.exit(0);
        }
        if (antPros > 16){
            System.out.println("For mange prossesorere");
            System.exit(0);
        }
        Node noden = new Node(antPros, minne);
        for (int i = 0; i < antNoder; i++){
            saga.settInnNode(noden);
        }

    }

}
System.out.println("Noder med minst 64 GB: " + saga.noderMedNokMinne(64));
System.out.println("Noder med minst 128 GB: " + saga.noderMedNokMinne(128));
System.out.println("Noder med minst 4096 GB: " + saga.noderMedNokMinne(4096));
System.out.println("Antall prosessorer: " + saga.antPros());
System.out.println("Antall rack: " + saga.antallRack());


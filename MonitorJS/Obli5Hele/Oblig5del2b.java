import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.io.*;

public class Oblig5del2b {
    
 
    public static void main(String[] args) throws InterruptedException {
        final String DATAMAPPE = args[0];
        final String METAFIL = args[1];

       
        File mappe = new File(DATAMAPPE);
        int antallFiler = mappe.list().length - 1;

        final int ANTALL_FLETTE_TRAADER = antallFiler - 1;

      
        Monitor2 monitor = new Monitor2();

        
        CountDownLatch barriere1 = new CountDownLatch(antallFiler);
        CountDownLatch barriere2 = new CountDownLatch(ANTALL_FLETTE_TRAADER);


        lastInnData(DATAMAPPE, METAFIL, monitor, barriere1);

        Runnable fletteTrad = new FletteTrad(monitor, barriere2);

        for (int i = 0; i < ANTALL_FLETTE_TRAADER; i++) {
            Thread traad = new Thread(fletteTrad);
            traad.start();
        }


        barriere1.await();
        barriere2.await();

        skrivUtSubsekvensMedFlestAntallForekomster(monitor);
    }

   
    private static void lastInnData(String mappe, String metafil, Monitor2 monitor, CountDownLatch barriere) throws InterruptedException {
        try { 
            Scanner sc = new Scanner(new File(mappe + "/" + metafil));
            while (sc.hasNextLine()) {
                String linje = sc.nextLine().strip();
                Runnable leseTrad = new LeseTrad(mappe + "/" + linje, monitor, barriere);
                Thread traad = new Thread(leseTrad);
                traad.start();
            }
        } catch (FileNotFoundException e) { System.out.println("Fant ikke fil."); }
    }

   
    private static void skrivUtSubsekvensMedFlestAntallForekomster(Monitor2 monitor) {
        if (monitor.hentAntall() == 1) {
            HashMap<String, Subsekvens> kart = monitor.hentUt();
            int antall = 0;
            for (Subsekvens subsekvens : kart.values()) if (subsekvens.hentAntall() > antall) antall = subsekvens.hentAntall();
            for (Subsekvens subsekvens : kart.values()) if (subsekvens.hentAntall() == antall) System.out.println(subsekvens);
        }
    }

}
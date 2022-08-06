import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;

public class Monitor2 extends SubsekvensRegister{
    private static Lock laas = new ReentrantLock(true);
    private Condition ikkeToFilerKlare = laas.newCondition();
    
    private final int KRAV = 2;

    @Override
    public void settInn(HashMap<String, Subsekvens> kart) {
        laas.lock();
        try { 
            beholder.add(kart);
            if (hentAntall() >= KRAV) {
                ikkeToFilerKlare.signalAll();
            }
            System.out.println("Kart satt inn av lesetraad.");
        } finally { laas.unlock(); }
    }

    
    public void settInnFlettet(HashMap<String, Subsekvens> kart) {
        laas.lock();
        try {
            beholder.add(kart);
            
            if (hentAntall() >= KRAV) {
                ikkeToFilerKlare.signalAll();
            }
            System.out.println("Flettet kart satt inn av flettetraad.");
        } finally { laas.unlock(); }
    }

    
    public Returverdi<HashMap<String, Subsekvens>> hentUtToKart() throws InterruptedException {
        laas.lock();
        try {
            
            while (hentAntall() < KRAV) ikkeToFilerKlare.await();
            System.out.println("To kart hentet ut av flettetraad.");
           
            return new Returverdi<HashMap<String,Subsekvens>>(hentUt(), hentUt());

        } finally { laas.unlock(); }
    }

    
    public void slaaSammenToKart(HashMap<String, Subsekvens> kart1, HashMap<String, Subsekvens> kart2) {
        laas.lock();
        try {
            HashMap<String, Subsekvens> nytt_kart = new HashMap<>();

            
            for (String nokkel : kart2.keySet()) nytt_kart.put(nokkel, new Subsekvens(1, nokkel)); 

            
            for (String nokkel1 : kart1.keySet()) {
                Subsekvens subsekvens1 = kart1.get(nokkel1);
                int teller = subsekvens1.hentAntall();
                for (String nokkel2 : kart2.keySet()) {
                    Subsekvens subsekvens2 = kart2.get(nokkel2);
                    int antall = subsekvens2.hentAntall();

                    if (nokkel1.equals(nokkel2)) {
                        teller += antall;
                    } 

                    nytt_kart.put(nokkel1, new Subsekvens(teller, nokkel1));
                }
            }
            System.out.println("To kart slaat sammen av lesetraad.");
            settInnFlettet(nytt_kart);
        } finally { laas.unlock(); }
    }

    
    public static HashMap<String, Subsekvens> konverterTilSubsekvenser(String filnavn) {
        laas.lock();
        try { 
            HashMap<String, Subsekvens> subsekvenser = new HashMap<>();

            try {
                Scanner input = new Scanner(new File(filnavn));
                subsekvenser = Reseptor.lagSubsekvenser(input);
            } catch (FileNotFoundException e) { System.out.println("Fant ikke fil."); }
            System.out.println("konvertert til subsekvenser.");
            return subsekvenser;
        } 
        finally { laas.unlock();}
    }
}
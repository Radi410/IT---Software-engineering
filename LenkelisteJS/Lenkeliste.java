abstract class Lenkeliste <T> implements Liste<T>{
    
    protected Node start = null;
    protected Node slutt = null;
    protected int antNoder = 0;
    
    
    public class Node {
        Node neste = null;
        Node forrige = null;
        T data; 
        Node(T x) {
            data = x;
            antNoder++;
        }
    }
    
    public int storrelse(){
        return antNoder;
    }


    
    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x); 

       
        if (start==null){
            start = nyNode;
        }
        else if (slutt == null){
            slutt = nyNode;
            slutt.forrige = start;
            start.neste = slutt;
        }
        else { 
            slutt.neste = nyNode;
            nyNode.forrige = slutt;
            slutt = nyNode;
        }
        slutt = nyNode;
    }

    
    @Override
    public T hent()throws UgyldigListeindeks{
        if (start == null){
            throw new UgyldigListeindeks(0);
        }
        return start.data;
    }


    @Override
    public T fjern() throws UgyldigListeindeks{
        if (antNoder == 0) {
            throw new UgyldigListeindeks(0);
        }

        T nodeEtterFjerning = start.data;

        
        if (antNoder <= 0){
            return null;
        }
        
        if(antNoder == 1){
            start = null;
            slutt = null;
        }
        else{
            start.neste.forrige = null;
            start = start.neste;
        }

        antNoder -= 1;
        return nodeEtterFjerning;
    }



    @Override
    public String toString() {
        if (start == null){
            return("Det er ingen elementer i listen.");
        }
        
        Node peker = start;
        String utskrift = "";
       
        for (int i = 0; i < antNoder; i += 1) {
            utskrift = utskrift + peker.data + "\n";
            peker = peker.neste;
        }

        return utskrift;
    } 

}
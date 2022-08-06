public class IndeksertListe<T> extends Lenkeliste<T> {
    public void leggTil(int pos, T x )throws UgyldigListeindeks{
        if(pos < 0 || pos > storrelse()){
            throw new UgyldigListeindeks(pos);
        }
        
        Node nyNode = new Node(x);
        Node navaerende = start;
        
        if (antNoder == 0){
            start = nyNode;
            slutt = nyNode;
        }
        else if (pos == 0){
            nyNode.neste = start;
            start = nyNode;
        }
        else if (pos == antNoder){
            slutt.neste = nyNode;
            slutt = nyNode;
        }
        else{
            int teller = 0;
            while (teller < pos-1){
                teller += 1;
                navaerende = navaerende.neste;
            }
            nyNode.neste = navaerende.neste;
            navaerende.neste = nyNode;
        }
    } 


    public void sett(int pos, T x) {
        if (pos >= storrelse() || pos < 0) { 
            throw new UgyldigListeindeks(pos);
        }
        
        Node nyNnode = start;
        int teller = 0;
       
        if (pos == 0 && nyNnode != null)  {
          start.data = x; 
        }

        while (nyNnode != null) {
            if (teller == pos) {
                nyNnode.data = x; 
        }
        teller++;
        nyNnode = nyNnode.neste;
        }
    } 


    public T hent (int pos) {
        if (pos > (storrelse()-1) || pos < 0){
            throw new UgyldigListeindeks(pos);
        }
    
        Node navaerende = start;

        for(int i = 0; i < pos; i += 1){
            navaerende = navaerende.neste;
        }
        return navaerende.data;
    }


    public T fjern (int pos){
        if (pos < 0 || pos >= antNoder){
            throw new UgyldigListeindeks(pos);
        }
        
        Node navaerende = start;
        T retur;
        int teller = 0;

        while (navaerende != null){
            if (teller == pos){
                antNoder -= 1;
                retur = navaerende.data;
                navaerende = navaerende.neste;
                return retur;
            }
            navaerende = navaerende.neste;
            teller += 1;
        }
        return null;

    }
    
}
  
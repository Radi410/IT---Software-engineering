public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
    @Override
    public void leggTil(T x){
        Node nyNode;
        Node navaerende = start;

        if(antNoder == 0){
            super.leggTil(x);
            return;
        }

        for(int i = 0; i < antNoder; i++){
            if(x.compareTo(navaerende.data) < 0){
                nyNode = new Node(x);
                nyNode.neste = navaerende;
                nyNode.forrige = navaerende.forrige;
                navaerende.forrige = nyNode;
            
                if(navaerende != start){
                    nyNode.forrige.neste = nyNode;
                }
                else{
                    start = nyNode;
                }
                return;
            }     
        }
        super.leggTil(x);
    }
    public T hent(int pos){
        Node node = start;
        if(pos < 0 || pos > (antNoder - 1)){
            throw new UgyldigListeindeks(pos);
        }else{
            for(int i = 0; i < pos; i++){
                node = node.neste;
            }
        }
        return node.data;
    }
    public T fjern(int pos, T x){
        Node ny = start;
        if(pos < 0 || pos > (antNoder - 1)){
            throw new UgyldigListeindeks(pos);
        }
        for(int i = 0; i < pos; i++){
            ny = ny.neste;
        }
        if(pos == 0){
            start = start.neste;
        }else{
            if(pos == antNoder-1){
                ny.forrige.neste = null;
            }
        }
        antNoder--;
        return ny.data;
    }
    
}
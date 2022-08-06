public class Stabel<T> extends Lenkeliste<T> {
    @Override
    public void leggTil(T x){
        Node ny = new Node(x);

        if(antNoder == 0){
            start = ny;
            slutt = ny;
        }
        else {
            ny.neste = start;
            start.forrige = ny;
            start = ny;
        }
        antNoder ++;
    }
}
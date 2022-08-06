public class Presepter extends HviteResepter { 
    protected static int rabatt=108;

    public Presepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    @Override
    public int prisAaBetale(){
        int nyPris = legemiddel.hentPris();
        if (nyPris > 108){
            return nyPris-rabatt;
        } else{
            return 0;
        }

    }

}
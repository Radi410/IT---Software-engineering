public class HviteResepter extends Resept{  
    protected int rabatt;
    public HviteResepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    @Override 
    public String farge(){
        return "hvit";
    }
    @Override
    public int prisAaBetale(){
        return hentLegemiddel().hentPris();
    }
}

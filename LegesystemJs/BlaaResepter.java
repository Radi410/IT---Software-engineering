
public class BlaaResepter extends Resept{ 
    protected double rabatt = 0.25;

    public BlaaResepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    @Override
    public String farge(){
        return "Blaa";
    }
    @Override
    public int prisAaBetale(){
       double pris = legemiddel.hentPris() * rabatt;
       int nyPris = (int) pris;
       return nyPris;
    }
}
    


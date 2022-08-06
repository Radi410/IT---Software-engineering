
public class Vanedannende extends Legemiddel{
    protected int stryke;
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){ 
        super(navn, pris, virkestoff);
        this.stryke = styrke;
    }
    public int hentVanedannendeStyrke(){
        return stryke;
    }
    @Override
    public String toString(){
        return super.toString() + ", vanedannende styrke: " + stryke + " ";
    }
} 
    


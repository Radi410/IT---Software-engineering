

public abstract class Resept {
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;
    private static int count = 1;
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        
    }
    public int hentId(int id){
        id = count++;
        return id;
    }
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }
    public Lege hentLege(){
        return utskrivendeLege;
    }
    public int hentPasientId(){
        return pasientId;
    }
    public int hentReit(){
        return reit;
    }
    public boolean bruk(){
        if (reit != 0){
            return true;
        }
        return false;
    }
    abstract public String farge();
    abstract public int prisAaBetale();

    public String toString(){
        return "Legemiddel: " + legemiddel +  utskrivendeLege + ", pasient ID: " + pasientId + ", betaling: " + prisAaBetale();
    }

} 
    


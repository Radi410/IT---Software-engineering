class  Legemiddel{
    protected String navn;
    protected int pris;
    protected double virkestoff;
    private int id = 1;
    private static int count = 1;

    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = count++;
    }

    public int hentId(int id){
        return id;
    }
    public String hentNavn(){
        return navn; 
    }
    public int hentPris(){
        return pris;
    }
    public double hentVirkestoff(){
        return virkestoff;
    }
    public int settNypris(int nypris){
        this.pris = nypris;
        return nypris;
    }
    public String toString(){
        return navn + ", pris: " + pris + "kr, virkestoff: " + virkestoff + "mg ";
    }
}
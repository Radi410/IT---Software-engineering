public class Spesialist extends Lege implements Godkjenningsfritak { 

    protected String kontrollID;
    // Lager en interface ID for at spesialistene kan få godkjenningsfritak
    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }
    public String hentKontrollId(){
        return kontrollID;
    }
    // Nå kan det itilegg skrive ut respet på narkotiske virkemidler, alle de som har godskjenning
    //har også en kontroll id som jeg har lagd over
    @Override
    public String toString(){
        return super.toString() + ", kontroll ID: " + kontrollID;
    }
}
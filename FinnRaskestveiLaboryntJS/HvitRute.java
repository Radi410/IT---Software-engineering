
public class HvitRute extends Rute {
    public HvitRute(int colsNr,int raderNr, Labyrint labyrint){
        super(colsNr, raderNr, labyrint);

    }
    public char karakter = '.';
    
    @Override
    public void finn(Rute fra) {
        if (fra == null) {
            // nord
            nabo[0].finn(this);
            // oest
            nabo[1].finn(this);
            // syd
            nabo[2].finn(this);
            // vest
            nabo[3].finn(this);
        } else {
            if (nabo[0] != null && nabo[0] != fra) {
                nabo[0].finn(this);
            }

            if (nabo[1] != null && nabo[1] != fra) {
                nabo[1].finn(this);
            }

            if (nabo[2] != null && nabo[2] != fra) {
                nabo[2].finn(this);
            }

            if (nabo[3] != null && nabo[3] != fra) {
                nabo[3].finn(this);
            }
        }

        return;
    }

    
    @Override 
    public String toString(){
        return "Hvit Rute";
    }

    public char hentKarakter() {
        return karakter;
    }

}


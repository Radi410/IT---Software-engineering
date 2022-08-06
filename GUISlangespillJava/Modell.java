public class Modell{
    private GUI gui;
    private Kontroller kontroller;
    private boolean start;
    private Koe<Slange> slange = new Koe<>();
    private Skatt[] skatter = new Skatt[10];


    public Modell(GUI gui, Kontroller kontroller){
        this.gui = gui;
        this.kontroller = kontroller;
    }
    public void startSpill(){
        start = true;
        kontroller.startBrett();

    }
    public Koe<Slange> getSlange(){
        return slange;
    }
    public int getHalelengde(){
        return slange.storrelse();
    }
    public Slange getHode(){
        for(Slange part : slange){
            if(part.erHode()){
                return part;
            }
        }
        return null;
    }
    public Skatt[] getSkatter(){
        return skatter;
    }
    public void addSkatt(int pos, Skatt skatt){
        skatter[pos] = skatt;
    }
    public void removeSkatt(int pos){
        skatter[pos] = null;
    }
    public void forlengSlange(Slange part){
        slange.add(part);
    }
    public void forkortSlange(){
        slange.remove();
    }
    public void avsluttSpill(){
        start = false;
    }
    public boolean spillKjorer(){
        return start;
    }
    public void treffHale(){
        if(slange.storrelse() > 1){
            for(Slange part : slange){
                if(getHode().getRadnr() == part.getRadnr() && getHode().getKolnr() == part.getKolnr() && !part.erHode()){
                    avsluttSpill();
                }
            }
        }
    }
    public void addSkatt(int pos){
        int skattRad = 0;
        int skattKol = 0;
        boolean ingenTreff = false;

        while(true){
            for(Slange part : slange){
                for(Skatt skatt : skatter){
                    if(skatt != null){
                        skattRad = Skatt.trekk(0,11);
                        skattKol = Skatt.trekk(0, 11);
                        if(skattRad != part.getRadnr() && skattRad != skatt.getRadnr() && skattKol != part.getKolnr() && skattKol != skatt.getKolnr()){
                            ingenTreff = true;
                        }else{
                            ingenTreff = false;
                        }
                    }
                }
            }
            if(ingenTreff){
                break;
            }
            
        }
    
        skatter[pos] = new Skatt(skattRad, skattKol);
    }

    public boolean kollisjon(){
        for(int i = 0; i < skatter.length; i++){
            for(Slange part : slange){
                if(skatter[i] != null){
                    if(skatter[i].getRadnr() == part.getRadnr() && skatter[i].getKolnr() == part.getKolnr()){
                        removeSkatt(i);
                        addSkatt(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void beveg(String retning){
        Slange ny;

        switch(retning){
            case "opp":
            if(getHode().getRadnr() - 1 < 0){
                avsluttSpill();
            }
            if(slange.storrelse() == 1){
                ny = new Slange(getHode().getRadnr() - 1, getHode().getKolnr(), true);
                if (!kollisjon()) slange.remove();
                for (Slange part : slange){
                    part.removeHode();
                }
                slange.add(ny);
                return;
            }
            ny = new Slange(getHode().getRadnr() - 1, getHode().getKolnr(), true);
            for (Slange part: slange) part.removeHode();
            if (!kollisjon()) slange.remove();
            slange.add(ny); 
            break;

        case "hoeyre":
            if (getHode().getKolnr() + 1 > 11) avsluttSpill();
            
            if (slange.storrelse() == 1) {
                ny = new Slange(getHode().getRadnr(), getHode().getKolnr() + 1, true);
                if (!kollisjon()) slange.remove();
                for (Slange part: slange) part.removeHode();
                slange.add(ny);
                return;
            }

            ny = new Slange(getHode().getRadnr(), getHode().getKolnr() + 1, true);
            for (Slange part: slange) part.removeHode();
            if (!kollisjon()) slange.remove();
            slange.add(ny);
            break;

        case "ned":
            if (getHode().getRadnr() + 1 > 11) avsluttSpill();

            if (slange.storrelse() == 1) {
                ny = new Slange(getHode().getRadnr() + 1, getHode().getKolnr(), true);
                if (!kollisjon()) slange.remove();
                for (Slange part: slange) part.removeHode();
                slange.add(ny);
                return;
            }

            ny = new Slange(getHode().getRadnr() + 1, getHode().getKolnr(), true); 
            for (Slange part: slange) part.removeHode();
            if (!kollisjon()) slange.remove();
            slange.add(ny);
            break;
            
        case "venstre":
            if (getHode().getKolnr() - 1 < 0) avsluttSpill();

            if (slange.storrelse() == 1) {
                ny = new Slange(getHode().getRadnr(), getHode().getKolnr() - 1, true);
                if (!kollisjon()) slange.remove();
                for (Slange part: slange) part.removeHode();
                slange.add(ny);
                return;
            }

            ny = new Slange(getHode().getRadnr(), getHode().getKolnr() - 1, true);
            for (Slange part: slange) part.removeHode();
            if (!kollisjon()) slange.remove();
            slange.add(ny);
            break;
        }
    }
}
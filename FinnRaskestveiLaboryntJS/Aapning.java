public class Aapning extends HvitRute {
    public Aapning(int ColsNr, int raderNr, Labyrint labyrint){
        super(ColsNr, raderNr, labyrint);
    }
    @Override
    public void finn(Rute fra){
        System.out.println("(" + raderNr + ", " + ColsNr + ")");
        return;
    }
}


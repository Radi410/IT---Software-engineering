public class MilitaerResept extends HviteResepter {
    
    public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }
    @Override
    public int prisAaBetale(){
        return 0;
    }
}
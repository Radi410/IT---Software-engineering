//Klasse for representasjon av racks i en regneklynge.
class Rack{
    private Node [] noder;
    private int antNoder=0;
    private int plasser;
//
    public Rack (int plasser){
        noder=new Node[plasser];
    }

    public void addNode(Node node){
        noder[antNoder]=node;
        antNoder++;
    }

    public boolean erFull(){
        return antNoder == noder.length;
    }
// Beregner sammenlagt antall prosessorer i nodene i et rack
	// @return antall prosessorer
    public int antpros(){
        int antpros = 0;

        for(Node node: noder){
            if(node!= null){
              antpros += node.hentAntpros();
            }
        }
        return antpros;
    }

    // Henter antall noder i racket 
    //Beregner antall noder i racket med minne over gitt grense
    public int noderMedNokMinne(int paakrevdMinne){
        int antNoder = 0;
//paakrevdMinne antall GB minne som kreves
	// @return antall noder med tilstrekkelig minne
        for(Node node: noder){
            if(node != null && node.hentMinne()>=paakrevdMinne){
              antNoder+=1;
            }
        }
        return antNoder;
    }
}
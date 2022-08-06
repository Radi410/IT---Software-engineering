package Oblig1;
// Klasse for representasjon av noder i en regneklynge

class Node{
    // Oppretter en node med gitt minne-storrelse og antall prosessorer
	//  @param minne GB minne i den nye noden
	// @param antPros antall prosessorer i den nye noden
    private int minne;
    private int antPros;
    public Node(int minne, int antPros) {
        this.minne = minne;
        this.antPros = antPros;

    }
    
    public int hentMinne(){
        return minne;
    }
	// Henter antall prosessorer i noden
	//  @return antall prosessorer i noden
    public int hentAntpros(){
        return antPros;
    }
    // Sjekker om noden har tilstrekkelig minne for et program
	// @param paakrevdMinne GB minne som kreves for programmet
	//  @return True hvis noden har minst så mye minne
    public nokMinne(PaakrevdMinne){
        if(PaakrevdMinne <= minne){
            System.out.println("True");
        }
        else{
            System.out.println("false");
        }
    }
        
    }


}


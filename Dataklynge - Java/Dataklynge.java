import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;


class regneklynge{
    // Oppretter en regneklynge og setter maks antall
	// det er plass til i et rack
	// @param noderPerRack max antall noder per rack
        private int antNoderPerRack;
        private String filnavn;
        private ArrayList<Rack> r = new ArrayList<>();
        private ArrayList<String> linjer = new ArrayList<>();
    
        public Regneklynge(String filnavn){
            this.filnavn = filnavn;
            lesDataFraFil(filnavn);
        }
    
        public Regneklynge(int antNoderPerRack){
            this.antNoderPerRack=antNoderPerRack;
        }
    
        public void lesDataFraFil(String filnavn){
            File f = new File(filnavn);
            Scanner filleser = null;
    
            try{
                filleser = new Scanner(f);
                //System.out.println("Leser fil");
            } catch(FileNotFoundException e){
                System.out.println("Filen finnes ikke");
            }
    
            String linje = "";
            while(filleser.hasNextLine()){
                linjer.add(filleser.nextLine());
            }
            String antNoderPerRack1 = linjer.get(0);
            antNoderPerRack = Integer.parseInt(antNoderPerRack1);
            System.out.println("antNoderPerRack" + " " + antNoderPerRack);
    
            for(int i=1; i<linjer.size(); i++){
                String[] linjeSplit=linjer.get(i).split("\\s+");
                int antNoder = Integer.parseInt(linjeSplit[0]);
                int minne = Integer.parseInt(linjeSplit[1]);
                int antPros = Integer.parseInt(linjeSplit[2]);
                settInnNode2(antNoder, minne, antPros);
            }
            return;
        }
    
        //Plasserer en node inn i et rack med ledig plass, eller i et nytt
	//param node referanse til noden som skal settes inn i datastrukturen
        public void settInnNode2(int antNoder, int minne, int antPros){
            int i=0;
    
            while(i < antNoder){
                Node node = new Node(minne, antPros);
                settInnNode(node);
                i++;
            }
        }
    
        public int antallRack(){
            return r.size();
        }
    
        
        public void settInnNode(Node node){
            for(Rack rack: r){
                if(!rack.erFull()){
                    rack.addNode(node);
                    return;
                }
            }
    //Adder racks for hver node
            Rack rack = new Rack(antNoderPerRack);
            rack.addNode(node);
            r.add(rack);
        }
    
        public int antPros(){
            int antPros=0;
            // Beregner totalt antall prosessorer i hele regneklyngen
            // @return totalt antall prosessorer
            for(int i=0; i<r.size(); i++){
                antPros += r.get(i).antPros();
            }
            return antPros;
        }
        // Beregner antall noder i regneklyngen med minne over angitt grense
        // @param paakrevdMinne hvor mye minne skal noder som telles med ha
        // @return antall noder med tilstrekkelig minne
        public int noderMedNokMinne(int paakrevdMinne){
            int antNoder=0;
    
            for(int i=0; i<r.size(); i++){
                antNoder += r.get(i).noderMedNokMinne(paakrevdMinne);
            }
            return antNoder;
        }
    }
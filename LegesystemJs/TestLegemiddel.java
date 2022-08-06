
public class TestLegemiddel {
    public static void main(String[] args){
        Narkotisk narkotisk_test = new Narkotisk("Ocitosin", 250, 3.25, 2);
        Vanedannende vanedannende_test = new Vanedannende("Metanol", 300, 7.5, 10);
        Vanlig vanlig_test = new Vanlig("Paraset", 150, 2);
        
        if (narkotisk_test instanceof Legemiddel){ 
            System.out.println(narkotisk_test.toString());
        }
        if (vanedannende_test instanceof Legemiddel){
            System.out.println(vanedannende_test.toString());
        }
        if (vanlig_test instanceof Legemiddel){
            System.out.println(vanlig_test.toString());
        }
    }
}
    


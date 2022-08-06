public class Integrasjonstest {
    public static void main(String[] args){
        Narkotisk narkotisk_test = new Narkotisk("Ocitosin", 250, 3.25, 2);
        Vanedannende vanedannende_test = new Vanedannende("Metanol", 300, 7.5, 10);
        Vanlig vanlig_test = new Vanlig("Paraset", 150, 2);

        Lege lege_test = new Lege("Amders");
        Spesialist spesialist_test = new Spesialist("Martin", "Ja");


        HviteResepter hviteResepter_test = new HviteResepter(narkotisk_test, lege_test, 3, 2);
        MilitaerResept militaerResepter_test = new MilitaerResept(vanedannende_test, lege_test, 4);
        Presepter Presepter_test = new Presepter(vanlig_test, lege_test, 4, 1);
        BlaaResepter blaaResepter_test = new BlaaResepter(vanedannende_test, spesialist_test, 2, 3);
        System.out.println(hviteResepter_test + "\n" + militaerResepter_test + "\n" + Presepter_test + "\n" + blaaResepter_test);
    }
}
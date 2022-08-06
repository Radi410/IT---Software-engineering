public class TestResepter{ 
    public static void main(String[] args){
        Vanlig vanligTest = new Vanlig("Metformin", 100, 5.2);
        Lege legeTest = new Lege("Robert"); 

        HviteResepter hvitTest = new HviteResepter(vanligTest, legeTest, 2, 1);
        MilitaerResept militaerTest = new MilitaerResept(vanligTest, legeTest, 5);
        Presepter pTest = new Presepter(vanligTest, legeTest, 8, 3);
        BlaaResepter blaaTest = new BlaaResepter(vanligTest, legeTest, 6, 4);

        if (hvitTest instanceof Resept){
            System.out.println(hvitTest.toString());
        }
        if (militaerTest instanceof Resept){
            System.out.println(militaerTest.toString());
        }
        if(pTest instanceof Resept){
            System.out.println(pTest.toString());
        }
        if(blaaTest instanceof Resept){
            System.out.println(blaaTest.toString());
        }
    }
}

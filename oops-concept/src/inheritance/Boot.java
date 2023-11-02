package inheritance;

public class Boot {
    public static void main(String[] args) {
        System.out.println("*********** ***single inheritance****************");
        //B b=new B();
        //b.showB();
        //b.showA();
        System.out.println("**************multilavel inheritance****************");
        C c=new C();
        c.showA();
        c.showB();
        c.showC();
        System.out.println("**************Hirerchial inheritance****************");
        B b=new B();
        b.showA();
        b.showB();
        D d=new D();
        d.showA();
        d.showD();

    }
}

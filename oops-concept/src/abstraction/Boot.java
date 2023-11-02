package abstraction;

public class Boot {
    public static void main(String[] args) {
        Oppo oppo=new Oppo();
        oppo.showA();
        Vivo vivo=new Vivo();
        vivo.showA();
        Mobile mobile=new Oppo();
        mobile.showA();
    }
}

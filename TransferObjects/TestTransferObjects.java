
public class TestTransferObjects {

    public static void main(String[] args) {
        Person me = new Person("Chris", 43, "Clarksville");
        
        System.out.println(me.toXML());
        System.out.println(me.toXML("header"));
        System.out.println(me.toXML(true));
        System.out.println(me.toJSON());
        System.out.println(me.toCSV());
        System.out.println(me.toCSV(true));
    }
    
}

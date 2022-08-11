

import java.lang.reflect.Field;



public class Person {
    private String name;
    private int age;
    private String home;

    public Person() {
    }

    public Person(String name, int age, String home) {
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return name + " is " + age + " years old, and lives in " + home;
    }
    
    
    public String toXML(){
        try{
            String xml = new String();
            Field[] fields = this.getClass().getDeclaredFields();
            xml += "<" + this.getClass().getSimpleName() + ">";
            for(Field f : fields){
                if(!f.getType().isArray()){
                    xml += "<" + f.getName() + ">";
                    xml += f.get(this).toString();
                    xml += "</" + f.getName() + ">";
                }
                else{
                    xml += "<" + f.getName() + ">";
                    xml += " still working on generalizing arrays... ";
                    xml += "</" + f.getName() + ">";
                }
            }
            xml += "</" + this.getClass().getSimpleName() + ">";
            return xml;
        }
        catch(Exception e){
            //just move on then
            return "";
        }
    }//end toXML()
    

    public String toXML(boolean hasHeader){
        if(hasHeader){
            String xml = "<?xml version=\"1.0\" ?>";
            xml += this.toXML();
            return xml;
        }
        else{
            return this.toXML();
        }
    }//end toXML()


    

    public String toJSON(){
        Field[] fields = this.getClass().getDeclaredFields();
        String json = "";
        try{
            json += "{";
            for(int i=0; i < fields.length; i++){
                if(i != fields.length-1){
                    if(fields[i].getType().equals(String.class)){
                        json += "\"" + fields[i].getName() + "\": \"" + fields[i].get(this).toString() + "\", ";
                    }
                    else if(fields[i].getType().equals(int.class) || fields[i].getType().equals(float.class) || fields[i].getType().equals(double.class) || fields[i].getType().equals(boolean.class) || fields[i].getType().equals(byte.class)){
                        json += "\"" + fields[i].getName() + "\": " + fields[i].get(this).toString() + ", ";
                    }
                    else if(fields[i].getType().isArray()){
                        //json += "\"" + fields[i].getName() + "\": " + fields[i].get(this).toString() + ", ";
                        json += "\"" + fields[i].getName() + "\": [ \'still working on generalizing arrays...\' ], ";
                    }
                    else{
                        json += "\"error\": \"type not supported in json\", ";  
                    }
                }
                else{
                    if(fields[i].getType().equals(String.class)){
                        json += "\"" + fields[i].getName() + "\": \"" + fields[i].get(this).toString() + "\"";
                    }
                    else if(fields[i].getType().equals(int.class) || fields[i].getType().equals(float.class) || fields[i].getType().equals(double.class) || fields[i].getType().equals(boolean.class) || fields[i].getType().equals(byte.class)){
                        json += "\"" + fields[i].getName() + "\": " + fields[i].get(this).toString();
                    }
                    else if(fields[i].getType().isArray()){
                        //json += "\"" + fields[i].getName() + "\": " + fields[i].get(this).toString();
                        json += "\"" + fields[i].getName() + "\": [ \'still working on generalizing arrays...\' ]";
                    }
                    else{
                        json += "\"error\": \"type not supported in json\"";  
                    }
                }

            }
            json += "}";
           }
        catch(Exception e){
            // just move on then
        }
        return json;
    }//end toJSON()
    
    
    public String toCSV(){
        String row = "";
        Field[] fields = this.getClass().getDeclaredFields();
        try{
            for(int i=0; i<fields.length; i++){
                if(i != fields.length-1){
                    if(fields[i].getType().equals(String.class)){
                        row += "\"" + fields[i].get(this).toString() + "\",";
                    }
                    else if(fields[i].getType().isArray()){
                        //row += fields[i].get(this).toString() + ",";
                        row += "\"[ still working on generalizing arrays... ]\",";
                    }
                    else{
                        row += fields[i].get(this).toString() + ",";
                    }
                }
                else{
                    if(fields[i].getType().equals(String.class)){
                        row += "\"" + fields[i].get(this).toString() + "\"\n";
                    }
                    else if(fields[i].getType().isArray()){
                        //row += fields[i].get(this).toString() + "\n";
                        row += "\"[ still working on generalizing arrays... ]\"\n";
                    }
                    else{
                        row += fields[i].get(this).toString() + "\n";
                    }
                }
            }
        }
        catch(Exception e){
            //just move on then
        }
        return row;
    }//end toCSV()



    public String toCSV(boolean hasHeader){
        if(hasHeader){
            String row = "";
            Field[] fields = this.getClass().getDeclaredFields();
            for(int i=0; i<fields.length; i++){
                if(i != fields.length-1){
                    row += fields[i].getName() + ",";
                }
                else{
                    row += fields[i].getName() + "\n";
                }
            }
            row += this.toCSV();
            return row;
        }
        else{
            return this.toCSV();
        }
    }//end toCSV()
    
    
    
}//end Person class()

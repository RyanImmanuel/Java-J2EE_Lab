import java.util.*;

class Contact{
    Long number;
    String name;
    Contact(Long number,String name){
        this.number=number;
        this.name=name;
    }
    void display(){
        System.out.println("number:"+number+"  name:"+name);
    }
}

class sorti implements Comparator<Contact>{
    public int compare(Contact b1,Contact b2){
        return (int)(b1.number-b2.number);
    }
}

public class Main{
    public static void main(String args[]){
        HashMap<Long,String> Contacthm=new HashMap<Long,String>();
        ArrayList<Contact> mc = new ArrayList<Contact>();
        Scanner sc= new Scanner(System.in);
        
        for(int i=0;i<3;i++){
            System.out.print("enter the number: ");
            Long num=sc.nextLong();
            System.out.print("enter the name: ");
            String name=sc.next();
            Contacthm.put(num,name);
            
        }
        System.out.println("hm: ");
        System.out.println(Contacthm);
        
        for(int i=0;i<3;i++){
            System.out.print("enter the number: ");
            Long num=sc.nextLong();
            if(Contacthm.containsKey(num)){
                Contact missed=new Contact(num,Contacthm.get(num));
                mc.add(missed);
            }
            else{
                Contact missed=new Contact(num,"Private Number");
                mc.add(missed);
            }
        }
        for(Contact c:mc){
            System.out.println(c.number+" "+c.name);
        }
        Collections.sort(mc,new sorti());
        for(Contact c:mc){
            System.out.println(c.number+" "+c.name);
        }
        
        System.out.println("enter the number to be deleted: ");
        Long number=sc.nextLong();
        
        if(Contacthm.containsKey(number)){
            Contacthm.remove(number);
            System.out.println("number removed...");
        }
        else{
            System.out.println("number not found in hm...");
        }
        System.out.println(Contacthm);
        
        for(Contact c:mc){
            if(c.name.equals("ryan")){
                c.display();
            }
        }
        System.out.println(" ");
        for(Contact c:mc){
            if(c.name.contains("r")){
                c.display();
            }
        }
        
        
    }
}

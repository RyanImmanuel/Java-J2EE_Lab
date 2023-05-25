import java.util.*;

class Thread1 extends Thread{
    String l[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    Scanner sc= new Scanner(System.in);
    int n=0;
    
    public void run(){
        
        try {
            int num=sc.nextInt();
            if(num>=9999 || num<1000){
                throw new Exception();
            }
            else{
                while(num!=0){
                    n=num%10;
                    System.out.println(l[n]);
                    num=num/10;
                }
            }
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Thread2 extends Thread{
    Scanner sc= new Scanner(System.in);
    
    public void run(){
        ArrayList<Character> l= new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int vowels=0;
        
        String word=sc.next();
        for(int i=0;i<word.length();i++){
            if(l.contains(word.charAt(i))){
                vowels++;
            }
        }
        System.out.println(vowels);
    }
}

public class Main{
    public static void main(String args[]){
        Thread1 obj1=new Thread1();
        Thread2 obj2=new Thread2();
        obj1.run(); obj2.run();
    }
}

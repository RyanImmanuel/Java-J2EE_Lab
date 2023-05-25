package threeagain;

public class Student {
	String name;
    int age;
    double cgpa;

    Student(String name, int age,double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    String printDetails(){
        return "\n----Printing the Details----" + "\nName : " + this.name + "\nAge : " + this.age + "\nCGPA : " + this.cgpa;
    }
}

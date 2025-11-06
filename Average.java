import java.util.Scanner;
public class Average {
 public static void main(String[] args){
   Scanner scanner = new Scanner(System.in);

   System.out.println("Enter your name:");
   String name = scanner.nextLine();
   System.out.println("Enter your age:");
   int age = scanner.nextInt();
   System.out.println("Enter your hobby:");
   String hobby = scanner.nextLine();
 


   System.out.println("-----Your profile-----");
   System.out.println("Name:" + name);
   System.out.println("Age:" + age);
   System.out.println("Hobby:" + hobby);
  }
   


}


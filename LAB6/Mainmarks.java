import SEE.*;
import java.util.Scanner;
public class Mainmarks {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter no of students:");
        int n = s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("name:");
            String name = s.nextLine();
            System.out.println("usn:");
            String usn = s.nextLine();
            System.out.println("Sem:");
            int sem = s.nextInt();
            s.nextLine();
            Externals e = new Externals(usn,name,sem);
            e.displaydetails();
            e.getintmarks();
            e.dispintmarks();
            e.getextmarks();
            e.displayextmarks();
            e.totalmarks();
            System.out.println("HITESH SHARMA");
            System.out.println("1BM23CS114");
        }
    }
}

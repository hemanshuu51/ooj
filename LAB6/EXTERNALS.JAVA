package SEE;
import CIE.*;
import java.util.Scanner;
public class Externals extends Internals{
    public Externals(String usn,String name,int sem){
        super(usn,name,sem);
    }
    int[] extmarks = new int[5];
    public void getextmarks(){
        Scanner s = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println("enter external marks:");
            extmarks[i] = s.nextInt();
            s.nextLine();
        }
    }
    public void displayextmarks(){
        for(int i=0;i<5;i++) {
            System.out.println("external marks:" + extmarks[i]);
        }
    }
    public void totalmarks(){
        for(int i=0;i<5;i++){
            int total = intmarks[i]+extmarks[i];
            System.out.println("total marks:"+total);
        }
    }
}

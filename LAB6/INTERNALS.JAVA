
package CIE;
import java.util.Scanner;
public class Internals extends Personal {
    public Internals(String usn,String name,int sem){
        super(usn,name,sem);
    }
    public int[] intmarks = new int[5];
    public void getintmarks(){
        Scanner s = new Scanner(System.in);
        for(int i=0;i<5;i++) {
            System.out.println("enter internal marks:");
            intmarks[i] = s.nextInt();
            s.nextLine();
        }
    }
    public void dispintmarks(){
        for(int i=0;i<5;i++){
            System.out.println("internal marks:"+intmarks[i]);
        }
    }
}

package CIE;
public class Personal {
    String usn;
    String name;
    int sem;
    public Personal(String usn,String name,int sem){
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
    public void displaydetails(){
        System.out.println("Name:"+name);
        System.out.println("USN:"+usn);
        System.out.println("Sem:"+sem);
    }
}

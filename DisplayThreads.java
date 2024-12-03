class BMSDisplayThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

class CSEDisplayThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class DisplayThreads {
    public static void main(String[] args) {
        BMSDisplayThread bmsThread = new BMSDisplayThread();
        CSEDisplayThread cseThread = new CSEDisplayThread();

        bmsThread.start();
        cseThread.start();
    }
}
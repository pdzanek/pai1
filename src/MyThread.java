
public class MyThread implements Runnable {
    private Thread t;
    private String threadName;

    public MyThread(String arg) {
        threadName = arg;
    }

    public void run() {
        LineCounter lc = new LineCounter(threadName);
        System.out.println("Ilość linii pliku: "+threadName+": "+lc.numberOfLines());
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

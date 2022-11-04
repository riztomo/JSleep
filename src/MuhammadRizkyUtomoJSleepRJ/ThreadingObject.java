package MuhammadRizkyUtomoJSleepRJ;

public class ThreadingObject extends Thread {

    public ThreadingObject(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(super.getName() + " is running");
        System.out.println("Thread id: " + super.getId());
    }
}

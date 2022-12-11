package com.MuhammadRizkyUtomoJSleepRJ;

public class ThreadingObject extends Thread {
    /**
     * Constructor of ThreadingObject
     * @param name
     */
    public ThreadingObject(String name) {
        super(name);
    }

    /**
     * Runs thread
     */
    @Override
    public void run() {
        System.out.println(super.getName() + " is running");
        System.out.println("Thread id: " + super.getId());
    }
}

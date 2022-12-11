package com.MuhammadRizkyUtomoJSleepRJ;

/**
 * Makes a processing thread.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
 */
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

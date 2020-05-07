package org.sparta.tk.employeeManager;

public class EmployeeThreadManager {

    private void threadingAllEmployee() throws InterruptedException {
        int numOfThreads = 10000;

        // Create the threads
        Thread[] threadList = new Thread[numOfThreads];

        // spawn threads
        for (int i = 0; i < numOfThreads; i++)
        {
            threadList[i].start();
        }

        // wait for all threads to end
        for (int i = 0; i < numOfThreads; i++)
        {
            threadList[i].join();
        }
    }
}

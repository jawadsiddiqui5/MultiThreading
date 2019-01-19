/*
 * Multi-Threading application
 * 
 */
package multithreading;


import java.util.Random;

public class MultiThreading extends Thread
{

    private int id; // thread number

    private static float[] shareddata; // shared data array
    
    
    public static int numberOfThreads = 1;
    
    private static int getAmountOfValuesForAThread(){
        return 100000000 / numberOfThreads;
    }

    public MultiThreading(int i)
    {
        id = i;
    }

    /* run method of the thread */
    public void run()
    {
       int a;

       Random generator = new Random();

       System.out.println("Thread " + id + " running");
       long t = System.currentTimeMillis()/1000;
        
       int startingPosition  = (id-1)*getAmountOfValuesForAThread();
       for (a= startingPosition; a <  startingPosition + getAmountOfValuesForAThread(); a++) shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));  
       
       System.out.println("Thread " + id + " took " + (System.currentTimeMillis()/1000 - t) + " seconds ");


    }

    public static void main(String[] args)
    {
        final int N = 2; // number of threads
        
        shareddata = new float[100000000];
        
        System.out.println("Starting Multi-threading..."); 

        MultiThreading[] thread = new MultiThreading[N];
        
        MultiThreading.numberOfThreads = N;
        
        
        for (int i = 0; i < N; i++)
        {
            /* initialise each thread */
            thread[i] = new MultiThreading(i+1);
	    /* start each thread */
            thread[i].start();
        }
    }
}


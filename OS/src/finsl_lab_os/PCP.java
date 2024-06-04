//doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee

//Lab 06 - Process and Thread Synchronization ConceptsLab 
//This a C implementation for Producer Consumer Problem using
//Semaphores and Threads

import java.util.concurrent.Semaphore;

public class PCP{
    
    private static final int BUFFER_SIZE = 5;
    private static final int MAX_ITEMS = 20;
    private static int[] buffer = new int[BUFFER_SIZE];
    private static int in = 0;
    private static int out = 0;
    private static int produced_Count = 0;
    private static int consumed_Count = 0;
    
    
    private static Semaphore mutex = new Semaphore(1); //keep track on the critical section
    private static Semaphore full = new Semaphore(0);// 0 mean no free space 
    private static Semaphore empty = new Semaphore(BUFFER_SIZE);// all the spaces is free
    
    
    public static void main(String[] args){
        
        Thread producerThread = new Thread(PCP::producer);
        Thread consumerThread = new Thread(PCP::consumer);
        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
           }
        catch(InterruptedException e) {
            e.printStackTrace();
    }}

    private static void producer(){
        int item = 1;

        while(produced_Count < MAX_ITEMS){
            try{
                empty.acquire();
                mutex.acquire();
                
                buffer[in] = item;
                System.out.println("Produced: " + item);
                item++;
                in = (in + 1) % BUFFER_SIZE;
                produced_Count++;
                
                mutex.release();
                full.release();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
        
        }}}
    
    private static void consumer(){
        while(consumed_Count < MAX_ITEMS){
            try{
                full.acquire();
                mutex.acquire();
                
                int item = buffer[out];
                System.out.println("Consumed: " + item);
                out = (out + 1) % BUFFER_SIZE;
                
                consumed_Count++;
                mutex.release();
                empty.release();
                
            } catch (InterruptedException e){
                e.printStackTrace();
        
        }}}}


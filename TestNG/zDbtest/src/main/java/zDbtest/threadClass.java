package zDbtest;

public class threadClass extends Thread {

	
	    int counter= 0;
	    public static void main(String args[]) throws Throwable {      
	    	threadClass t[] = new threadClass[10];
	        for (int j=0; j<10;j++) {
	            t[j] = new threadClass();
	            t[j].start();       
	        }          
	    }
	    public void run() {
	        try {
	            System.out.println("thread " + Thread.currentThread().getName()+" step "+counter++);
	        } 
	        catch (Throwable t) { 
	            t.printStackTrace();
	        }
	        
	        System.out.println("hi");
	        
	    }
	}


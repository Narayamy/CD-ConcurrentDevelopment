/*
 * HappyNumsParallel.java
 *
 */

package Q02;

import java.util.*;

public class HappyNumsParallel {
	public static void main(String[] args) {
		int numProc = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of processors =" + numProc);
		//int base = Integer.MAX_VALUE/numProc;
		int MaxNum = 1000000;
		int base = MaxNum/numProc;
		HappyNumFinder[] nf = new HappyNumFinder[numProc];
		int n = 1; 
		for(int j = 0; j < numProc;j++){
			nf[j] = new HappyNumFinder(n,base*(j+1));
			n = (j+1)*base;
		}
    	long startTime = System.currentTimeMillis();
    	for(int j = 0; j < numProc; j++) nf[j].start();
    	try{
			for(int j = 0; j < numProc; j++)
				nf[j].join();
    	}
    	catch(InterruptedException e){}
    	long endTime = System.currentTimeMillis();
    	long runningTime = endTime - startTime;
    	int total = 0;
    	for(int j = 0; j < numProc; j++) total = total + nf[j].num();
			HappySad hs = new HappySad();
			if(hs.isHappy(MaxNum)) total++;
			System.out.println("Number of happy numbers: "+total);
    	System.out.println("Running Time = " + runningTime/1000.0+ " secs");
    }
    
}
class HappySad{
	public  boolean isHappy(int n){
    	//assume n >=1
    	int h = n;
    	while(h != 1 && !isSad(h)) h = sumSquares(h);
    	if(h == 1)
    		return true;
    	else
    		return false;
    }
    private  int sumSquares(int n){
    	int s = 0;
    	while(n > 0){
    		int r = n%10;
    		s = s + r*r;
    		n = n/10;
    	}
    	return s;
    }
    public boolean isSad(int n){
    	int cycleNums[] = {4,16,37,58,145,20};
    	boolean found = false;
    	int j = 0;
    	while(j<cycleNums.length && !found)
    		if(cycleNums[j] == n)
    			found = true;
    		else
    			j++;
    	return found;
    }
}

class HappyNumFinder extends Thread{
	int total = 0;
	int lb, ub;
	public HappyNumFinder(int a, int b){
		lb = a; ub = b;
	}
	public void run(){
	  HappySad h = new HappySad(); 
		int n = lb;
    	//Happy numbers not stored
    	int j = 0;
    	//int max = 0;
    	while(n < ub){
    		if(h.isHappy(n)){
    			 j++;
    		}
    		n++;
    	}
        total = j;	
	}
	public int num(){
		return total;
	}
}

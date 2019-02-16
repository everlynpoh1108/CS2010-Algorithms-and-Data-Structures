import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Everlyn Poh
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	int n = a.length ;
    	for (int i=1 ; i<n ; i++)
    	{
    		double key = a[i] ;
    		int j = i-1 ;
    		
    		while (j>=0 && a[j]>key)
    		{
    			a[j+1] = a[j] ;
    			j = j-1 ;
    		}
    		a[j+1] = key ;
    	}
    	return a ;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	int n = a.length ;
    	a = quickSort.sort(a,0,n-1) ;
		return a ;
    }
    
    static class quickSort {
    	static double[]sort(double a[], int low, int high)
        {
    		if (high>low)
    		{
    			int pivot = partition (a,low,high) ;
    			a = sort(a,low,pivot-1) ;
    			a = sort(a,pivot+1,high) ;
    		}
        	return a ;
        }
    	
    	static int partition(double a[], int low, int high)
    	{
    		double pivot = a[high] ;
    		int i = low-1 ;
    		for (int j=low ; j<high ; j++)
    		{
    			//If current element is <= to pivot
    			if (a[j] <= pivot)
    			{
    				i++ ;
    				double temp = a[i] ;
    				a[i] = a[j] ;
    				a[j] = temp ;
    			}
    		}
    		double temp = a[i+1] ;
    		a[i+1] = a[high] ;
    		a[high] = temp ;
    		
    		return i+1 ;
    	}
    }
    

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	int n = a.length ;
    	mergeSortIterative.sort(a,n);
		
    	return a ;
    }
    
    static class mergeSortIterative {
    	static void sort (double a[], int n)
    	{
    		int currentSize ;
    		int leftStart ;
    		
    		for(currentSize=1 ; currentSize<=n-1 ; currentSize=2*currentSize)
    		{
    			for (leftStart=0 ; leftStart<n-1 ; leftStart+=2*currentSize)
    			{
    				int mid = leftStart + currentSize -1 ;
    				int rightEnd = Math.min(leftStart+2*currentSize-1, n-1) ;
    				merge(a,leftStart,mid,rightEnd) ;
    			}
    		}
    	}
    	
    	static void merge(double a[], int l, int m, int r) 
    	{
    		int i,j,k ;
    		int n1 = m-l +1 ;
    		int n2 = r-m ;
    		
    		double L[] = new double[n1] ;
    		double R[] = new double[n2] ;
    		
    		for (i=0 ; i<n1 ; i++)
    		{
    			L[i] = a[l+i] ;
    		}
    		for (j=0 ; j<n2 ; j++)
    		{
    			R[j] = a[m+1+j] ;
    		}
    		
    		i=0 ;
    		j=0 ;
    		k=l ;
    		
    		while (i<n1 && j<n2)
    		{
    			if (L[i] <= R[j])
    			{
    				a[k] = L[i] ;
    				i++ ;
    			}
    			else
    			{
    				a[k] = R[j] ;
    				j++ ;
    			}
    			k++ ;
    		}
    		
    		while (i<n1)
    		{
    			a[k] = L[i] ;
    			i++ ;
    			k++ ;
    		}
    		
    		while (j<n2)
    		{
    			a[k] = R[j] ;
    			j++ ;
    			k++ ;
    		}
    	}
    	
    	
    }
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if (a == null)
    	{
    		return null ;
    	}
    	
    	if (a.length>1)
    	{
    		int mid = a.length/2 ;
    		
    		//Split left part
    		double[]left = new double[mid] ;
    		for (int i=0 ; i<mid ; i++)
    		{
    			left[i] = a[i] ;
    		}
    		
    		//Split right part
    		double[]right = new double[a.length-mid] ;
    		for (int i= mid ; i<a.length ; i++)
    		{
    			right[i-mid] = a[i] ;
    		}
    		
    		mergeSortRecursive(left) ;
    		mergeSortRecursive(right) ;
    		
    		int i=0 ;
    		int j=0 ;
    		int k=0 ;
    		
    		//Merge left and right arrays
    		while (i<left.length && j<right.length)
    		{
    			if (left[i] <right[j])
    			{
    				a[k] = left[i] ;
    				i++ ;
    			}
    			else {
    				a[k] = right[j] ;
    				j++ ;
    			}
    			k++ ;
    		}
    		
    		//Collect remaining elements
    		while (i<left.length)
    		{
    			a[k] = left[i] ;
    			i++ ;
    			k++ ;
    		}
    		
    		while (j<right.length)
    		{
    			a[k] = right[j] ;
    			j++ ;
    			k++ ;
    		}
    	}
    	
    	
    	return a ;
    }
    
 
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	int n = a.length ;
    	for (int i=0 ; i<n-1 ; i++)
    	{
    		int minIndex = i ;
    		for ( int j= i+1 ; j<n ; j++)
    		{
    			if (a[j] < a[minIndex])
    			{
    				minIndex = j ;
    			}
    		}
    		
    		double temp = a[minIndex] ;
    		a[minIndex] = a[i] ;
    		a[i] = temp ;
    	}
    	
    	return a ;
    }

   
    public static String toString(double a[]) {
    	String result = "" ;
    	for(int i=0; i<a.length ;i++)
        {
        	result = result + a[i]+ " " ;
        }
    	return result ;
    }

    public static void main(String[] args) {
    	//double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
        //a = selectionSort(a) ;
        //System.out.println(toString(a));
    	long startTime = System.currentTimeMillis();
    	int index = 0 ;
    	int size = 1000 ;
    	double a[] = new double[size] ;
    	File file = new File("numbersSorted1000.txt");
    	//System.out.println(System.getProperty("user.dir"));
    	Scanner sc ;
    	try {
			sc = new Scanner(file) ;
			while((sc.hasNextDouble()))
			{
				a[index] = sc.nextDouble() ;
				index++ ;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	a = insertionSort(a) ;
    	System.out.println(SortComparison.toString(a));
    	long endTime   = System.currentTimeMillis();
    	long totalTime = endTime - startTime;
    	System.out.println(totalTime);
    }

 }//end class


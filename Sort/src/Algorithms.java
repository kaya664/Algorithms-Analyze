import java.util.Date;


public class Algorithms {
	//time variables
	int data[];
	long start=0,finish=0;
	 private int[] numbers;
	  private int[] helper;
	  private int number;
	  static long basicOps=0;
	  //insertion sort algorithms
	public void insertionSort(int a[]){
		//for all elements of array
		//basicOps calculates the basic operation numbers
    	for(int i=1;i<a.length;i++){
    		int temp=a[i];
    		int j;
    		for(j=i-1;j>=0 && temp<a[j];j--){
    			a[j+1]=a[j];
    			basicOps++;
    		}
    		a[j+1]=temp;
    		basicOps+=2;
    	}
      }
  public double setTime(){
	  return System.currentTimeMillis();
  }
  public void sort(int[] values) {
	    this.numbers = values;
	    number = values.length;
	    this.helper = new int[number];
	    mergesort(0, number - 1);
	  }

	  private void mergesort(int low, int high) {
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      basicOps++;
	      // Sort the left side of the array
	      mergesort(low, middle);
	      // Sort the right side of the array
	      mergesort(middle + 1, high);
	      // Combine them both
	      merge(low, middle, high);
	    }
	  }

	  private void merge(int low, int middle, int high) {

	    // Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	      basicOps++;
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	      if (helper[i] <= helper[j]) {
	        numbers[k] = helper[i];
	        basicOps+=2;
	        i++;
	      } else {
	        numbers[k] = helper[j];
	        basicOps+=2;
	        j++;
	      }
	      k++;
	      basicOps++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	      basicOps+=3;
	    }
        basicOps+=3;
	  }
	  public void quickFirstSort(int array[]) 
	// pre: array is full, all elements are non-null integers
	// post: the array is sorted in ascending order
	{
		quickSort(array, 0, array.length - 1);              // quicksort all the elements in the array
	}


	public void quickSort(int array[], int start, int end)
	{
	        int i = start;                          // index of left-to-right scan
	        int k = end;                            // index of right-to-left scan
            basicOps+=2;
	        if (end - start >= 1)                   // check that there are at least two elements to sort
	        {
	                int pivot = array[start];       // set the pivot as the first element in the partition
                    basicOps++;
	                while (k > i)                   // while the scan indices from left and right have not met,
	                {
	                        while (array[i] <= pivot && i <= end && k > i){  // from the left, look for the first
	                                i++;                 
	                                basicOps++;
	                        }// element greater than the pivot
	                        while (array[k] > pivot && k >= start && k >= i){ // from the right, look for the first
	                            k--;                           
	                            basicOps++;
	                        }// element not greater than the pivot
	                        if (k > i)                                       // if the left seekindex is still smaller than
	                                swaps(array, i, k);                      // the right index, swap the corresponding elements
	                }
	                swaps(array, start, k);          // after the indices have crossed, swap the last element in
	                                          // the left partition with the pivot 
	                quickSort(array, start, k - 1); // quicksort the left partition
	                quickSort(array, k + 1, end);   // quicksort the right partition
	        }
	        else    // if there is only one element in the partition, do not do any sorting
	        {
	                return;                     // the array is sorted, so exit
	        }
	}

	public void swaps(int array[], int index1, int index2) 
	// pre: array is full and index1, index2 < array.length
	// post: the values at indices 1 and 2 have been swapped
	{
		int temp = array[index1];           // store the first value in a temp
		array[index1] = array[index2];      // copy the value of the second into the first
		array[index2] = temp;
		basicOps+=3;// copy the value of the temp into the second
	}
		public void quickSort(int a[]) {
			this.data=a;
		    recQuickSort(0, a.length - 1);
		  }

		  public void recQuickSort(int left, int right) {
		    int size = right - left + 1;
		    basicOps++;
		    if (size <= 3) // manual sort if small
		      manualSort(left, right);
		    else // quicksort if large
		    {
		      long median = medianOf3(left, right);
		      int partition = partitionIt(left, right, median);
		      basicOps+=2;
		      recQuickSort(left, partition - 1);
		      recQuickSort(partition + 1, right);
		    }
		  }

		  public long medianOf3(int left, int right) {
		    int center = (left + right) / 2;
		    basicOps+=1;
		    // order left & center
		    if (data[left] > data[center])
		      swap(left, center);
		    // order left & right
		    if (data[left] > data[right])
		      swap(left, right);
		    // order center & right
		    if (data[center] > data[right])
		      swap(center, right);
		    swap(center, right - 1); // put pivot on right
		    return data[right - 1]; // return median value
		  }

		  public void swap(int dex1, int dex2) {
		    int temp = data[dex1];
		    data[dex1] = data[dex2];
		    data[dex2] = temp;
		    basicOps+=3;
		  }

		  public int partitionIt(int left, int right, long pivot) {
		    int leftPtr = left; // right of first elem
		    int rightPtr = right - 1; // left of pivot
basicOps+=2;
		    while (true) {
		      //       find bigger
		      while (data[++leftPtr] < pivot)
		        ;
		      //       find smaller
		      while (data[--rightPtr] > pivot)

		        ;
		      if (leftPtr >= rightPtr) // if pointers cross, partition done
		        break;    
		      else
		        // not crossed, so
		        swap(leftPtr, rightPtr); // swap elements
		    }
		    swap(leftPtr, right - 1); // restore pivot
		    return leftPtr; // return pivot location
		  }

		  public void manualSort(int left, int right) {
		    int size = right - left + 1;
		    basicOps++;
		    if (size <= 1)
		      return; // no sort necessary
		    if (size == 2) { // 2-sort left and right
		      if (data[left] > data[right])
		        swap(left, right);
		      return;
		    } else // size is 3
		    { // 3-sort left, center, & right
		      if (data[left] > data[right - 1])
		        swap(left, right - 1); // left, center
		      if (data[left] > data[right])
		        swap(left, right); // left, right
		      if (data[right - 1] > data[right])
		        swap(right - 1, right); // center, right
		    }
		  }
}

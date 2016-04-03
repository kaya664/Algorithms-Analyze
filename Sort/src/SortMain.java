import java.io.FileWriter;
import java.io.IOException;


public class SortMain {
      //objects and variables to create and sort process
	  static ArrayCreate arrays;
	  static double start=0;
	  static double finish=0;
	  static Algorithms sorts=new Algorithms();
      public static void main(String[] args){
    	  arrays=new ArrayCreate();
    	  //sizes
    	  int size[]={5000,10000,25000,50000,100000,250000,500000};
    	  //creating arrays with different types and sizes
    	  int[] normal0=create(0,size[0]);
    	  int[] normal1=create(0,size[1]);
    	  int[] normal2=create(0,size[2]);
    	  int[] normal3=create(0,size[3]);
    	  int[] normal4=create(0,size[4]);
    	  int[] normal5=create(0,size[5]);
    	  int[] normal6=create(0,size[6]);
    	  int[] sorted0=create(1,size[0]);
    	  int[] sorted1=create(1,size[1]);
    	  int[] sorted2=create(1,size[2]);
    	  int[] sorted3=create(1,size[3]);
    	  int[] sorted4=create(1,size[4]);
    	  int[] sorted5=create(1,size[5]);
    	  int[] sorted6=create(1,size[6]);
    	  int[] unsorted0=create(2,size[0]);
    	  int[] unsorted1=create(2,size[1]);
    	  int[] unsorted2=create(2,size[2]);
    	  int[] unsorted3=create(2,size[3]);
    	  int[] unsorted4=create(2,size[4]);
    	  int[] unsorted5=create(2,size[5]);
    	  int[] unsorted6=create(2,size[6]);
    	  int[] almostsorted0=create(3,size[0]);
    	  int[] almostsorted1=create(3,size[1]);
    	  int[] almostsorted2=create(3,size[2]);
    	  int[] almostsorted3=create(3,size[3]);
    	  int[] almostsorted4=create(3,size[4]);
    	  int[] almostsorted5=create(3,size[5]);
    	  int[] almostsorted6=create(3,size[6]);
    	  //calling the function to do all sort types for all arrays
    	  doEachSort(normal0,"RandomSorted 5000");
    	  doEachSort(sorted0,"BestSorted 5000");
    	  doEachSort(unsorted0,"WorstSorted 5000");
    	  doEachSort(almostsorted0,"AlmostSorted 5000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal1,"RandomSorted 10000");
    	  doEachSort(sorted1,"BestSorted 10000");
    	  doEachSort(unsorted1,"WorstSorted 10000");
    	  doEachSort(almostsorted1,"AlmostSorted 10000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal2,"RandomSorted 25000");
    	  doEachSort(sorted2,"BestSorted 25000");
    	  doEachSort(unsorted2,"WorstSorted 25000");
    	  doEachSort(almostsorted2,"AlmostSorted 25000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal3,"RandomSorted 50000");
    	  doEachSort(sorted3,"BestSorted 50000");
    	  doEachSort(unsorted3,"WorstSorted 50000");
    	  doEachSort(almostsorted3,"AlmostSorted 50000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal4,"RandomSorted 100000");
    	  doEachSort(sorted4,"BestSorted 100000");
    	  doEachSort(unsorted4,"WorstSorted 100000");
    	  doEachSort(almostsorted4,"AlmostSorted 100000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal5,"RandomSorted 250000");
    	  doEachSort(sorted5,"BestSorted 250000");
    	  doEachSort(unsorted5,"WorstSorted 250000");
    	  doEachSort(almostsorted5,"AlmostSorted 250000");
    	  System.out.println("\n\n\n");
    	  doEachSort(normal6,"RandomSorted 500000");
    	  doEachSort(sorted6,"BestSorted 500000");
    	  doEachSort(unsorted6,"WorstSorted 500000");
    	  doEachSort(almostsorted6,"AlmostSorted 500000");
    	  
      }
      //creating array
      public static int[] create(int i,int j){
    	  
    	  switch(i){
    	  //create random array
    	  case 0:return arrays.createArray(j);
    	  //create sorted array
    	  case 1:return arrays.createBestSortedArray(j);
    	  //create reverse sorted array
    	  case 2:return arrays.createWorstSortedArray(j);
    	  //create almost sorted array
    	  case 3:return arrays.createAlmostSortedArray(j,j/250);
    	  }
    	  return arrays.createArray(j);
      }
      public static void doEachSort(int a[],String type){
    	  //insertion
    	  sortInsertionAndFindTime(a,type);
    	  //quick median
    	  sortMedianQuickAndFindTime(a,type);
    	  //quick first
    	  sortFirstElementQuickAndFindTime(a,type);
    	  //merge 
    	  sortMergeAndFindTime(a,type);
      }
      //insertion sort
      public static void sortInsertionAndFindTime(int a[],String type){
    	  start=sorts.setTime();//set start time
    	  sorts.insertionSort((int[]) a.clone());//sort the array
    	  finish=(sorts.setTime());//set finish time
    	  System.out.println("Execution time :"+(finish-start)+"\nBasic Operations :"+sorts.basicOps);
    	  writeOut(finish-start,sorts.basicOps,"Insertion Sort - "+type+" Array");//write to a file
    	  sorts.basicOps=0;//initialize basic ops number as 0
      }
      public static void sortMedianQuickAndFindTime(int a[],String type){
    	  System.out.println("Quick Median Sort - "+type+" Array");
    	  start=sorts.setTime();//set start time
    	  sorts.quickSort(a);//sort the array
    	  finish=(sorts.setTime());//set finish time 
    	  System.out.println("Execution time :"+(finish-start)+"\nBasic Operations :"+sorts.basicOps);
    	  writeOut(finish-start,sorts.basicOps,"Quick Sort - "+type+" Array");//write the outputs to a file
    	  sorts.basicOps=0;//initialize basic ops number as a
      }
      public static void sortFirstElementQuickAndFindTime(int a[],String type){
    	  System.out.println("Quick First Sort - "+type+" Array");
    	  start=sorts.setTime();//set start time
    	  sorts.quickFirstSort((int[]) a.clone());//sort
    	  finish=(sorts.setTime());//set finish time 
    	  System.out.println("Execution time :"+(finish-start)+"\nBasic Operations :"+sorts.basicOps);
    	  writeOut(finish-start,sorts.basicOps,"Quick First Sort - "+type+" Array");// write output
    	  sorts.basicOps=0;
      }
      public static void sortMergeAndFindTime(int a[],String type){
    	  System.out.println("Merge Sort - "+type+" Array");
    	  start=sorts.setTime();//set start time
    	  sorts.sort(a);//sort
    	  finish=(sorts.setTime());//set finish time
    	  System.out.println("Execution time :"+(finish-start)+"\nBasic Operations :"+sorts.basicOps);
    	  writeOut(finish-start,sorts.basicOps,"Merge Sort - "+type+" Array");//write output
    	  sorts.basicOps=0;
      }
      public static void writeOut(double time,long basicOps,String process){
    	  try
    	  {
    		  //open output file
    	      String filename= "outputSorts.txt";
    	      FileWriter fw = new FileWriter(filename,true);//the true will append the new data
    	      //append to the file, 
    	      fw.write(process+" time: "+time+"  Basic Operations:  "+basicOps);
    	      //go to next line
    	      fw.write("\r\n\r\n\r\n");//appends the string to the file
    	      //close file
    	      fw.close();
    	  }
    	  catch(IOException ioe)
    	  {
    	      System.err.println("IOException: " + ioe.getMessage());
    	  }
      }
}
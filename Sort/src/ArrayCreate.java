//class for creating arrays
public class ArrayCreate {
	//creates an array with size j , random
     public int[] createArray(int j){
    	 int a[] = new int[j];
    	 for(int i=0;i<a.length;i++){
    		 a[i]=(int) (Math.random()*100);
    	 }
    	 return a;
     }
     //creates a sorted array with size j
     public int[] createBestSortedArray(int j){
    	 int a[] = new int[j];
    	 for(int i=0;i<a.length;i++){
    		 a[i]=i;
    	 }
    	 return a;
     }
     //creates a reverse sorted array
     public int[] createWorstSortedArray(int j){
    	 int a[] = new int[j];
    	 for(int i=0;i<a.length;i++){
    		 a[i]=j;
    		 j--;
    	 }
    	 return a;
     }
     //creates almost sorted array with  size i
     public int[] createAlmostSortedArray(int i,int ceil){
    	 int a[]=new int[i];
    	 //creates sorted array
    	 for(int j=0;j<i;j++){
    		 a[j]=j;
    	 }
    	 //initialize some elements randomly
    	 for(int j=0;j<ceil;j++){
    		 a[(int) (Math.random()*i)]=(int) (Math.random()*i);
    	 }
    	 return a;
     }
}

package Assignments;

public class Day3 {
public static void main(String[] args) {
		
	 int pincome[] = {82, 52, -2, 31, 26, 11};

     System.out.println("Array before sorting...");
     print(pincome);

     int[] rpincome = sort(pincome, true);

     System.out.println("Array after sorting......");
     print(rpincome);
     
     int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	 int sum = diagonal_sum(arr);
     System.out.println("Sum of diagonals of the 4X4 matrix: "+sum);
 }

 static int[] sort(int[] avalues, boolean isAsc) {
	 int n = avalues.length, tmp;
	 if(isAsc) {
	     for (int i = 0; i < n; i++) {
	         for (int j = 0; j < n - 1 - i; j++) {
	             if (avalues[j] > avalues[j + 1]) {
	                 tmp = avalues[j];
	                 avalues[j] = avalues[j + 1];
	                 avalues[j + 1] = tmp;
	             }
	         }
	     }
	 }
	 else {
		 for (int i = 0; i < n; i++) {
	         for (int j = 0; j < n - 1 - i; j++) {
	             if (avalues[j] < avalues[j + 1]) {
	                 tmp = avalues[j];
	                 avalues[j] = avalues[j + 1];
	                 avalues[j + 1] = tmp;
	             }
	         }
		 }
     }  
	 return avalues;
 }
 
 static void print(int[] arr) {
     System.out.println("----------------Display Begin--------------");
     for (int i = 0; i < arr.length; i++) {
         System.out.println("PerCapita income of City " + i + " is " + arr[i]);
     }
     System.out.println("----------------Display End--------------");
 }
 
 public static int diagonal_sum(int[][] arr){
     int sum = 0;
     for(int i = 0; i<arr.length;i++){
         for(int j = 0; j<arr[0].length;j++){
             if((i == j) || (i+j == arr.length-1)) {
                 sum += arr[i][j];
              }
         }
     }
     return sum;
 }
}


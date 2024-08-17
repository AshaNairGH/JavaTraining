package Assignments;

public class Day2 {
	public static void main(String[] args) {
		
		double pp[] = new double[6];
		pp[0] =110.5;
		pp[1] =90;
		pp[2] =99.5;
		pp[3] =100;
		pp[4] =105.5;
		pp[5] =95;
		
		System.out.println("--------Prime number------");
		prime(11);
		
		System.out.println("-------Factorial of a number--------");
		factorial(5);
		
		System.out.println("-----Reverse of a number-------");
		reversenum(6814);
		
		System.out.println("-----Average Petrol Price of Cities-------");
		double avg = petrolprice(pp);
		System.out.println("Average is " +avg);	
	
	}	
	
static void prime(int n) {
	boolean is_prime = true;
	int a = n/2;
	for(int i = 2;i<=a-1;i++) {
		if(n%i==0) {
			is_prime = false;
}
	}
	if(is_prime) {
			System.out.println(n+ " is prime");}	
			else {
			System.out.println(n+ " is not prime");	
		}
	}

static void factorial(int n){
	int f = 1;
	for(int i=1;i<=n;i++) {
	 f = f*i;
	}
	System.out.println("Factorial of " +n+ " is " +f);	
}

static void reversenum(int n){
	int r;
	int rev = 0;
	while(n!=0) {
		r=n%10;
		rev=(rev*10)+r;
		n=n/10;		
	}
	System.out.println("Reverse is " +rev);	
}

static double petrolprice(double[] prices) {
	double avg=0.0; double sum=0.0;
	int len = prices.length;
	for(int i = 0;i<len;i++) {
		sum = sum + prices[i];
		avg = sum/len;
	}
	return avg;
}
}


	
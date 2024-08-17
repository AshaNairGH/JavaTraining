package Assignments;

public class Day1 {
public static void main(String[] args) {
	
	System.out.println("Fibonacci series < 1000");
	fibonacci();
	
	System.out.println("Multiplication tables till 10");
	table();
}

static void fibonacci() {
	int a = 0;int b = 1;int c;
	for(int i=1; i<=1000; i++) {
		System.out.println(a);
		c=a+b;
		a=b;
		b=c;	
	}
}

static void table() {
	for(int i = 1;i<=10;i++){
		for(int j = 1;j<=10;j++) {
			System.out.println(j+ "*" +i+ "=" +j*i);
		}
}
}

}
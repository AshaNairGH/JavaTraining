package Assignments;

class Product{
	//data members
	int id;
	String name;
	float price;
	
	//constructor
	Product(int pid, String pname, float pprice){
		id=pid;
		name=pname;		
		price = pprice;
	}
	
	//member method
	void display() {
		System.out.println("ProductID="+id+";"+" ItemName=" +name+ ";"+ " ItemPrice = "+price);
	}
}

class ShoppingCart{
	
//data members
	//Array of products
	Product aprod[];
	int cindex;
	float sum;
	
//Constructor
	ShoppingCart(){
		aprod = new Product[5];
		cindex = 0;
		sum = (float) 0.0;
	}
	
//Member methods
	//add product to cart
	Product addProduct(Product prod) {
		aprod[cindex]=prod;
		cindex++;
		System.out.println("Added product with id: "+prod.id);
		return prod;
	}
	//List products in the cart
	void listProducts() {
		for(int i = 0;i<cindex;i++) {			
			aprod[i].display();			
		}
	}
		
		//checkout
		//calculate the total amount and print
		float checkOut() {
			for(int i = 0;i<cindex;i++) {	
				 sum += aprod[i].price;
			}
			System.out.println("Total price of items in the cart: "+sum);
			return sum;		    
		}
		
		//empty shopping cart
		void emptyCart() {
		aprod = new Product[5];
		cindex = 0;
		System.out.println("Deleted all products from shopping cart");
		}
	
}
	
public class Day4 {
	public static void main(String[] args) {
		ShoppingCart scart = new ShoppingCart();
		
		Product p1 = new Product(100, "Mobile", (float)25000.00);
		scart.addProduct(p1);
		
		Product p2 = new Product(200, "Clothing", (float)789.50);
		scart.addProduct(p2);
		
		scart.listProducts();
					
		scart.checkOut();
		
		scart.emptyCart();
	}
}

package java12;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car(00000012, '2', "BMW", true );
		
		Car carCopy = new Car(c);
		
		carCopy.printBrand();
		
	}

}

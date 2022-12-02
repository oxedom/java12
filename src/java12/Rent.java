package java12;

public class Rent {
	
	private String _name; 
	private Car _car;
	private Date _pickDate;
	private Date _returnDate;
	
	//price per day per model car
	final int PRICE_A = 100;
	final int PRICE_B = 150;
	final int PRICE_C = 180;
	final int PRICE_D = 240;
	
	public Rent (String name, Car car, Date pick, Date rent) 
	{
		this._name = name;
		this._car = car;
		//Checks that that the dates are at least 1 day difference
		if(pick.equals(rent) || pick.difference(rent) < 0) { 
			rent.tomorrow();
			this._returnDate = rent;
		}
	
		
	}
	
	//need to sort out;
	public Rent (Rent other) 

	{

		this._name = other._name;
		this._car = other._car;
		this._pickDate = other._pickDate;
		this._returnDate = other._returnDate;
		
	}

	
	
	
}

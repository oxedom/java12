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
		if(pick.difference(rent) < 0) { 

			System.out.println(rent.difference(pick));
			this._pickDate = pick;
			this._returnDate = rent;		
		}
		else {
			this._pickDate = pick;
			Date returnDateFixed = new Date(pick.getDay(), pick.getMonth(), pick.getYear());
			this._returnDate = returnDateFixed;

			System.out.println(rent.difference(pick));
			
			System.out.println(this._pickDate.toString() );
			System.out.println(this._returnDate.toString() );

		}
	
		
	}
	
	//need to sort out;
	public Rent (Rent other) 
	{
		this._name = other.getName();
		this._car = other.getCar();
		this._pickDate = other.getPickDate();
		this._returnDate = other.getReturnDate();
	}

	void setName(String namePara) { this._name = namePara;}
	void setCar(Car carPara) { this._car = carPara;}
	
	void setPickDate(Date datePara) {
		if(datePara.before(_returnDate)) { 	this._pickDate = datePara;} 
	
	}
	void setReturnDate(Date datePara) {
		if(datePara.after(datePara)) { this._returnDate = datePara;}
	}
	
	String getName() {
		return this._name;
	}
	Car getCar () {
		return this._car;
	}
	Date getPickDate() {
//		return new Date(1,1,2001);
		return this._pickDate;
	}
	Date getReturnDate() 
	{ return this._returnDate;	}
	
	public boolean equals(Rent other) {
		boolean answer = false;

		if(this._car.equals(other) && this._name == other.getName() && this._pickDate.equals(other.getPickDate()) && this._returnDate.equals(other.getReturnDate())) 
		{
			answer = true;
		}
		return answer;
	}
	
	public int howManyDays() {
		int days = this._pickDate.difference(_returnDate);
		return days;
	
	}
	
	public double getPrice() {
		
		double finalPrice;
		int pricePerDay = 1;
		int amountOfDays = this.howManyDays();
		int amountOfWeeks = amountOfDays/7;
		int amountOfFullPriceDays = amountOfDays%7;
		
		switch (this._car.getType()) 
		{
		case 'A':
			pricePerDay = PRICE_A;
			break;
		case 'B':
			pricePerDay = PRICE_B;
			break;
		case 'C':
			pricePerDay = PRICE_C;
			break;
			
		case 'D':
			pricePerDay = PRICE_D;
			break;
		}
		
		if(amountOfWeeks >= 1) { 
			finalPrice = (amountOfWeeks * 7 * pricePerDay) * 0.9;
			finalPrice =+ (amountOfFullPriceDays * pricePerDay);
		} else { 
			finalPrice = amountOfDays * pricePerDay; 
		}
		
		
		return finalPrice;
	}

	
	
}

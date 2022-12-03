package java12;
/**
 * Maman 12
 * This class repersents a RENT object
 * @author Sam 
 * @version 2023a
 */


public class Rent {
	
	private String _name; 
	private Car _car;
	private Date _pickDate;
	private Date _returnDate;
	
	//price per day per model car finals
	final int PRICE_A = 100;
	final int PRICE_B = 150;
	final int PRICE_C = 180;
	final int PRICE_D = 240;
	 
	//constructer
	 
	/**
	 * Constructor main
	 * @param name
	 * @param car
	 * @param pick
	 * @param rent
	 */
	public Rent (String name, Car car, Date pick, Date rent) 
	{
		this._name = name;
		this._car = car;
		//Checks that that the dates are at least 1 day difference
		this._pickDate = pick;
		this._returnDate = rent;
		 
		if(pick.difference(rent) > 0) { 

			this._pickDate = pick;
			this._returnDate = rent;		
		}
		else {
			this._pickDate = pick;
			Date returnDateFixed = new Date(pick.getDay(), pick.getMonth(), pick.getYear());
			returnDateFixed = returnDateFixed.tomorrow();
			this._returnDate = returnDateFixed;



		}
	
		
	}
	
	//copy constructer;
	
	/**
	 * Copy Constructer
	 * @param other
	 */
	public Rent (Rent other) 
	{
		this._name = other._name;
		this._car = other._car;
		this._pickDate = other._pickDate;
		this._returnDate = other._returnDate;
	}

	//Setters
	/**
	 * Setters
	 * @param namePara
	 */
	void setName(String namePara) { this._name = namePara;}
	void setCar(Car carPara) { this._car = carPara;}
	
	void setPickDate(Date datePara) {
		if(datePara.before(_returnDate)) { 	this._pickDate = datePara;} 
	
	}
	void setReturnDate(Date datePara) {
		if(datePara.after(datePara)) { this._returnDate = datePara;}
	}
	
	//Getters
	/**
	 * Getters
	 * @return
	 */
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
	
	//Checks if rent is equal
	
	
	
	/**
	 * @param other
	 * Checks if the Rent is Equal by comparing all props
	 * @return
	 */
	public boolean equals(Rent other) {
		boolean answer = false;

		if(this._car.equals(other.getCar()) && this._name == other.getName() && this._pickDate.equals(other.getPickDate()) && this._returnDate.equals(other.getReturnDate())) 
		{
			answer = true;
		}
		return answer;
	}
	//How many days using difference method on date;
	/**
	 * Returns a int of how many days beween 2 dates
	 * @return
	 */
	public int howManyDays() {
		
		
		int days = this._pickDate.difference(this._returnDate);

		return days;
	
	} 
	
	//Gets price of renting a car
	
	/**
	 * returns price of renting a car acording to days and type of car
	 * @return
	 */
	public double getPrice() {
		
		double finalPrice = 0;

		int pricePerDay = 0;
		int amountOfDays = howManyDays();
		double amountOfWeeks = amountOfDays/7;
		int amountOfFullPriceDays = amountOfDays%7;
		
		if(amountOfWeeks < 0) { 
			amountOfWeeks = 0;
		}
		
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
			double discount = pricePerDay * 0.9;
			finalPrice =  amountOfWeeks * 7 * discount;
			finalPrice = finalPrice + (amountOfFullPriceDays * pricePerDay);
		}
		else { 
			finalPrice = (pricePerDay * amountOfDays);
		}

		
		
		return finalPrice;
	}

	
	//Upgrades car
	
	
	/**
	 * Upgrade car type
	 * @param newCar
	 * 
	 * @return
	 */
	public int upgrade (Car newCar) {
		int price_diff = 0;
		if(newCar.better(this._car)) 
		{
			char typeOfOld =  this._car.getType();
			char typeOfNew = newCar.getType();
			int priceOfOld = 0;
			int priceOfNew = 0;
			
			if(typeOfOld == 'A' ) {priceOfOld = PRICE_A; }
			if(typeOfOld == 'B' ) {priceOfOld = PRICE_B;}
			if(typeOfOld == 'D' ) {priceOfOld = PRICE_C;}
			if(typeOfOld == 'C' ) {priceOfOld = PRICE_D;}
			
			if(typeOfNew == 'A' ) {priceOfNew = PRICE_A; }
			if(typeOfNew == 'B' ) {priceOfNew = PRICE_B;}
			if(typeOfNew == 'D' ) {priceOfNew = PRICE_C;}
			if(typeOfNew == 'C' ) {priceOfNew = PRICE_D;}
			
			price_diff = typeOfNew - priceOfOld;
			this._car = newCar;
		}
		
		return price_diff;
	}
	
	//TO string
	/* Over rides to string and prints out a string of rent
	 @Overrides
	 */
	public String toString() {

		return "Name:"+this._name+ " From:"+this._pickDate.toString()+" To:"+this._returnDate.toString()+" Type:"+this._car.getType()+" Days:"+howManyDays()+" Price:"+getPrice();
	} 
	/**
	 * Failed to implement overlap method
	 * @param Rent other
	 * 
	 * @return
	 */
	public Rent overlap (Rent other) {
		
		return other;
		
		
	}
}

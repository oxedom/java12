package java12;
/**
 * Maman 12
 * This class repersents a Date object
 * @author Sam
 * @version 2023a
 */



public class Date { 
	
	private int _day;
	private int _month;
	private int _year;
	
	final int MIN_DAY = 1;
	final int MIN_MONTH = 1;
	final int MIN_YEAR = 1000;
	
	final int MAX_DAY = 31;
	final int MAX_MONTH = 12;
	final int MAX_YEAR = 9999;
	

	final int DEFAULT_DAY = 1;
	final int DEFAULT_MONTH = 1;
	final int DEFAULT_YEAR = 2000;

	

	/**
	 * Valid helper methods
	 *
	 */
	
	boolean validDay(int dayPara) {
		boolean answer;
		answer = false;
		//Checks if day is in range of min and max
		if((MIN_DAY <= dayPara) && (dayPara <= MAX_DAY) ) {
			answer = true;
		}
		
		return answer;
	}
	
	boolean validMonth (int monthPara) {
		boolean answer;
		answer = false;
		//Checks if month is in range of min and max
		if((MIN_MONTH <= monthPara) && (monthPara <= MAX_MONTH) ) {
			answer = true;
		}
		
		return answer;
	}
	
	boolean validYear(int yearPara) {
		boolean answer;
		answer = false;
		//Checks if year is in range of min and max
		if((MIN_YEAR <= yearPara) && (yearPara <= MAX_YEAR) ) { 
			answer = true;
		}

		return answer;
	}
	
	/**
	 * Leap year method checks if leap year or not 
	 * @param year
	 *
	 */
	boolean leapYear (int year) {
		boolean answer;
		answer = false;
		//if the year is divided by 4
		if((year%4) == 0 ) {
			//if the year is century
			if(year % 100 == 0) {
				//If year divided by 400 then it is a leap year
				if (year % 400 == 0) {
					answer = true;
				}
				else 
				{
					answer = false;
				}
			}
			else { 
				answer = true;
				}
		}
	
		return answer;
	}
	

    
	

	//Checks if day is 31 days if it is legal by it's month
	
	/**
	 * //Checks if day is 31 days if it is legal by it's month
	 * @param monthPara
	 *
	 */
	boolean legalLongDay(int monthPara) {
		
		boolean answer = false;
		if(monthPara == 1 || monthPara == 3 || monthPara == 5 || monthPara == 7 || monthPara == 8 || monthPara == 10 || monthPara == 12 )
		{ answer = true;}
		
		
		return answer;
	}

	
	//COnstructer
	
	/**Constructer main
	 * @param dayPara
	 * @param monthPara
	 * @param yearPara
	 */
	public Date (int dayPara, int monthPara, int yearPara) {

		//Set default boolean parameter, if in anytime in this function it becomes true it will
		//set the parameters to the default parameters at the end of the constructor lifecyle 
		boolean setDefault = false;
		
		//If the day is bigger than 29 in Feb so then set default to true
		if(monthPara == 2 && dayPara > 29 )
		{
			setDefault = true;
		} 
		//If day is 31 days checks if legal by month
		if(dayPara == 31) {
			if(!legalLongDay(monthPara)) {
				setDefault = true;
			}
		}
		
//		if the day is the 29th of feb so check if it's a leapyear, and if it is then set the day to that day else set the date to false
		if(monthPara == 2 && dayPara == 29) {
		//leapyear checker
		if(leapYear(yearPara)) {this._day = dayPara; } else {	setDefault = true;}
		}
		
		//Checks if valid by using helper functions
		if(validDay(dayPara)) {
			this._day = dayPara;
		}
		else { setDefault = true; }
		
		if(validMonth(monthPara)){
			this._month = monthPara;
		}
		else {setDefault = true; }
		
		if(validYear(yearPara)) {
			this._year = yearPara;
		}
		else { setDefault = true;}
		
		
		if(setDefault) {
			this._day = DEFAULT_DAY;
			this._month = DEFAULT_MONTH;
			this._year = DEFAULT_YEAR;
		}
		
	}
	//Copy construcer
	
	/**
	 * Copy constructer
	 * @param other
	 */
	public Date (Date other) 
	{
		this._day = other._day;
		this._month = other._month;
		this._year = other._year;
		
	}
	
	
	//setters
	void setDay (int dayToSet) {
		
		if(dayToSet == 31) { 
			if(legalLongDay(this._month)) 
			{
				this._day = dayToSet;
			} }
		
		
		if(this._month == 2) {
			if(validDay(dayToSet)) 
			{
					if(leapYear(this._year)) {this._day = dayToSet; } 
				}
		} 
		if(validDay(dayToSet)) {
			this._day = dayToSet;
		}
		

		

	}
	
	void setMonth (int monthToSet) {

		
		if(validMonth(monthToSet)){
			
			if(this._day == 31) { 
				if(legalLongDay(monthToSet)) {
					this._month = monthToSet;
				}
			}
			else {  
				
				this._month = monthToSet;
			}
			
			
			
		}
		
	}
	void setYear (int yearToSet) {
		if(validYear(yearToSet)) {
			this._year = yearToSet;
		}
	}
	
	//Getters
	int getDay() { return this._day;}
	int getMonth() {return this._month;}
	int getYear( ) {return this._year;}
	
	//Equal function that compares days;
	
	public boolean equals(Date otherDate) 
	{
		boolean answer;
		answer = false;
		if((otherDate._day == this._day) && (otherDate._month == this._month) && (otherDate._year == this._year))  
		{
			answer = true;
		}
		return answer;
	}
	
	//Before that checks if date is before or not
	
	/**
	 * Retruns if a date is before another date
	 * @param otherDate
	 * @return
	 */
	public boolean before(Date otherDate) {
		

		boolean answer;
		answer = true;
		
		if(otherDate._year < this._year) { answer = false;} 
		if(otherDate._year == this._year && otherDate._year < this._month) { answer = false;}
		if(otherDate._year == this._year && otherDate._year == this._month && otherDate._day < this._day) { answer = false;}

		return answer;
	}
	
	//Before boolean reveresed with !
	
	/**
	 * @param otherDate
	 * returns true or false if date is after a certain date
	 * @return
	 */
	public boolean after(Date otherDate) {
		return !before(otherDate);
	}
	
	// computes the day number since the beginning of the Christian counting of years
	
	
	 public int calculateDate ( int day, int month, int year)
	{
	 if (month < 3) {
	 year--;
	 month = month + 12;
	 }
	 return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62); }
	 
	
	
	//How many days betwen days
	 
	/**
	 * @param laterDate
	 * Difference between dates
	 * @return
	 */
	public int difference (Date laterDate) {
		  

	
	int soonerDate_amount = calculateDate(this._day, this._month, this._year);


	int laterDate_amount = calculateDate(laterDate.getDay(), laterDate.getMonth(), laterDate.getYear());
	


	
	int bigger = Math.max(soonerDate_amount, laterDate_amount);
	int smaller = Math.min(soonerDate_amount, laterDate_amount);
	int answer = bigger - smaller;
	

	return (bigger - smaller );

	
	}
	
	//Overloading to string method
	
	/**
	 * Override to string method to print out string
	 *
	 */
	public String toString() {
		
		String displayDay = String.valueOf(this._day);
		String displayMonth = String.valueOf(this._month);
		//NEEDS 0 BEFORE
		if(this._day < 10) { displayDay = "0"+this._day;}
		if(this._month < 10) {displayMonth = "0"+this._month;}
		
	
		return ""+displayDay+"/"+displayMonth+"/"+this._year;
	}
	
	//Sets day to next day.
	
	/**
	 * Sets day forward by one
	 * @return
	 */
	public Date tomorrow() {
		Date tomorrow = new Date(this._day, this._month, this._month);
		
		int tommrowDay = this._day+1;
		int tommrowMonth = this._month;
		int tommrowYear = this._year;
		
		
		
		if(tommrowMonth == 2 && tommrowDay == 29) {
			 if(leapYear(tommrowYear)) {
					
				}
			 else {tommrowDay = 1;
			 tommrowMonth = 3;
			 }
		}
		
		
		if(tommrowDay > 31 && tommrowMonth != 2) { 
			tommrowDay = 1;
			tommrowMonth++;
		}
		
		
		
		if(tommrowMonth > 12) {
		
		tommrowMonth = 1;
		tommrowYear++;
		}
		
		
		
		tomorrow.setDay(tommrowDay);
		tomorrow.setMonth(tommrowMonth);
		tomorrow.setYear(tommrowYear);
		
		return tomorrow;
		
	}
}

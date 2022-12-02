package java12;

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

	
	boolean validDay(int dayPara) {
		boolean answer;
		answer = false;
		//Checks if day is in range of min and max
		if((MIN_DAY <= dayPara) || (dayPara <= MAX_DAY) ) {
			answer = true;
		}
		
		return answer;
	}
	
	boolean validMonth (int monthPara) {
		boolean answer;
		answer = false;
		//Checks if month is in range of min and max
		if((MIN_MONTH <= monthPara) || (monthPara <= MAX_MONTH) ) {
			answer = true;
		}
		
		return answer;
	}
	
	boolean validYear(int yearPara) {
		boolean answer;
		answer = false;
		//Checks if year is in range of min and max
		if((MIN_YEAR <= yearPara) || (yearPara <= MAX_YEAR) ) { 
			answer = true;
		}

		return answer;
	}
	
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
			}
		}
		return answer;
	}



	public Date (int dayPara, int monthPara, int yearPara) {

		//Set default boolean parameter, if in anytime in this function it becomes true it will
		//set the parameters to the default parameters at the end of the constructor lifecyle 
		boolean setDefault = false;
		
		//If the day is bigger than 29 in Feb so then set default to true
		if(monthPara == 2 && dayPara > 29 )
		{
			setDefault = true;
		} 
		
//		if the day is the 29th of feb so check if it's a leapyear, and if it is then set the day to that day else set the date to false
		if(monthPara == 2 && dayPara == 29) {
			
		if(leapYear(yearPara)) {this._day = dayPara; } else {	setDefault = true;}
		}
		
		//Checks if valid
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
	
	public Date (Date other) 
	{
		this._day = other._day;
		this._month = other._month;
		this._year = other._year;
		
	}
	
	void setDay (int dayToSet) {
		
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
			this._month = monthToSet;
		}
		
	}
	void setYear (int yearToSet) {
		if(validYear(yearToSet)) {
			this._year = yearToSet;
		}
	}
	
	int getDay() { return this._day;}
	int getMonth() {return this._month;}
	int getYear( ) {return this._year;}
	
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
	
	public boolean before(Date otherDate) {
		boolean answer;
		answer = false;
		
		
		return answer;
	}
	
	
	public boolean after(Date otherDate) {
		return !otherDate.before(this);
	}
	
	
	public int difference (Date otherDate) {
		return 99999;
	}
	
	public String toString() {
		return ""+this._day+"/"+this._month+"/"+this._year;
	}
	
	public Date tomorrow() {
		Date tomorrow = new Date(this._day, this._month, this._month);
		;
		tomorrow.setDay(this._day+1);
		tomorrow.setMonth(this._month+1);
		tomorrow.setYear(this._year+1);
		
		return tomorrow;
		
	}
}

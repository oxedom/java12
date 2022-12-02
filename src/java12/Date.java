package java12;

public class Date {
	
	private int _day;
	private int _month;
	private int _year;
	
	final int MAX_DAY = 31;
	final int MAX_MONTH = 12;
	final int MAX_YEAR = 9999;
	
	final int MIN_DAY = 1;
	final int MIN_MONTH = 1;
	final int MIN_YEAR = 1000;
	
	boolean validDay(int dayPara) {
		boolean answer;
		answer = false;
		
		return answer;
	}
	
	boolean validMonth (int monthPara) {
		boolean answer;
		answer = false;
		if((MIN_MONTH <= monthPara) || (monthPara <= MAX_MONTH) ) {
			answer = true;
		}
		
		return answer;
	}
	
	boolean validYear(int yearPara) {
		boolean answer;
		answer = false;
		if((MIN_YEAR <= yearPara) || (yearPara <= MAX_YEAR) ) { 
			answer = true;
		}

		return answer;
	}
	
	boolean leapYear (int year) {
		boolean answer;
		answer = false;
		if((year%4) == 0 ) {
			answer = true;
		}
		
		return answer;
	}

	//CHECK IF LEGAL MAKE LEGAL FUNCTIONS;
	//CHECK FOR YEARS WHERE 29TH OF FEB IS A THING
	//SET DEFUALT OBJECT 
	public Date (int dayPara, int monthPara, int yearPara) {
		
	}
	
	public Date (Date other) 
	{
		this._day = other._day;
		this._month = other._month;
		this._year = other._year;
		
	}
	
	void setDay (int dayToSet) {}
	void setMonth (int monthToSet) {}
	void setYear (int yearToSet) {}
	
	public boolean equals(Date otherDate) 
	{
		if((otherDate._day == this._day && otherDate._month === this._month && ))
	}

}

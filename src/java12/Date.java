package java12;

public class Date {
	
	private int _day;
	private int _month;
	private int _year;
	
	final int MAX_DAY = 31;
	final int MAX_MONTH = 12;
	final int MAX_YEAR = 9999;
	
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

}

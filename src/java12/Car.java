package java12;

public class Car {

    // fields
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    //Sam notes; Make sure that a user can't enter a int under 0 or overthose max numbers;
    //type of car rank must be A B C D If the type isn't one of those set default to A
    //MAKE SURE THAT BRAND ISNT NULL WHEN OBJECT IS CREATED 
    final char DEFAULT_TYPE = 'A';
    final int MAX_ID = 9999999;
    final int MIN_ID = 00000001;
    
    final char VALID_TYPE_1= 'A';
    final char VALID_TYPE_2= 'B';
    final char VALID_TYPE_3= 'C';
    final char VALID_TYPE_4= 'D';

    // Main Constructor 
    boolean validType(char typePara) {
    	boolean result;
      	if(typePara == VALID_TYPE_1 || typePara == VALID_TYPE_2 ||  typePara == VALID_TYPE_3 ||  typePara == VALID_TYPE_4) 
      	{
      		result = true;}
      	
    	 else { result = false; }
    	return result;
    }
    
    boolean validID(int idPara) 
    {
    	boolean result;
    	if(MIN_ID > idPara || idPara > MAX_ID) {
    		result = false;}
		    else {result = true; }
    	
    	return result;
    }
    
    
    Car(int idPara, char typePara, String brandPara, boolean isManualPara) {
    	
    	if(validType(typePara)) {
    		this._type = typePara;
    	}
    	else {
    		_type = DEFAULT_TYPE;
    	}
    	
    	if(validID(idPara)) {
    		this._id = idPara;
    	}
    	else { 
    		this._id = MAX_ID;
    	}

    	
        this._brand = brandPara;
        
        
        this._isManual = isManualPara;
     
    }
    
    //Copy Constructor for Car;
    public Car(Car copyCar) {
    	this._id = copyCar._id;
    	this._type = copyCar._type;
    	this._brand = copyCar._brand;
    	this._isManual = copyCar._isManual;
    	
    }
    
    // methods
    
    
    
    int getId() {
    	return _id;
    }
    char getType() {
    	return _type;
    }
    String getBrand() {
    	return _brand;
    }
    boolean isManual() {
    	return _isManual; 
    }
    
    void setId(int idPara) 
    {
    	if(validID(idPara)) {
    		this._id = idPara;
    	} 
    }
    
    void setType(char typePara) {
    	if(validType(typePara)) {
    		this._type = typePara;
    	}
    }
    
    void setBrand(String brandPara ) {
    	this._brand = brandPara;
    }
    
    void setIsManual(boolean manualPara) {
    	this._isManual = manualPara;
    }
    
    public String toString() {
    	String result;
    	String manualStatus;
    	
    	if(this._isManual) {
    		manualStatus = "manual";
    	}
    	else {
    		manualStatus = "auto";
    	}
    	
    	result =  "id:"+this._id + " " + "type:"+this._type+ " " + "brand:" + this._brand+ " " + "gear:"+manualStatus;
    	
    	return result; 
    }
    

    	public boolean equals (Car otherCar) {
    		boolean answer;
    		if(otherCar._brand == _brand && otherCar._isManual == _isManual && otherCar._type == _type) 
    		{
    			answer = true;
    		}
    		else 
    		{
    			answer = false;
    		}
    		
    		return answer;
    
    	}
}
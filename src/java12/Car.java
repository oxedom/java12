package java12;

/**
 * Maman 12
 * This class repersents a Car object
 * @author Sam
 * @version 2023a
 */



/**
 * @author sam
 *
 */
public class Car {

    // fields
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    //Finals;
    final char DEFAULT_TYPE = 'A';
    final int MAX_ID = 9999999;
    final int MIN_ID = 10000000;
    
    final char VALID_TYPE_1= 'A';
    final char VALID_TYPE_2= 'B';
    final char VALID_TYPE_3= 'C';
    final char VALID_TYPE_4= 'D';
 
    //check valid type
    
    /**
     * @param typePara
     * CHecks if valid
     * @return
     */
    boolean validType(char typePara) {
    	boolean result;
      	if(typePara == VALID_TYPE_1 || typePara == VALID_TYPE_2 ||  typePara == VALID_TYPE_3 ||  typePara == VALID_TYPE_4) 
      	{
      		result = true;}
      	
    	 else { result = false; }
    	return result;
    }
    
    /**
     * @param typePara
     * CHecks if valid
     * @return
     */
    boolean validID(int idPara) 
    {
    	boolean result;
    	if(MIN_ID > idPara || idPara > MAX_ID) {
    		result = false;}
		    else {result = true; }
    	
    	return result;
    }
    
    //Car Constructor;
    
    /**
     * Main Constructor 
     * @param idPara
     * @param typePara
     * @param brandPara
     * @param isManualPara
     */
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
    
    
    //Getters
    /**
     * Getters
     * @return
     */
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
    
    //SETTERS
    
    /**
     * Setters
     * @param idPara
     */
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
    
    //Print to string
    
    /**
     *@Overrides toString methods
     *return a string object of the car
     */
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
    
    
    //Checks if two cars are the same or not;
    /**
     *equals checks if two cars are the same
     *Returns true or false
     */
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
    	
    	//Check if a car is better
    	/** 
    	 * Returns if a car type is better
    	 * @param otherCar
    	 * @return
    	 */
    	public boolean better(Car otherCar) {
    		boolean answer = false;

    		
  
//    		If the cars are the same type return TRUE
    		if(otherCar._type == this._type) { answer = true;}
    		
    		if((otherCar._type == VALID_TYPE_2) && (this._type == VALID_TYPE_1) ) {answer = true;}
    		if((otherCar._type == VALID_TYPE_3) && (this._type == VALID_TYPE_1) ) {answer = true;}		
    		if((otherCar._type == VALID_TYPE_4) && (this._type == VALID_TYPE_1) ) {answer = true;}	
    

    		if((otherCar._type == VALID_TYPE_3) && (this._type == VALID_TYPE_2) ) {answer = true;}		
    		if((otherCar._type == VALID_TYPE_4) && (this._type == VALID_TYPE_2) ) {answer = true;}
    		
	
    		if((otherCar._type == VALID_TYPE_4) && (this._type == VALID_TYPE_3) ) {answer = true;}
    				
    		return answer;
    	}
    	//Check if car is worse by ! the better method 
    	
    	/**
    	 * @param otherCar
    	 * returns true or false if car is worse or not
    	 * @return
    	 */
    	public boolean worse(Car otherCar) {
    		return !better(otherCar);
    	}
}
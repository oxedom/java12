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
    
    final char VALID_TYPE_1 = 'A';
    final char VALID_TYPE_2= 'B';
    final char VALID_TYPE_3= 'C';
    final char VALID_TYPE_4= 'D';

    // Main Constructor 
    boolean validType(char typePara) {
    	boolean result;
      	if(typePara != VALID_TYPE_1 || typePara != VALID_TYPE_2 || typePara != VALID_TYPE_3 || typePara != VALID_TYPE_4) 
      	{
      		result = false;}
    	 else { result = true; }
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
    		_type = typePara;
    	}
    	else {
    		_type = DEFAULT_TYPE;
    	}
    	
    	if(validID(idPara)) {
    		_id = idPara;
    	}
    	else { 
    		_id = MAX_ID;
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
    
    
    
    int getID() {
    	return _id;
    }
    char getType() {
    	return _type;
    }
    String getBrand() {
    	return _brand;
    }
    boolean getIsManual() {
    	return _isManual; 
    }
    
    
    //THINGS TO MAKE
    //getId, getType, getBrand, isManual
    //MAKE SURE THEY ARE FOOL PROOF NO BUGS TO BYPASS THEM;
    //Setters, setId setType setBrand setIsManual;
//    public String toString()
    //toString SHOULD RETURNA SOMETHING LIKE
//    id:1234567 type:A brand:Mazda gear:manual
//    id:8877665 type:D brand:Toyota gear:auto
//    id:9999999 type:B brand:Renault gear:manual
    	
    //OVERRIDE EQUALS METHOD TO CHECK IF TWO CARS HAVE THE SAME PROPS;
    
    void printBrand() {
        System.out.println(_brand);
    }

//	public String get_brand() {
//		return _brand;
//	}
//
//	public void set_brand(String _brand) {
//		this._brand = _brand;
//	}
    
    // ...
}
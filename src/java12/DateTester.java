package java12;

public class DateTester {

    public static void main(String[] args) {
        showIntroduction();
        test();

    }

    private static void showIntroduction() {
        System.out.println("This is a tester for the Date class in Maman 12");
        System.out.println("You are more than welcome to change it and redistribute your modifications");
        System.out.println("This tester is provided AS IS");
        System.out.println("It should not be used instead of the testers provided by the university");
        System.out.println("You must use the testers provided by the university");
        System.out.println("I don't take any responsibility for the grade you receive, whether you use this tester or not");
        System.out.println();
    }

    private static void logTest(String test) {
        System.out.println("Test: " + test);
    }
    private static void logError(String error) {
        System.out.println("Error occurred. Here is the error: " + error + "\n");
    }

    private static void logSuccess() {
        System.out.println("Test passed!\n");
    }

    private static void logDateValues(Date date) {
        System.out.println("The values returned by the getters are: \n" +
                "day: " + date.getDay() +
                "\nmonth:" + date.getMonth() +
                "\nyear: " + date.getYear() + "\n");
    }

    private static void testMainConstructor() {
        Date date = new Date(4, 1, 5);

        logTest("Check if the constructor notices the year is less than 1000 and changes the date accordingly");
        if (date.getDay() == 1 && date.getMonth() == 1 && date.getYear() == 2000) {
            logSuccess();
        }
        else {
            logError("Didn't get the expected date 01/01/2000, probably a problem with constructor, date validation or getters");
            logDateValues(date);
        }

        logTest("Check if the constructor notices the month is february, the day is 29 and the year is not leap and changes the date accordingly");
        date = new Date(29, 2, 2014);
        if (date.getDay() == 1 && date.getMonth() == 1 && date.getYear() == 2000) {
            logSuccess();
        }
        else {
            logError("Didn't get the expected date 01/01/2000, probably a problem with constructor, date validation or getters." );
            logDateValues(date);
        }
    }

    private static void testCopyConstructor() {
        Date date = new Date(4, 9, 2000);
        Date copiedDate = new Date(date);

        logTest("Check if the copied date has the same values for day, month and year as date");
        if (copiedDate.getDay() == 4 && copiedDate.getMonth() == 9 && copiedDate.getYear() == 2000) {
            logSuccess();
        }
        else {
            logError("Didn't get the expected date 04/09/2000, probably a problem with copy constructor or getters");
            logDateValues(copiedDate);
        }

    }

    private static void testSetters() {
        Date date = new Date(1, 1, 2001);

        logTest("Check if the setters change the day, month and year as expected, starting with the date 01/01/2001, trying to set it to 05/09/2000");

        date.setDay(5);
        date.setMonth(9);
        date.setYear(2001);

        if (date.getDay() == 5 && date.getMonth() == 9 && date.getYear() == 2001) {
            logSuccess();
        }
        else {
            logError("Didn't get the expected date 05/09/2001");
            logDateValues(date);
        }

        logTest("Check if setters will change the year to a year that is not valid");

        date.setYear(10001);
        if (date.getYear() == 2001) {
            logSuccess();
        }
        else {
            logError("The method changed the date even though it was not expected to do so");
            logDateValues(date);
        }

    }

    private static void testEqualMethod() {
        Date date1 = new Date(4, 10, 1500);
        Date date2 = new Date(4, 10, 1500);

        logTest("Check if equals method works as expected. date1 = 04/10/1500, date2 = 04/10/1500 (they are the same date)");
        if (date1.equals(date2)) {
            logSuccess();
        }
        else {
            logError("Returned false even though the two dates are equal");
        }

        Date date3 = new Date(4, 12, 1500);
        Date date4 = new Date(4, 10, 1500);

        logTest("Check if equals method returns false when the two dates are not the same. date3 = 04/12/1500, date4 = 04/10/1500");
        if (!date3.equals(date4)) {
            logSuccess();
        }
        else {
            logError("Returned true even though the two dates are not the same");
        }
    }

    private static void testBeforeMethod() {
        Date date1 = new Date(10, 7, 2000);
        Date date2 = new Date(8, 9, 2005);

        logTest("Check if date1.before method returns true when date1 = 10/07/2000, date2 = 08/09/2005");
        if (date1.before(date2)) {
            logSuccess();
        }
        else {
            logError("Returned false even though date1 is before date2");
        }
    }

    private static void testAfterMethod() {
        Date date1 = new Date(6, 1, 1927);
        Date date2 = new Date(6, 2, 1927);

        logTest("Check if date1.after method returns false when date1 = 06/01/1927 date2 = 06/02/1927");
        if (!date1.after(date2)) {
            logSuccess();
        }
        else {
            logError("Returned true even though date1 is not after date2");
        }
    }

    private static void testToStringMethod() {
        Date date1 = new Date(4, 10, 1895);

        logTest("Check if toString returns the date in the correct format");
        if (date1.toString().equals("04/10/1895")) {
            logSuccess();
        }
        else {
            logError("returned the date in a wrong format. Here is the string it returned: " + date1.toString());
        }
    }

    private static void testTomorrowMethod() {
        Date date = new Date(28, 2, 2001);
        Date tomorrow = date.tomorrow();

        logTest("Tests if tomorrow method returns 01/03/2001 when date = 28/02/2001");
        if (tomorrow.getDay() == 1 && tomorrow.getMonth() == 3 && date.getYear() == 2001) {
            logSuccess();
        }
        else {
            logError("Didn't return the correct date. This is the date returned by tomorrow");
            logDateValues(tomorrow);
        }
    }
    
    private static void testlegalLongDay( ) {
    Date date = new Date(31,4, 2001);	
    	
    
    logTest("Tests if tomorrow method returns 01/01/2000 when date = 31/04/2001");
    if (date.getDay() == 1 && date.getMonth() == 1 && date.getYear() == 2000) {
        logSuccess();
    }
    else {
        logError("Didn't return the correct date. This is the date returned by tomorrow");
        logDateValues(date);
    }
    }
    
    private static void testlegalLongDay2( ) {
    Date date = new Date(30,6,2001);	
    	
    
    logTest("Tests if tomorrow method returns 30/06/2001 when date = 30/06/2001");
    if (date.getDay() == 30 && date.getMonth() == 6 && date.getYear() == 2001) {
        logSuccess();
    }
    else {
        logError("Didn't return the correct date. This is the date returned by tomorrow");
        logDateValues(date);
    }
    }
    
        
    private static void test() {
        testMainConstructor();
        testCopyConstructor();
        testSetters();
        testEqualMethod();
        testBeforeMethod();
        testAfterMethod();
        testToStringMethod();
        testTomorrowMethod();
        testlegalLongDay();
        testlegalLongDay2();
    }
}
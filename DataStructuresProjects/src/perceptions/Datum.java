package perceptions;

//import jdk.jfr.Category;

/** holds a single datum extracted from a json file */
public class Datum
{
    /** category is the name of the texts that describe where the number is captured from or what the number is about */
    private static String category = null;
    /** numberName is what the number measures in the json file */
    private static String numberName = null;
    /** sets the name of the texts for all Datums, needs only be done once in the program */
    public static void setCategory(String name) {category = name;}
    /** sets the name for the numbers for all Datums, needs only be done once in the program */
    public static void setNumberName(String name) {numberName = name;}

    /** the source of the number from the json file */
    private String source;
    /** the number from the json file */
    private double number;

    /** constructor that creates a Datum, throws an exception if the category and numberName aren't set up in advance */
    Datum(String sourceVal, double numberVal) throws Error
    {
        // make sure that the Datums are set up before you use them
        if(category == null) throw new Error("Category of Datums not set up");
        if(numberName == null) throw new Error("numberName of Datums not set up");
        // assign class variable values
        source = sourceVal;
        number = numberVal;
    } // end Datum constructor

    /** accessor for source */
    public String getSource() { return source;}
    /** accessor for number */
    public double getNumber() { return number;}

    /** for printing a Datum */
    public String toString()
    {
        return category + ": "+getSource()+"\t"+numberName+": "+getNumber();
    } // end toString
} // end Datum

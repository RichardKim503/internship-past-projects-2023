package proj1;

import javax.swing.*;

public class test {
	public static void main(String args[]){
		String fullName;
		String someString;
		String anotherString;
		int posOfPeriod;
		int numChars;
		int posOfSpace;
		
		fullName = JOptionPane.showInputDialog( "Please enter the full name" );
		posOfPeriod = fullName.indexOf( "." );
		System.out.println( "Position of period " + posOfPeriod );
		
		someString = fullName.substring( 1, posOfPeriod + 5 );
		System.out.println( someString );
		
		numChars = fullName.length();
		anotherString = fullName.substring( posOfPeriod + 2, numChars - 2 );
		System.out.println( anotherString );
		
		posOfSpace = anotherString.indexOf( " " );
		System.out.println( "Position of space " + posOfSpace );
		System.out.println( anotherString.substring( posOfSpace - 1,anotherString.indexOf( "re" ) ) );
	}
}

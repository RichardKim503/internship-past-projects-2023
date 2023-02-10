package program4;

import java.io.*;
/**
 * <p>Driver</p>
 * 
 * <p>This class starts the GoFish game.</p>
 * 
 * <p>Author: Richard Kim</p>
 */
import java.util.*;
public class Driver {
	
	public static void main(String[] args) throws IOException {
		
		GoFish game = new GoFish();
		game.playGame();
	}
}

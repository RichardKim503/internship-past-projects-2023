package project2;

import java.util.Random;

/**
 * <p>Simulate a dart that can be thrown at a standard dartboard with 20 wedges and 3 types of rings</p>
 * @author Prof. Merlo
 * @version Fall 2020
 */
public class Dart {
    // Which one of the twenty wedges the dart landed in
    private int wedge;

    // The multiplier to the score based upon in which ring the dart landed
    private int ring;

    /**
     * Default constructor
     */
    public Dart() {
        wedge = 0;
        ring  = 0;
    }

    /**
     * Parameterized constructor - to be used only for testing
     * @param w An integer 1..20 indicating which wedge we will pretend was hit
     * @param r An integer 1..3 indicating which ring we will pretend was hit
     */
    public Dart( int w, int r ) {
        wedge = 0;
        ring = 0;

        if( w > 0 && w <= 20 )
            wedge = w;
        if( r > 0 && r <= 3 )
            ring = r;
    }

    /**
     * Return which of the 20 wedges the dart landed in
     * @return An integer 1..20 indicating which wedge was hit
     */
    public int getWedge() {
        return wedge;
    }

    /**
     * Return which of the 3 rings the dart landed in
     * @return An integer 1..3 indicating which ring was hit
     */
    public int getRing() {
        return ring;
    }

    /**
     * Return the score of the thrown dart
     * @return An integer 1..60 indicating the score of the dart
     */
    public int getScore() {
        return wedge * ring;
    }

    /**
     * Return a reference to a String representation of the dart's data
     */
    public String toString() {
        return wedge + " x " + ring + " = " + getScore();
    }

    /**
     * <p>Throw a dart</p>
     * 
     * <p>Note: We assume here that all three rings are equally likely to be hit,
     * which a dart player will tell you is absurd</p>
     */
    public void throwDart() {
        Random rng = new Random();
        wedge      = rng.nextInt( 20 ) + 1;
        ring       = rng.nextInt( 3 ) + 1;
    }
}
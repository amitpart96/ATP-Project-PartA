package algorithms.search;

import java.util.ArrayList;

/**
 * The Solution class purpose to keep a solution.
 */
public class Solution {
    //attribute s- The solution keep in array List of AStates.
    private ArrayList<AState> s;

    /**
     * Class solution constructor .
     * @param so This is an array list of AStates which represents the solution path.
     */
    public Solution(ArrayList<AState> so) {
        s= so;
    }

    /**
     * This method returns the solution as array list.
     * @return ArrayList This return a solution
     */
    public ArrayList<AState> getSolutionPath(){
        return s;
    }
}

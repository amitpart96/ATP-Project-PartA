package algorithms.search;

import java.util.*;

/**
 * The BreadthFirstSearch class extend ASearchingAlgorithm and its purpose to search using BFS algorithm.
 */
public class BreadthFirstSearch extends ASearchingAlgorithm{

    /**
     * Class BreadthFirstSearch constructor .
     * in the constructor we set the queue to be a ArrayDeque queue.
     */
    public BreadthFirstSearch() {
        queue=new ArrayDeque<>();
    }

    /**
     * This method returns the search name's .
     * @return string This is the name of this search - "Breadth First Search".
     */
    @Override
    public String getName() {
        return "Breadth First Search";
    }
}

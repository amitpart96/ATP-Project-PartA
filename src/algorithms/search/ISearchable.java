package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of ISearchable interface is to make something a searchable.
 */
public interface ISearchable {
    AState getStartState();
    AState getGoalState();
    void clear();
    ArrayList<AState> getAllSuccessors(AState s);
    boolean goalTest(AState s);

}

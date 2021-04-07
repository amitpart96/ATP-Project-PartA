package algorithms.search;

import java.util.HashMap;

/**
 * The AState abstract class.
 * This abstract class is a base for all states.
 * attribute value is the value of this state.
 * attribute isVisited is a sign if this state has been visited.
 * attribute father is a ancestor Of this state.
 * attribute neighbors is a hashmap of neighbors when the AState is the neighbor and the
 * integer is the cost of the way between this state to this neighbor.
 */
public abstract class AState {
    private int value;
    private boolean isVisited;
    private AState father;
    private HashMap<AState, Integer> neighbors;

    /**
     * This is a constructor AState.
     */
    public AState() {
        value=0;
        isVisited=false;
        neighbors=new HashMap<AState, Integer>(0);

    }

    /**
     * This method changes the attribute isVisited to true.
     */
    public void visit(){
        isVisited=true;
    }

    /**
     * This method returns the value Of this state.
     */
    public int getValue() {
        return value;
    }

    /**
     * This method adding neighbor to this state.
     * param i is the cost of way between this state to this neighbor.
     * param n is the neighbor state.
     */
    public void addNeighbors(int i, AState n) {
        this.neighbors.put(n,i);
    }

    /**
     * This method sets the value of this state.
     * param v is the new value.
     */
    public void setValue(int v){
        value=v;
    }

    /**
     * This method sets the father of this state.
     * param father is the new father.
     */
    public void setFather(AState father) {
        this.father = father;
    }

    /**
     * This method returns true/false if this state already has been visited before.
     * @return boolean This returns the value isVisited attribute.
     */
    public boolean isVisited() {
        return isVisited;
    }

    /**
     * This method returns the father state of this state.
     * @return boolean This returns attribute father.
     */
    public AState getFather() {
        return father;
    }

    /**
     * This method returns the way cost between this state to neighbor n.
     * param n is a neighbor state.
     * @return boolean This returns the cost.
     */
    public int getCost(AState n){
        return neighbors.get(n);
    }

    /**
     * This method returns this state map of neighbor's .
     * @return HashMap This returns neighbors.
     */
    public HashMap<AState, Integer> getNeighbors() {
        return neighbors;
    }

    /**
     * This method changes the attribute isVisited to be false.
     */
    public void dontVisit(){
        isVisited=false;
    }

    /**
     * This method check equals between this state to parameter o.
     * @return boolean This returns true/false - if this state and parameter o are similar.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return this == o;

    }

}

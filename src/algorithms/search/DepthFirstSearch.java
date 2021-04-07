package algorithms.search;


import java.util.Stack;
/**
 * The DepthFirstSearch class extend ASearchingAlgorithm and its purpose to search using DFS algorithm.
 */
public class DepthFirstSearch extends ASearchingAlgorithm{

    /**
     * Class DepthFirstSearch constructor .
     */
    public DepthFirstSearch() {
        nodes=0;
    }

    /**
     * Override function
     * This method solve the problem and returns a solution.
     * this solve using the Depth First Search algorithm.
     * @param s This is the searchable problem we wish to solve.
     * @return solution This returns an solution object
     */
    @Override
    public Solution solve(ISearchable s){
        if(s==null){
            //illegal parameter.
            throw new NullPointerException("given Parameter is NULL");
        }
        AState start=s.getStartState();
        AState goal=s.getGoalState();
        Stack <AState> stack = new Stack<>();
        stack.push(start);
        AState temp;
        while(!stack.isEmpty()){
            nodes++;
            temp = stack.pop();
            if(temp.equals(goal)){
                break;
            }
            if(!temp.isVisited() && temp.getValue()==0){
                temp.visit();
                Stack <AState> neig = new Stack<>();
                for(AState n:s.getAllSuccessors(temp)){
                    if(!n.isVisited() && n.getValue()==0){
                        n.setFather(temp);
                        neig.push(n);
                    }
                }
                while(!neig.isEmpty()){
                    AState n = neig.pop();
                    if(!n.isVisited()){
                        stack.push(n);
                    }
                }
            }
        }
        Solution so= new Solution(getRoots(s));
        s.clear();
        return so;
    }

    /**
     * This method is return the name of the search.
     * @return string This is a name of this search - "Depth First Search".
     */
    @Override
    public String getName() {
        return "Depth First Search";
    }
}

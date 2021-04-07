package algorithms.maze3D;


import java.util.Random;

/**
 * this class represents a 3D Maze
 */
public class Maze3D {
    private int [][][] map;
    private Position3D start, goal;
    private final int depth;
    private final int row;
    private final int column;
    private Random rand;

    /**
     * class constructor
     * init an new int 3d matrix
     * @param depth
     * @param row
     * @param column
     */
    public Maze3D(int depth, int row, int column) {
        if( depth<2 || row <2 || column <2){
            throw new IllegalArgumentException("Maze3D size has to be atleast 2X2X2");
        }
        this.depth = depth;
        this.row = row;
        this.column = column;
        map = new int[depth][row][column];
        rand= new Random();
    }

    /**
     * This method will return the start position.
     * @return a start position attribute.
     */
    public Position3D getStartPosition() {
        return start;
    }


    /**
     * This method will return the goal position.
     * @return a goal position attribute.
     */
    public Position3D getGoalPosition() {
        return goal;
    }

    /**
     * This method will return mazes depth.
     * @return a depth attribute.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * This method will return mazes rows.
     * @return a row attribute.
     */
    public int getRow() {
        return row;
    }

    /**
     * This method will return mazes columns.
     * @return a column attribute.
     */
    public int getColumn() {
        return column;
    }

    /**
     * This method will update the maze start position.
     * @param start a position which will be the start point of the maze.
     */
    public void setStartPosition(Position3D start) {

        this.start = start;
    }

    /**
     * This method will return the value of the cell in the matrix.
     * @param dep Cells depth
     * @param row Cells row
     * @param col Cells column.
     * @return int This returns a value of cell.
     */
    public int getCell3DValue(int dep,int row,int col){
        return map[dep][row][col];
    }

    /**
     * This method will update the maze goal position.
     * @param goal a position which will be the end point of the maze.
     */
    public void setGoalPosition(Position3D goal) {

        this.goal = goal;
    }

    /**
     * This method will print the maze
     */
    public void print(){
        int count=-1;
        System.out.println("{");
        for (int[][] maze: map) {
            count++;
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(j==0){
                        System.out.print("{ ");
                        if(i==start.getRowIndex() && count==start.getDepthIndex()){
                            System.out.print("S ");
                            continue;
                        }
                    }

                    if(j==column-1){
                        if(i==goal.getColumnIndex() && count== goal.getDepthIndex()){
                            System.out.println("E }");
                            if( i==row-1 && count != depth-1) {
                                for(int t=0;t<column*2 +2 ;t++) {
                                    System.out.print("-");
                                }
                                System.out.println("-");
                            }

                        }
                        else if(i==row-1){
                            System.out.println(maze[i][j]+" }");
                            if(count != depth-1) {
                                for(int t=0;t<column*2+2;t++) {
                                    System.out.print("-");
                                }
                                System.out.println("-");
                            }
                        }
                        else{
                            System.out.println(maze[i][j]+" }");

                        }
                    }
                    else{
                        System.out.print(maze[i][j]+" ");
                    }
                }
            }
        }
        System.out.println("}");
    }
    /**
     * This method will set all the unused cells as a wall by changing their value to 1
     */
    public void setWalls(){
        for(int t=0;t<depth;t++){
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(map[t][i][j]!= 2){
                        map[t][i][j]=1;
                    }
                }
            }
        }
    }

    /**
     * this method insure that the cell will not close a circle in the maze by changing its value to 0
     * @param d cells depth
     * @param r cells row
     * @param c cells column
     * @return
     */
    public boolean closeCircle(int d,int r,int c){
        if(r==0 && c==column-1){
            if(map[d][r][c-1]==2 && map[d][r+1][c-1]==2 && map[d][r+1][c]==2){
                return false;
            }
        }
        else if(r==row-1 && c==column-1){
            if(map[d][r-1][c]==2 && map[d][r][c-1]==2 && map[d][r-1][c-1]==2){
                return false;
            }
        }
        else if(r==row-1 && c==0){
            if(map[d][r][c+1]==2 && map[d][r-1][c+1]==2 && map[d][r-1][c]==2){
                return false;
            }
        }
        else if(r==0 && c==0){
            if(map[d][r+1][c+1]==2 && map[d][r][c+1]==2 && map[d][r+1][c]==2){
                return false;
            }
        }
        else if(r==0){
            if(map[d][r+1][c+1]==2 && map[d][r][c+1]==2 && map[d][r+1][c]==2 || map[d][r][c-1]==2 && map[d][r+1][c-1]==2 && map[d][r+1][c]==2 ) {
                return false;
            }
        }
        else if(r==row-1) {
            if (map[d][r-1][c] == 2 && map[d][r-1][c + 1] == 2 && map[d][r][c+1] == 2 || map[d][r-1][c] == 2 && map[d][r - 1][c - 1] == 2 && map[d][r][c-1] == 2) {
                return false;
            }
        }
        else if(c==0) {
            if (map[d][r+1][c] == 2 && map[d][r+1][c + 1] == 2 && map[d][r][c+1] == 2 || map[d][r][c +1] == 2 && map[d][r - 1][c + 1] == 2 && map[d][r - 1][c] == 2) {
                return false;
            }
        }
        else if(c==column-1) {
            if (map[d][r-1][c] == 2 && map[d][r][c - 1] == 2 && map[d][r-1][c-1] == 2 || map[d][r+1][c] == 2 && map[d][r +1][c - 1] == 2 && map[d][r][c-1] == 2) {
                return false;
            }
        }
        else {
            if((map[d][r-1][c-1]==2 && map[d][r-1][c]==2 && map[d][r][c-1]==2) || (map[d][r][c-1]==2 && map[d][r+1][c-1]==2 && map[d][r+1][c]==2) || (map[d][r+1][c]==2 && map[d][r+1][c+1]==2 && map[d][r][c+1]==2) || (map[d][r][c+1]==2 && map[d][r-1][c+1]==2 && map[d][r-1][c]==2) ) {
                return false;
            }
        }
        return true;

    }

    /**
     * This method finds a path of 0 from start to a random cell chose by random methods
     */
    public void findPathRandom() {
        int count =0;
        int sr = start.getRowIndex();
        int sc = start.getColumnIndex();
        int sd = start.getDepthIndex();
        int gr =rand.nextInt(row-1);
        int gc = rand.nextInt(column-1);
        int gd = rand.nextInt(depth-1);
        while (!(sr == gr && sc == gc && sd == gd)) {
            count++;
            int choose = rand.nextInt(7);
            if (choose == 1 && sr != 0) {
                sr = sr - 1;

            } else if (choose == 2 && sc != column - 1) {
                sc = sc + 1;
            } else if (choose == 3 && sr != row - 1) {
                sr = sr + 1;
            }
            else if (choose == 4 && sd != 0) {
                sd = sd - 1;
            } else if (choose == 5 && sd != depth - 1) {
                sd = sd + 1;
            }
            else if(choose==6 && sc !=0){
                sc=sc-1;
            }
            if(closeCircle(sd,sr,sc)) {
                map[sd][sr][sc] = 2;
            }
            if(count== row*column){
                break;
            }
        }
    }

    /**
     * Finding a path of 0 from the maze start position to the maze goal position
     */
    public void findPath(){
        int sr=start.getRowIndex();
        int sc=start.getColumnIndex();
        int sd=start.getDepthIndex();
        int gr=goal.getRowIndex();
        int gc=goal.getColumnIndex();
        int gd= goal.getDepthIndex();

        while (!(sr == gr && sc == gc && sd == gd)){
            int choose=rand.nextInt(6);
            if(choose==1 && sr!=0 ){
                sr=sr-1;

            }
            else if(choose==2 && sc!= column-1 ){
                sc=sc+1;
            }
            else if(choose==3 && sr!= row-1 ){
                sr=sr+1;
            }
            else if(choose==4 && sd!=0){
                sd=sd-1;
            }
            else if(choose==5 && sd!= depth-1){
                sd=sd+1;
            }
            if(closeCircle(sd,sr,sc)) {
                map[sd][sr][sc] = 2;
            }
        }
    }

    /**
     * Going throw all the maze cells and changing their value to 0 if they were 2 before.
     */
    public void paintZero(){
        for(int t=0;t<depth;t++){
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(map[t][i][j]==2){
                        map[t][i][j]=0;
                    }
                }
            }
        }
    }

}

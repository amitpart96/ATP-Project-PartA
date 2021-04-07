package algorithms.maze3D;

import java.util.Random;

/**
 * The MyMaze3DGenerator class extends AMaze3DGenerator.
 * This class will generate all 3D mazes
 */
public class MyMaze3DGenerator extends AMaze3DGenerator{
    Maze3D m;
    int r;
    int d;
    int c;
    Random rand;

    /**
     * This is a maze generate function.
     * @param depth This is a parameter which describes mazes depth.
     * @param row This is a parameter which describes mazes row.
     * @param column This is a parameter which describes mazes column.
     */
    public Maze3D generate(int depth, int row, int column) {
        m = new Maze3D(depth, row, column);
        r=row;
        d=depth;
        c=column;
        rand = new Random();
        setPositions();
        m.findPath();
        m.setWalls();
        for(int i=0;i<r;i++){
            m.findPathRandom();
        }
        m.paintZero();
        return m;
    }

    /**
     * This is a private function.
     * choose a start and goal position and update accordingly this attributes.
     */
    private void setPositions(){
        int startRow = rand.nextInt(r - 1);
        int endRow = rand.nextInt(r - 1);
        if (d != 1) {
            int endDepth = rand.nextInt(d - 1);
            m.setGoalPosition(new Position3D(endDepth, endRow, c - 1));
        }
        else{
            m.setGoalPosition(new Position3D(0, endRow, c - 1));

        }
        m.setStartPosition(new Position3D(0, startRow, 0));
    }
























}

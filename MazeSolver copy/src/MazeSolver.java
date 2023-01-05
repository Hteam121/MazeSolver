import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver {
    private MyStack worklist;
    Maze maze;
    Square[][] array;
    boolean solve;

    MazeSolver()
    {

    }
    MazeSolver(Maze m)
    {
        maze = m;
        array = maze.getArray();
        worklist.push(m.getStart());
        solve = false;
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square s);

    abstract Square next();

    boolean isSolved()
    {
        boolean ans = isEmpty();
        if(worklist.peek().getType() == 3)
            ans = true;
        return ans;
    }

    void step()
    {
        MyStack working = new MyStack();
        MyStack currentPath = new MyStack();

        Square start = maze.getStart();

        //getNeighbors start for working
        List<Square> neighbors = maze.getNeighbors(start);
        int row = 0, col = 0;
        for(int i = 0; i < neighbors.size(); i++)
        {
            Square n = neighbors.get(i);
            if(n.getType() == Square.EMPTY)
                array[n.getRow()][n.getCol()].setStatus(Square.WORKING);
                working.push(array[n.getRow()][n.getCol()]);
                row = n.getRow();
                col = n.getCol();

        }

        //workout path

        while(!working.isEmpty() && currentPath.peek().getType() != 3)
        {
            List<Square> a = maze.getNeighbors(working.peek());

            if(a.size() == 0)
                working.pop();

            if(a.size() >= 1 && a.get(0).getType() != 1)
                currentPath.push(a.get(0));
            for(int i = 0; i < a.size(); i++)
            {
                Square n = a.get(i);
                if(n.getType() == Square.EMPTY)
                    array[n.getRow()][n.getCol()].setStatus(Square.WORKING);
                    array[row][col].setStatus(Square.EXPLORED);
                    row = n.getRow();
                    col = n.getCol();
                    currentPath.push(working.peek());
                    working.pop();
                    working.push(array[n.getRow()][n.getCol()]);

            }
            if(a.size() == 1 && a.get(0).getType() == Square.EXIT)
                currentPath.push(a.get(0));
                solve = true;
        }
    }

    String getPath()
    {
        if(solve == false)
            return "unsolved";
        return "solved";
    }

    void solve()
    {
        while(solve == false)
        {
            step();
        }
    }

}

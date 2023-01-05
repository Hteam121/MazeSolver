public class MazeSolverStack extends MazeSolver
{
    Maze maze;
    public MazeSolverStack(Maze m)
    {
        super(m);
    }

    private MyStack workList;

    public void makeEmpty()
    {
        for(int i = workList.size; i >= 0; i--)
        {
            workList.pop();
        }
    }
    public boolean isEmpty()
    {
        return (workList.isEmpty());
    }
    public void add(Square s)
    {
        workList.push(s);
    }

    public Square next()
    {
        return workList.peek();
    }
}

public class Square
{
    //Variables/initializers
    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int START = 2;
    final static int EXIT = 3;

    final static char WORKING = 'o';
    final static char EXPLORED = '.';
    final static char ON_EXIT_PATH = 'x';
    final static char UNKNOWN = '_';

    private int row;
    private int col;
    private int type;
    private char status;

    public Square(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        reset();
    }

    void reset()
    {
        status = UNKNOWN;
    }

    //Overridden Methods

    @Override
    public String toString()
    {
        if(type == 0)
        {
            return "_";
        }
        if(type == 1)
        {
            return "#";
        }
        if(type == 2)
        {
            return "S";
        }
        return "E";
    }

    public boolean equals(Square obj)
    {
        return row == obj.getRow() && col == obj.getCol();
    }

    //Getter Methods
    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getType()
    {
        return type;
    }

    public char getStatus()
    {
        return status;
    }
    public void setStatus(char s)
    {
        status = s;
    }

}

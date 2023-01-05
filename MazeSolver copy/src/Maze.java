import java.io.File;
import java.io.IOException;
import java.util.*;

public class Maze {

    private Square[][] array;

    public Maze()
    {

    }

    boolean loadMaze(String fileName)
    {
        try{
            File file = new File(fileName);
            Scanner in = new Scanner(file);
            int row = in.nextInt();
            int col = in.nextInt();
            array = new Square[row][col];
            in.nextLine();

            int countRow = 0;
            while(in.hasNextLine())
            {

                for(int c = 0; c < col; c++)
                {
                    array[countRow][c] = new Square(countRow, c, in.nextInt());
                }
                countRow++;
                in.nextLine();
            }
        }
        catch(IOException e)
        {
            return false;
        }
        return true;
    }

    List<Square> getNeighbors(Square s)
    {
        List<Square> ans = new List<Square>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Square> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Square square) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Square> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Square> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Square get(int index) {
                return null;
            }

            @Override
            public Square set(int index, Square element) {
                return null;
            }

            @Override
            public void add(int index, Square element) {

            }

            @Override
            public Square remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Square> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Square> listIterator(int index) {
                return null;
            }

            @Override
            public List<Square> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        int row = s.getRow();
        int col = s.getCol();

        if(row == 0 && col == 0) //top left
            ans.add(array[row + 1][col]);
            ans.add(array[row][col + 1]);
        if(row == array.length && col == 0) //bottom left
            ans.add(array[row - 1][col]);
            ans.add(array[row][col + 1]);
        if(row == 0 && col == array[0].length) //top right
            ans.add(array[row + 1][col]);
            ans.add(array[row][col - 1]);
        if(row == array.length && col == array[0].length) //bottom right
            ans.add(array[row - 1][col]);
            ans.add(array[row][col - 1]);
        if(row == 0) //top side
            ans.add(array[row + 1][col]);
            ans.add(array[row][col+1]);
            ans.add(array[row][col-1]);
        if(row == array.length)//bottom side
            ans.add(array[row - 1][col]);
            ans.add(array[row][col+1]);
            ans.add(array[row][col-1]);
        if(col == 0) //Left Side
            ans.add(array[row][col+1]);
            ans.add(array[row-1][col]);
            ans.add(array[row + 1][col]);
        if(col == array[0].length) {//right side
            ans.add(array[row][col-1]);
            ans.add(array[row - 1][col]);
            ans.add(array[row+1][col]);
        } else { //in between
            ans.add(array[row + 1][col]);
            ans.add(array[row][col + 1]);
            ans.add(array[row - 1][col]);
            ans.add(array[row][col - 1]);
        }

        return ans;
    }

    Square getStart()
    {
        Square ans = array[0][0];
        for(int i = 0; i < array.length; i ++)
        {
            for(int c = 0; c < array[0].length; c++)
            {
                if(array[i][c].toString().equals("S"))
                    ans = array[i][c];
            }
        }
        return ans;
    }

    Square getExit()
    {
        Square ans = array[0][0];
        for(int i = 0; i < array.length; i ++)
        {
            for(int c = 0; c < array[0].length; c++)
            {
                if(array[i][c].toString().equals("E"))
                    ans = array[i][c];
            }
        }
        return ans;
    }

    void reset()
    {
        for(int i = 0; i < array.length; i ++)
        {
            for(int c = 0; c < array[0].length; c++)
            {
                array[i][c].reset();
            }
        }
    }

    @Override
    public String toString()
    {
        String ans = "";
        for(int i = 0; i < array.length; i ++)
        {
            for(int c = 0; c < array[0].length; c++)
            {
                if(array[i][c] == null)
                {
                    ans += " _ ";
                } else {
                    ans += " " + array[i][c].toString() + " ";
                }
            }
            ans += "\n";
        }

        return ans;
    }

    String printArray()  //for testing
    {
        return Arrays.deepToString(array);
    }

    public static void main(String[] args)
    {
        Maze test = new Maze();
        test.loadMaze("maze-2");

        System.out.println(test.toString());
    }

    public Square[][] getArray()
    {
        return array;
    }
}

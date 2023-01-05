import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {

    Square[] stack;
    int size;
    private Exception EmptyStackException;

    MyStack()
    {
        size = 0;
        stack = new Square[5];
    }

    MyStack(int initCap)
    {
        stack = new Square[initCap];
        size = 0;
    }

    boolean isEmpty()
    {
        for(int i = 0; i < size; i++)
        {
            if(stack[i] != null)
            {
                return false;
            }
        }

        return true;
    }

    Square peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[0];
    }

    Square pop()
    {
        if(isEmpty())
            throw new EmptyStackException();
        Square ans = peek();
        //System.out.println("Number of =" + peek());
        stack[0] = null;
        Square[] con = new Square[size];
        for(int i = 0; i < size-1; i++)
        {
            con[i] = stack[i+1];
        }
        stack = con;
        size--;
        return ans;
    }

    void push(Square item)
    {
        if(size == stack.length)
        {
            doubleCapacity();
        }

        for(int i = size; i >= 0; i--)
        {
            if(i == 0)
            {
                stack[i] = item;
            } else {
                stack[i] = stack[i-1];
            }
        }
        size++;
    }

    private void doubleCapacity()
    {
        Square[] con = new Square[size*2];
        for(int i = 0; i < size; i++)
        {
            con[i] = stack[i];
        }

        stack = con;
    }

    @Override
    public String toString()
    {
        String ans = "";
        for(int i = 0; i < size; i++)
        {
            /**
             if(i == size - 1)
             {
             ans += stack[i] + "]";
             } else {
             ans += stack[i] + ", ";
             }
             **/
            ans += "\n" + stack[i];
        }
        return ans + "\n-----------";
    }

    public static void main(String[] args)
    {
        MyStack test = new MyStack();
        System.out.println(test.toString());
    }
}

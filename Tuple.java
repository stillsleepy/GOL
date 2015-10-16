package gol;

/**
 *
 * 
 */
class Tuple<T0, T1>
{
    public T0 first;
    public T1 second;
    
    public Tuple(T0 first, T1 second)
    {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
    
}

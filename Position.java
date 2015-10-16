package gol;

/**
 *
 * 
 */
class Position
{
    public int first;
    public int second;
    
    public Position(int first, int second)
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

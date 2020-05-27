//类功能说明:	经验矩阵Q
public class ExperienceMatrix 
{
    public int get(int x, int y)
    {
        return Q[x][y];
    }
    
    public int[] getRow(int x)
    {
        return Q[x];
    }
    
    public void set(int x, int y, int value)
    {
        Q[x][y] = value;
    }
    
    public void print()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                String s = Q[i][j] + "  ";
                if(Q[i][j] < 10)
                {
                    s = s + "  ";
                }
                else if(Q[i][j] < 100)
                {
                    s = s + " ";
                }
                System.out.print(s);
            }
            System.out.println();
        }
    }
    
    private static int[][] Q = new int[6][6];
    static
    {
        Q[0][0] = 0;
        Q[0][1] = 0;
        Q[0][2] = 0;
        Q[0][3] = 0;
        Q[0][4] = 0;
        Q[0][5] = 0;
        
        Q[1][0] = 0;
        Q[1][1] = 0;
        Q[1][2] = 0;
        Q[1][3] = 0;
        Q[1][4] = 0;
        Q[1][5] = 0;
        
        Q[2][0] = 0;
        Q[2][1] = 0;
        Q[2][2] = 0;
        Q[2][3] = 0;
        Q[2][4] = 0;
        Q[2][5] = 0;
        
        Q[3][0] = 0;
        Q[3][1] = 0;
        Q[3][2] = 0;
        Q[3][3] = 0;
        Q[3][4] = 0;
        Q[3][5] = 0;
        
        Q[4][0] = 0;
        Q[4][1] = 0;
        Q[4][2] = 0;
        Q[4][3] = 0;
        Q[4][4] = 0;
        Q[4][5] = 0;
        
        Q[5][0] = 0;
        Q[5][1] = 0;
        Q[5][2] = 0;
        Q[5][3] = 0;
        Q[5][4] = 0;
        Q[5][5] = 0;
    }
}
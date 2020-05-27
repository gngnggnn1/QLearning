//类功能说明:	反馈矩阵R
public class FeedbackMatrix 
{
    public int get(int x, int y)
    {
        return R[x][y];
    }
    
    public int[] getRow(int x)
    {
        return R[x];
    }
    
    private static int[][] R = new int[6][6];
    static 
    {
        R[0][0] = -1;
        R[0][1] = -1;
        R[0][2] = -1;
        R[0][3] = -1;
        R[0][4] = 0;
        R[0][5] = -1;
        
        R[1][0] = -1;
        R[1][1] = -1;
        R[1][2] = -1;
        R[1][3] = 0;
        R[1][4] = -1;
        R[1][5] = 100;
        
        R[2][0] = -1;
        R[2][1] = -1;
        R[2][2] = -1;
        R[2][3] = 0;
        R[2][4] = -1;
        R[2][5] = -1;
        
        R[3][0] = -1;
        R[3][1] = 0;
        R[3][2] = 0;
        R[3][3] = -1;
        R[3][4] = 0;
        R[3][5] = -1;
        
        R[4][0] = 0;
        R[4][1] = -1;
        R[4][2] = -1;
        R[4][3] = 0;
        R[4][4] = -1;
        R[4][5] = 100;
        
        R[5][0] = -1;
        R[5][1] = 0;
        R[5][2] = -1;
        R[5][3] = -1;
        R[5][4] = 0;
        R[5][5] = 100;
    }
}
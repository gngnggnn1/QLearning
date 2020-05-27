import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QLearning 
{
    FeedbackMatrix R = new FeedbackMatrix();
    
    ExperienceMatrix Q = new ExperienceMatrix();
    
    static double gamma = 0; // Input Gamma
    
    public static void main(String[] args)
    {
        QLearning ql = new QLearning();

    	Scanner sc = new Scanner(System.in);
    	System.out.println("Input Gamma (0 < Gamma < 1)");
    	gamma = sc.nextDouble();
    	sc.close();
    	int times = 1000;
    	
        for(int i = 0; i < times; i++)
        {
            Random random = new Random();
            int x = random.nextInt(100) % 6;
            System.out.println(" ");
            System.out.println("     " + (i + 1) + " times trained");
            ql.learn(x);
        }
    }
    //x is room you are in now
    public void learn(int x)
    {
        do
        {
            // Randomly select a room to enter
            int y =  chooseRandomRY(x);
            
            // Get the best score in history starting with the room you entered
            int qy = getMaxQY(y);
            
            // Calculate the score for the move
            int value = calculateNewQ(x, y, qy);
            Q.set(x, y, value);
            x = y;
        }
        // room == 5 is the end of learning
        while(5 != x);
        
        Q.print();
    }
    
    public int chooseRandomRY(int x)
    {
        int[] qRow = R.getRow(x);
        List<Integer> yValues = new ArrayList<Integer>();
        for(int i = 0; i < qRow.length; i++)
        {
            if(qRow[i] >= 0)
            {
                yValues.add(i);
            }
        }

        Random random = new Random();
        int i = random.nextInt(yValues.size()) % yValues.size();
        return yValues.get(i);
    }
    
    public int getMaxQY(int x)
    {
        int[] qRow = Q.getRow(x);
        int length = qRow.length;
        List<YAndValue> yValues = new ArrayList<YAndValue>();
        for(int i = 0; i < length; i++)
        {
            YAndValue yv = new YAndValue(i, qRow[i]);
            yValues.add(yv);
        }
        
        Collections.sort(yValues);
        int num = 1;
        int value = yValues.get(0).getValue();
        for(int i = 1; i < length; i++)
        {
            if(yValues.get(i).getValue() == value)
            {
                num = i + 1;
            }
            else
            {
                break;
            }
        }
        
        Random random = new Random();
        int i = random.nextInt(num) % num;
        return yValues.get(i).getY();
    }
    
    // Q(x,y) = R(x,y) + gamma * max(Q(y,i)) y:y i:qy
    public int calculateNewQ(int x, int y, int qy)
    {	
        return (int) (R.get(x, y) + gamma * Q.get(y, qy));
    }
    
    //stores Y and its' value.
    public static class YAndValue implements Comparable<YAndValue>
    {
        int y;
        int value;
        
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public YAndValue(int y, int value)
        {
            this.y = y;
            this.value = value;
        }
        public int compareTo(YAndValue o) 
        {
            return o.getValue() - this.value;
        }
    }
}

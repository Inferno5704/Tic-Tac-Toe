import java.util.Scanner;
public class Tic_Tac_Toe
{
    char dary[][];
    String n1;
    String n2;
    int ary[];
    public Tic_Tac_Toe()
    {
        dary=new char[3][3];
        ary=new int[9];
    }
    public void input()
    {
        System.out.println("Enter Player 1 name");
        Scanner sc=new Scanner(System.in);
        n1=sc.nextLine();
        System.out.println("Enter Player 2 Name");
        n2=sc.nextLine();
        System.out.println("Enter the Number at which you token will be kept Player 1 is X and Player 2 is O");
        
        for(int i=0;i<9;i++)
        {
            display();
            System.out.println("Player 1 Enter the Number");
            int p=sc.nextInt();
            if(ary[p-1]==11 || ary[p-1]==22)
            {
                System.out.println("The Space is Occupied Please Enter Another Number");
                p=sc.nextInt();
            }
            settle(p,'X');
            ary[p-1]=11;
            if('X'==check())
            {
                display();
                System.out.println(n1+" WON");
                break;
            }
            System.out.println("Player 2 Enter the Number");
            int q=sc.nextInt();
            if(ary[q-1]==11 || ary[q-1]==22)
            {
                System.out.println("The Space is Occupied Please Enter Another Number");
                q=sc.nextInt();
            }
            settle(q,'O');
            ary[q-1]=22;
            if('X'==check())
            {
                display();
                System.out.println(n2+" WON");
                break;
            }
            System.out.println("\f");
        }
    }
    public void display()
    {
        int te=1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(dary[i][j]!='X' && dary[i][j]!='O')
                System.out.print(te+" ");
                else
                System.out.print(dary[i][j]+" ");
                if(j==0 || j==1)
                System.out.print("|");
                te++;
            }
            System.out.println();
            if(i==0 || i==1)
            System.out.println("__ __ __");
        }
    }
    public void settle(int p,char c)
    {
        int te=1;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(te==p)
                dary[i][j]=c;
                te++;
            }
        }
    }
    public char check()
    {
        for(int i=0;i<3;i++)
        {
            if(dary[i][0]==dary[i][1] && dary[i][1]==dary[i][2])
            return dary[i][0];
        }
        for(int i=0;i<3;i++)
        {
            if(dary[0][i]==dary[1][i] && dary[2][i]==dary[0][i])
            return dary[0][i];
        }
        if(dary[0][0]==dary[1][1] && dary[1][1]==dary[2][2])
        return dary[0][0];
        if(dary[0][2]==dary[1][1] && dary[2][0]==dary[1][1])
        return dary[1][1];
        return 'P';
    }
    public static void main(String[]arg)
    {
        Tic_Tac_Toe tt=new Tic_Tac_Toe();
        tt.input();
    }
}

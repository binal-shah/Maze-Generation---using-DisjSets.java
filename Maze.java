/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project4;

/**
 *
 * @author Binal Shah
 */

import java.util.*;

public class Maze 
{
    public void print(int r,int c, Arr[][] mat)
    {
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0&&j==0)
                {
                    System.out.print("   ");
                    for(int k=0;k<c-1;k++)
                        System.out.print("_ ");
                    System.out.println();
                }
                //lwall=leftwall and bwall=bottom wall
                if(mat[i][j].lWall)
                {
                    System.out.print("|");
                }
		else
                {
                    System.out.print(" ");
                }
		if(mat[i][j].bWall)
                {
                    System.out.print("_");
                }
		else
                {
                    System.out.print(" ");
                }
                if(j==c-1&&i!=r-1)
                {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) 
        {
            Maze m=new Maze();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of rows: ");
            int r = sc.nextInt();
            System.out.println("Enter number of columns: ");
            int c = sc.nextInt();
            Arr[][] mat = new Arr[r][c];
            ArrayList<Grid> l = new ArrayList<>();
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    mat[i][j] = new Arr();
			if(i==0&&j==0)
                        {
                            mat[i][j].lWall=false;
                        }
			if(i==r-1&&j==c-1)
                        {
                            mat[i][j].bWall=false;
                        }
                }
            }
            for(int i=0;i<r;i++)
            { 
                for(int j=0;j<c;j++)
                {
                    int current=i*c+j;
                    int left=current-1;int bottom= current+c;
                    if(j!=0)
                    {
                        l.add(new Grid("vertical",left,current));
                    }
                    if(i!=r-1)
                    {
                        l.add(new Grid("horizontal",current,bottom));
                    }
                }
            }
            System.out.println("Pring the Initial mat: ");
            m.print(r,c,mat);
            DisjSets d = new DisjSets(r*c);
            Random rand = new Random();
            int count=0;
            while(count!=r*c-1)
            {
                Grid g = l.get(rand.nextInt(l.size()));
                int leftofWall = d.find(g.leftofWall);
                int low=leftofWall;
		int rightofWall= d.find(g.rightofWall);
                int row=rightofWall;
		if(g.orientation.equals("vertical")&&low!=row)
		{
                    int i = g.rightofWall/c;
                    int j =g.rightofWall%c;
                    d.union(d.find(low),d.find(row));
                    count++;
                    mat[i][j].lWall=false;
                }
                else if(g.orientation.equals("horizontal")&&low!=row)
                {
                    d.union(d.find(low),d.find(row));
                    count++;
                    int i = g.leftofWall/c;
                    int j = g.leftofWall%c;
                    mat[i][j].bWall=false;
		}
            }
            System.out.println("Printing the Final Maze: ");
            m.print(r,c,mat);
        }
}
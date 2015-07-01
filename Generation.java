package kraskal;

import java.io.*;

public class Generation
{
	public static int N;
	public static int curAdges;
	public int k;
	public boolean[][] matr;
	public boolean[] reltop;
	
	public Generation() throws IOException
	{
                boolean[][] matr = new boolean [N][N];
                boolean[] reltop = new boolean [N];
		spanningTree(matr, reltop, N, curAdges);
		creatGraph(matr, N, curAdges, k);
		outfile(matr, N);
	}
	
	private static void spanningTree(boolean matr[][], boolean reltop[], int N, int curAdges)
	{
		reltop[(int)(Math.random()*N)] = true;
		for(curAdges = 0; curAdges < N-1; curAdges++)
		{
			int i = (int)(Math.random()*N),
				j = (int)(Math.random()*N);
			
			while(!reltop[i]) 
			{
				i++;
				i %= N;
			}
			
			if(reltop[i])
			{	
				while(reltop[j]) 
				{
					j++;
					j %= N;
				}
				
				reltop[j] = true;
				matr[i][j] = true;
			}
		}
	}
	
	private static void creatGraph(boolean matr[][], int N, int curAdges, int k)
	{
		for(;curAdges < (int)(k*N*(N-1)/200); curAdges++)
		{
			int i = (int)(Math.random()*N),
				j = (int)(Math.random()*N);
			
			while(matr[i][j] || matr[j][i] || (i == j))
			{
				int step = (int)(Math.random()*4);
				switch(step)
				{
				case 0: i++; i %= N; break;
				case 1: j++; j %= N; break;
				case 2: i--; i = (i < 0) ? N-1 : i; break;
				case 3: j--; j = (j < 0) ? N-1 : j; break;
				}				
			}
			
			matr[i][j] = true;
		}
	}
	
	private static void outfile(boolean matr[][], int N) throws IOException
	{
		File f = new File("graph.txt");
		PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter(f)));
                curAdges = 0;
                for(int i = 0; i < N; i++)
                    for(int j = 0; j < N; j++)
                        if(matr[i][j])
                            curAdges++;
                outf.printf("%d %d\n", curAdges, N);
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				if(matr[i][j])
				{
					int e = 1+(int)(Math.random()*100);
					outf.printf("%d %d %d", i, j, e);
					outf.println();
					outf.flush();
				}
			}
	}
}

package kraskal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class KraskalTesting {
	private Graph[] testGraphs;
	private double[] testTimes;
	Generation generation;
	public KraskalTesting()
	{
		testGraphs = null;
		testTimes = null;
	}
	
	public void startTests(int testsQuantity, int verticesQuantity) throws IOException
	{
            if (testGraphs == null || testTimes == null)
            {
                    testGraphs = new Graph[testsQuantity];
                    testTimes = new double[testsQuantity];
            }
            else
            {
                    testGraphs = Arrays.copyOf(testGraphs, testGraphs.length + testsQuantity);
                    testTimes = Arrays.copyOf(testTimes, testTimes.length + testsQuantity);
            }

            KraskalAlgorithm kraskalAlgorithm = new KraskalAlgorithm();
            for (int i = testsQuantity; i > 0; i--)
            {
                generation = null;
                Generation.N = verticesQuantity;
                generation = new Generation();
                Graph graph = null;
                String absolutePath = new File("").getAbsolutePath();
                try {
                        graph = new Graph(absolutePath + "/graph.txt");
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                testGraphs[testGraphs.length - i] = graph;
                long elapsedTime = System.nanoTime();
                kraskalAlgorithm.GetMinSpanTree(testGraphs[testGraphs.length - i]);
                elapsedTime = System.nanoTime() - elapsedTime;
                testTimes[testGraphs.length - i] = elapsedTime / 1000000000.0;
                System.out.println("Test number: " + (testGraphs.length - i));
                System.out.print("Test time: ");
                System.out.printf("%f", testTimes[testGraphs.length - i]);
                System.out.println();
            }
	}
	
	public void getWorstTimeAndGraph()
	{
		double worstTime = -1;
                int worstTimeIndex = 0;
		for (int i = 0 ; i < testTimes.length; i++)
                    if(worstTime < testTimes[i])
                    {
                        worstTime = testTimes[i];
                        worstTimeIndex = i;
                    }
                System.out.print("Worst time is : ");
                System.out.printf("%f", worstTime);
                System.out.println();
                System.out.println("Worst graph is : ");
                for (Graph.GraphEdge data : testGraphs[worstTimeIndex].GetData())
                    System.out.println("s: " + data.GetSrc() + " d: " + data.GetDst() + " l: " + data.GetLength());
	}
	
	public void getBestTimeAndGraph()
	{
		double bestTime = Double.MAX_VALUE;
                int bestTimeIndex = 0;
		for (int i = 0 ; i < testTimes.length; i++)
                    if(bestTime > testTimes[i])
                    {
                        bestTime = testTimes[i];
                        bestTimeIndex = i;
                    }
                System.out.print("Best time is : ");
                System.out.printf("%f", bestTime);
                System.out.println();
                System.out.println("Best graph is : ");
                for (int i = 0; i < testGraphs[bestTimeIndex].GetEdgeCount(); i++)
                    System.out.println(
                            "s: " + testGraphs[bestTimeIndex].GetData().get(i).GetSrc() + 
                            " d: " + testGraphs[bestTimeIndex].GetData().get(i).GetDst() + 
                            " l: " + testGraphs[bestTimeIndex].GetData().get(i).GetLength()
                    );
	}
}

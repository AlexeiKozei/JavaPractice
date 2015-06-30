package kraskal;

import java.util.Arrays;

public class KraskalTesting {
	private Graph[] testGraphs;
	private double[] testTimes;
	
	public KraskalTesting()
	{
		testGraphs = null;
		testTimes = null;
	}
	
	public void startTests(int quantity)
	{
		if (testGraphs == null || testTimes == null)
		{
			testGraphs = new Graph[quantity];
			testTimes = new double[quantity];
		}
		else
		{
			testGraphs = Arrays.copyOf(testGraphs, testGraphs.length + quantity);
			testTimes = Arrays.copyOf(testTimes, testTimes.length + quantity);
		}
		
		KraskalAlgorithm kraskalAlgorithm = new KraskalAlgorithm();
		for (int i = quantity; i > 0; i--)
		{
			testGraphs[testGraphs.length - i] = GraphGeneration.generate();
			long elapsedTime = System.currentTimeMillis();
			kraskalAlgorithm.GetMinSpanTree(testGraphs[testGraphs.length - i]);
			elapsedTime = System.currentTimeMillis() - elapsedTime;
			testTimes[testGraphs.length - i] = elapsedTime / 1000.0;
			System.out.println("Test number: " + (testGraphs.length - i));
			System.out.println("Test time: " + testTimes[testGraphs.length - i]);
		}
	}
	
	public double getWorstTime()
	{
		double worstTime = -1;
		for (double t : testTimes)
			worstTime = (worstTime < t) ? t : worstTime;
		return worstTime;
	}
	
	public double getBestTime()
	{
		double bestTime = Double.MAX_VALUE;
		for (double t : testTimes)
			bestTime = (bestTime > t) ? t : bestTime;
		return bestTime;
	}
	
	public Graph getWorstTimeGrapth()
	{
		int worstTimeIndex = 0;
		double worstTime = -1;
		for (int i = 0; i < testTimes.length; i++)
			if(worstTime < testTimes[i]) 
			{
				worstTime = testTimes[i];
				worstTimeIndex = i;
			}
		return testGraphs[worstTimeIndex];
	}

	public Graph getBestTimeGrapth()
	{
		int bestTimeIndex = 0;
		double bestTime = Double.MAX_VALUE;
		for (int i = 0; i < testTimes.length; i++)
			if(bestTime > testTimes[i]) 
			{
				bestTime = testTimes[i];
				bestTimeIndex = i;
			}
		return testGraphs[bestTimeIndex];
	}
	
	public double getTimeByTestIndex(int index)
	{
		return testTimes[index];
	}
	
	public Graph getGraphByTestIndex(int index)
	{
		return testGraphs[index];
	}
}

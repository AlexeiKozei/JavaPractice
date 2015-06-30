package kraskal;

import java.io.File;
import java.io.FileNotFoundException;

//Класс пустышка

public class GraphGeneration {
	public static Graph generate()
	{
		Graph graph = null;
		String absolutePath = new File("").getAbsolutePath();
		try {
			graph = new Graph(absolutePath + "/src/resources/graph.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return graph;
	}
}

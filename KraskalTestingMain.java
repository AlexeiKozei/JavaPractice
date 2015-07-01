package kraskal;
import java.io.IOException;
import kraskal.*;
public class KraskalTestingMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        KraskalTesting kraskalTesting = new KraskalTesting();
        if (args.length > 1)
        {
            kraskalTesting.startTests(Integer.parseInt(args[0]), Integer.parseInt(args[1]));   
            kraskalTesting.getBestTimeAndGraph();
            kraskalTesting.getWorstTimeAndGraph();
        }
        else 
            System.out.println("Вы не укзали количество тестов или количество вершин!");
    }
    
}

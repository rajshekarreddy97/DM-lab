import java.util.*;
import java.io.*;

public class MainClass
{
  Scanner in = new Scanner(System.in);
  ArrayList<Double[]> x;
  ArrayList<Double> y;
  Double weights[];

  public MainClass()
  {
    System.out.prinln("Enter input file name: ");
    String fileName = in.nextLine();

    x = new ArrayList<Double[]>();
    y = new ArrayList<Double>();

    loadFile(fileName);
  }

  private void loadFile(String fileName)
  {
    try
    {
      String data;
      BufferedReader csv = new BufferedReader(new FileReader(new File(filename)));
      data = csv.readLine();

      while(data!=null)
      {
        String[] rowData = data.split(",");
        int dim = rowData.length-1;
        Double xVal[] = new Double[dim+1];
        xVal[0] = 1.0;
        for(int i=1;i<=dim;i++)
        {
          xVal[i] = Double.parseDouble(rowData[i-1]);
        }
        x.add(xVal);
        y.add(Double.parseDouble(rowData[dim]));
        data = csv.readLine();
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("No such File");
      System.exit(0);
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }


  private void trainModel(double rate,int iter)
  {
    int dim=x.get(0).length;
    weights = new Double(dim);
    for(int i=0;i<dim;i++)
    {
      weights[i].Math.random();
    }

    System.out.prinln("Initial weights:");
    showWeights();

    for(int i=1;i<=iter;i++)
    {
      for(int j=0;j<x.size();j++)
      {
        int op = predictClass(x.get(j));
        double change = rate*(y.get(j)-op);
        for(int w=0;w<weights.length;w++)
        {
          weights[w] = weights[w]+(change*x.get(j)[w]);
        }
      }
    }

    System.out.println("Final Weights:-");
		showWeights();
  }

  private void showWeights()
  {
    for(Double weight:weights)
    {
      System.out.println(weight);
    }
    System.out.println("\n");
  }

  private int predictClass(Double[] x)
  {
    double op=0.0;
    for(int i=0;i<weights.length;i++)
    {
      op=op+(weights[i]*x[i]);
    }
    return (op>=0)?1:0
  }

  public static void main(String[] args)
  {
    MainClass mc = new MainClass();
    mc.trainModel(0.2,1000);

    Double t1[]={1.0,6.2,3.0,4.8,1.5};
		Double t2[]={1.0,3.4,4.9,2.7,0.1};

    System.out.println("Predicted Class for "+Arrays.toString(t1)+" is "+mc.predictClass(t1));
		System.out.println("Predicted Class for "+Arrays.toString(t2)+" is "+mc.predictClass(t2));
  }
}

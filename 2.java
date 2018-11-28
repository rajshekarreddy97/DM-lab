import java.io.*;
import java.util.*;

public class prog2
{
  static ArrayList<String[]> data = new ArrayList<>();

  public static void replace(int x,String y)
  {
    for(String[] line:data)
    {
      if(x<line.length && line[x].isEmpty())
      {
        line[x]=y;
      }
    }
  }

  public static void main(String args[]) throws FileNotFoundException, IOException
  {
    BufferedReader csv = new BufferedReader(new FileReader(new File("/home/data.csv")));
    String lines;

    Scanner sc = new Scanner(System.in);

    while((lines = csv.readLine()) != null)
    {
      String[] singleLine = lines.split(",",-1);
      data.add(singleLine);
    }

    while(true)
    {
      System.out.println("Choice\n 1.Avg of columns\n 2.Mode of coloumns\n 3.Print CSV\n 4. Exit");
      int option = sc.nextInt();

      switch(option)
      {
        case 1: System.out.println("Enter the coloumn number\n");
                int col=sc.nextInt();
                double avg=0, total=0;
                for (String[] line:data)
                      if(col<line.length && !line[col].isEmpty())
                      {
                        avg = avg+Double.parseDouble(line[col]);
                        total++;
                      }
                replace(col, Double.toString(avg/total));
                break;

        case 2: System.out.println("Enter the coloumn number\n");
                int col1=sc.next();
                HashMap<String, Integer> al = new HashMap();
                for(String[] line:data)
                {
                  if(col1<line.length && !line[col1].isEmpty())
                  {
                    if(al.containsKey(line[col1]))
                    {
                      int temp = al.get(line[col1]);
                      al.put(line[col1], temp+1);
                    }
                    else
                    {
                      al.putline([col1],1);
                    }
                  }
                }

                String mode="";
                if(!al.isEmpty())
                {
                  int max=0;
                  for(String key: al.keySet())
                  {
                    if(al.get(key)>max)
                    {
                      max=al.get(key);
                      mode=key;
                    }
                  }
                }
                replace(col1,mode);
                break;

        case 3: for(string[] line:data)
                {
                  for(String word:line)
                  {
                    System.out.print(word + "\t\t");
                  }
                  System.out.println();
                }
                break;

        case 4: System.exit(0);
        default: System.out.println("Wrong Choice");

      }
    }


  }

}

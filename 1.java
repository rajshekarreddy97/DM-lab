import java.io.*;
import java.util.*;

public class Records
{
	int index, attr1;
	String attr2;
}

public class prog1 {

	static Records[] rc = new Records[10];

	public static void main(String[] args) throws FileNotFoundException, IOException {

		BufferedReader CSV = new BufferedReader(new FileReader(new File("/desktop/data.csv")));
		String data = CSV.readLine();

		int i=0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		System.out.println("DataSet: ");

		while(data!=null)
		{
			rc[i]= new Records();
			String[] dataArray = data.split(",");

			rc[i].index = Integer.parseInt(dataArray[0]);
			rc[i].attr1 = Integer.parseInt(dataArray[1]);
			rc[i].attr2 = dataArray[2];

			if(rc[i].attr1 > max)
			{
				max=rc[i].attr1;
			}
			if(rc[i].attr1 < min)
			{
				min = rc[i].attr1;
			}

			System.out.println(rc[i].index+" "+rc[i].attr1+" "+rc[i].attr2);

			data= CSV.readLine();
			i++;
		}

		int avg = 0;
		for(int j=0;j<i;j++)
		{
			avg += rc[j].attr1;
		}
		avg= avg/i;

		System.out.println("Maax Value: "+max+"\t Min Value:"+min);
		System.out.println("Average Value is :"+avg);


		int mean = (min + max)/2;
		int mid1 = (min + mean)/2;
		int mid2 = (max + mean)/2;
		int sampling[] = new int[4];

		for(int j=0;j<i;j++)
		{
			System.out.print(rc[j].index+" "+rc[j].attr1+" "+rc[j].attr2);
			if(rc[j].attr1 >= min && rc[j].attr1 < mid1)
			{
				System.out.println(" ["+min+"-"+mid1+")");
				sampling[0]=rc[j].attr1;
			}
			else if(rc[j].attr1 >= mid1 && rc[j].attr1 < mean)
			{
				System.out.println(" ["+mid1+"-"+mean+")");
				sampling[1]=rc[j].attr1;
			}
			else if(rc[j].attr1 >= mean && rc[j].attr1 < mid2)
			{
				System.out.println(" ["+mean+ "-"+mid2+")");
				sampling[2]=rc[j].attr1;
			}
			else if(rc[j].attr1 >= mid2 && rc[j].attr1 <= max)
			{
				System.out.println(" ["+mid2+"-"+max+")");
				sampling[4]=rc[j].attr1;
			}
		}

		//sampling result stored in array sampling---will return 0 if none elements are present in the range
		System.out.println("----sampling-------");
		System.out.println(" ["+min+"-"+mid1+") -"+sampling[0]);
		System.out.println(" ["+mid1+"-"+mean+") -"+sampling[1]);
		System.out.println(" ["+mean+"-"+mid2+") -"+sampling[2]);
		System.out.println(" ["+mid2+"-"+max+") -"+sampling[3]);

	}

}


// 1 50 hello
// 2 30 ajay
// 3 23 ager
// 4 76 agre
// 5 87 wert
// 6 65wefg
// 7 12fgdb

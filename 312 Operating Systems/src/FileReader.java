import java.util.*;
import java.io.*;
public class FileReader {
	 
	public static void main (String [] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		int fileNum=0;
		String filename;
		int runtime= 0; 
		int memory = 0;
		int counter =0;
		String name = "";
		int filecounter=0;
		int x;
		ArrayList<Process> allfiles = new ArrayList<Process>();
		System.out.println("How many files do you have");
		x=in.nextInt();
		while(filecounter<x) // number of files
		{
			System.out.println("enter file name");
			filename=in.nextLine();
			File file = new File(filename);
			Scanner s = new Scanner(file);
			//Scanner s = new Scanner(new File(filename));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){// takes in all file values
			    list.add(s.next());
			}
			for(int i=0; i<list.size(); i++)
			{
				if(list.get(i).equals("Name:"))
				{
			
					name= list.get(i + 1);
					list.remove(i);// removes name 
					list.remove(i+1);// removes file name
				}
				if(list.get(i).equals("Runtime:"))
				{
					runtime=Integer.parseInt(list.get(i+1));
					list.remove(i); //removes runtime
					list.remove(i+1); //removes runtime value
				}
				if(list.get(i).equals("Memory:"))
				{
					memory=Integer.parseInt(list.get(i+1));
					list.remove(i);//removes memory
					list.remove(i+1); //removes memory value
				}
			}
			counter++;//pid starts from 1 and goes up
			Process p = new Process(name,counter,runtime,memory,list);
			allfiles.add(p);
			s.close();
		
		}	
	}// default as driver class
}

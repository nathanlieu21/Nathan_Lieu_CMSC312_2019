import java.util.*;
import java.io.*;
public class FileReader {
	 
	public static void main (String [] args) throws Exception
	{
		Scanner s = new Scanner(new File("test1.txt"));
		String name = "";
		int runtime= 0; 
		int memory = 0;
		int counter =1;
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).equals("Name:"))
			{
				name= list.get(i + 1);
			}
			if(list.get(i).equals("runtime:"))
			{
				runtime=Integer.parseInt(list.get(i+1));
			}
			if(list.get(i).equals("Memory:"))
			{
				memory=Integer.parseInt(list.get(i+1));
			}
		}
		Process p1 = new Process(name,counter,runtime, memory,list);
		
		
	}
	
	
	// read all files int an array list and store in storage class
}

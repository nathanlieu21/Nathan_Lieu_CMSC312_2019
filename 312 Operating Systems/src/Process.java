import java.util.*;
// mixing processblcok and process together  both fucntions fcfs
public class Process {
	private String name; 
	private ProcessState state;
	private int pid;
	private int size;
	private ArrayList<String >fileStorage = new ArrayList<>();
	private int calculate;
	private int memory;
	private int io;
	private int runtime;
	private int currentRuntime;
	
	
	
	
	Process(String inputName,int id, int inputSize, int mery, ArrayList<String> x) // stores files
	{
		this.name=inputName;
		this.pid=id;
		this.size=inputSize;
		this.memory=mery;
		this.state= ProcessState.New;
		
	}
	
	/* Process Block*/
	public void setName(String x)
	{
		this.name=x;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPid(int id)
	{
		this.pid=id;
	}
	public int getPid()
	{
		return this.pid;
	}
	
	public int getSize()
	{
		return this.size;
	}
	public void setProcessState(ProcessState x)
	{
		this.state=x;
	}
	public ProcessState getProcessState()
	{
		return this.state;
	}
	
	public String printPCB()
	{
		return " Process: " + this.getName() + "Pid: " + this.getPid() + "Size of Process: " + this.getSize() + "Current Process State: " + this.getProcessState() ;
	}
	
	
	public int getIO()
	{
		return this.io;
	}
	public void setTotalTime(int x)
	{
		this.runtime=x;
	}
	public int getTotalTime()
	{
		return runtime;
	}
	public int getRuntime() // total
	{
		return currentRuntime;
	}
	
	/* 4 commands execpt io b/c fcfs*/
	public void caculateFCFS() // each i is a word
	{
		for(int i=0; i<fileStorage.size(); i++)
		{
			if(fileStorage.get(i).equals("Calculate"))
			{
				currentRuntime += Integer.parseInt(fileStorage.get(i +1)) ; // converts string to number 
			}
		}
	}
	/*public void IOFCFS() uneeded fcfs
	{
		
	}*/
	public void yieldFCFCS()// puts process on wait in scheduler class move to wait queuqe
	{
		state=ProcessState.Wait;
	}
	public void printpcb() //outputs process block
	{
		for(int i=0; i<fileStorage.size(); i++)
		{
			if(fileStorage.get(i).equals("Out"))
			{
				this.printpcb();
			}
		
	}
		

}
}
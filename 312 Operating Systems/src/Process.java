import java.util.*;
// mixing processblcok and process together  both fucntions fcfs
public class Process {
	private String name; //file name
	private ProcessState state;
	private int pid;
	private int size;
	private int totalruntime;
	private ArrayList<String >fileStorage = new ArrayList<>();
	//private int calculate;
	private int memory;
	private int io;
	
	
	
	
	
	Process(String inputName,int id, int total,int mem, ArrayList<String> x) // stores files
	{
		this.name=inputName;
		this.pid=id;
		this.totalruntime=total;
		this.memory=mem;
		this.fileStorage=x;
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
	public void setMemory(int x)
	{
		this.memory=x;
	}
	public int getMemory()
	{
		return memory;
	}
	
	public void setProcessState(ProcessState x)
	{
		this.state=x;
	}
	public ProcessState getProcessState()
	{
		return this.state;
	}
	
	public ArrayList<String> getList()
	{
		return fileStorage;
	}
	public void removeindex (int i)
	{
		fileStorage.remove(i);
	}
	public  String getindex(int i)
	{
		return fileStorage.get(i);
	}
	public String printPCB()
	{
		return " Process: " + this.getName() + "Pid: " + this.getPid() + "Size of Process: " + this.getTotalTime() + "Current Process State: " + this.getProcessState() ;
	}
	
	public void setIO (int x)
	{
		io=x;
	}
	
	public int getIO()
	{
		return io;
	}
	
	/*public int getIO()
	{
		return this.IO;
	}*/
	public void setTotalTime(int x)
	{
		this.totalruntime=x;
	}
	public int getTotalTime()
	{
		return totalruntime;
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
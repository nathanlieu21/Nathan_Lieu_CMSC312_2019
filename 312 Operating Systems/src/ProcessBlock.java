import java.util.*;

public class ProcessBlock {
	String name; 
	ProcessState state;
	int pid;
	int size;
	private ArrayList<String >fileStorage = new ArrayList<>();
	
	
	ProcessBlock(String inputName,int id, int inputSize, Process state, ArrayList<String> x) // stores files
	{
		this.name=inputName;
		this.pid=id;
		this.size=inputSize;
		this.state= ProcessState.New;
		
	}
	
	/* many uneeded just need for testing later*/
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
		return this.getSize();
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

}

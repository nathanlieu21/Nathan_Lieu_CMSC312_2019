import java.util.*;
public class Scheduler {
	// three queues always required in scheduler 
	public ArrayList<Process> readyQueue = new ArrayList<>();
	public ArrayList<Process> executeQueue = new ArrayList<>();
	public ArrayList<Process> waitQueue = new ArrayList<>(); // empty b/c first come first serve 
	
	//1. update for execute queue
	//2. all other queues manuel
	//3. size or inputs of queue
	public void addRQueue(Process x) // add all files to ready
	{
		if(x.getProcessState()==ProcessState.New)
		{
			x.setProcessState(ProcessState.Ready);
			readyQueue.add(x);
		}
	}
	public void addEQueue(Process x)
	{
		if(x.getProcessState()==ProcessState.Ready)
		{
			executeQueue.add(x);// adds to execute
			readyQueue.remove(x); // removes from ready queue
			x.setProcessState(ProcessState.Run);
			x.caculateFCFS();// caculate
			if(x.getRuntime()==x.getTotalTime())// runtime over
			{
				x.setProcessState(ProcessState.Terminate);
				executeQueue.remove(x);// remove
				
			}
		}
		
	}
	public void addWQueue(Process x)
	{
		if(x.getProcessState()==ProcessState.Wait)
		{
			waitQueue.add(x);
		}
	}
	
	public void deleteReadyQueue(Process x)
	{
		if(x.getProcessState()!=ProcessState.Ready)
		{
			readyQueue.remove(x);
		}
		
	}
	
	public void deleteWaitQueue(Process x)
	{
		if(x.getProcessState()!=ProcessState.Wait)
		{
			waitQueue.remove(x);
		}
		
	}
	
	/* possible get content of process in arrays*/
	

}

import java.util.*;
public class Scheduler {
	// three queues always required in scheduler 
	public ArrayList<Process> readyQueue = new ArrayList<Process>();
	public ArrayList<Process> executeQueue = new ArrayList<Process>();
	public ArrayList<Process> waitQueue = new ArrayList<Process>();// empty b/c first come first serve 
	
	
	
	
	
	

	// read arraylist into queque 

	public void sort(ArrayList<Process> x) //sorting for shortest job can apply it to the ready queque
	{
		Collections.sort(x, new Comparator<Process>()
				{
			@Override
			public int compare(Process a, Process b)
			{
				return Integer.compare(a.getTotalTime(), b.getTotalTime()); //sort arraylist in dascending order memory 
			}
				});
		
		
	}
	
	public void addRQueue(Process x) // adds all
	{
		if(x.getProcessState()==ProcessState.New)
		{
			x.setProcessState(ProcessState.Ready);
			readyQueue.add(x);
		}
	}
	
	
	public void execute(Process x)
	{
		if(x.getProcessState()==ProcessState.Ready)
		{
			readyQueue.remove(0); // removes from ready queue
			x.setProcessState(ProcessState.Run); // change state
			executeQueue.add(x); //add execute queue
			for(int i=0; i<x.getList().size(); i++) //loop through array
			{
				if(x.getindex(i).equals("calculate"))
				{
					// runtime =0
					x.setTotalTime(x.getTotalTime()-Integer.parseInt(x.getindex(i+1))); //gets value - time
					x.removeindex(i);
					x.removeindex(i+1);
				}
				if(x.getindex(i).equals("I/O")) // wait call
				{
					x.setIO(i+1);// gets i/o number
					waitQueue.add(x); // add wait queue
					x.setProcessState(ProcessState.Wait); //change state
					executeQueue.remove(0); //removes from execute
					x.removeindex(i);
					x.removeindex(i+1);
					break;//loop
					
				}
				if(x.getindex(i).equals("Yield"))
				{
					//later
				}
				if(x.getindex(i).equals("OUT"))
				{
					x.printPCB();//pcb
					x.removeindex(i);
					
				}
				if(x.getindex(i).equals("EXE"))
				{
					executeQueue.remove(0);
					x.setProcessState(ProcessState.Terminate);
					break;//loop
				}
				
				
			}
			
			/*if(x.getTotalTime()==0)// runtime over
			{
				x.setProcessState(ProcessState.Terminate);
				readyQueue.add(x);
				
			}*/
		}
		
	}
	//driver class three arrays ready ,wait execute , pick next on ready quee for i/o then after i/o doe sort create a private variable for I/0
	//execute for loop driver 
	//wont call right i/o
	//arraylist for i/o stored 
	public void IOCall (Process x)
	{
		readyQueue.remove(0);
		x.setProcessState(ProcessState.Run);
		executeQueue.add(x);
		
		
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
	
	

}

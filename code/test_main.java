package os.pg_storage_management;

import java.util.Scanner;

public class test_main {

	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		SeqStack<Memory> stack = new SeqStack<Memory>(3);
		
		PageTable pt = new PageTable(4);
		pt.table[0].setPageNum(1);
		pt.table[0].setModify_bit(0);
		pt.table[0].setAdr(1);
		
		pt.table[1].setPageNum(2);
		pt.table[1].setModify_bit(0);
		pt.table[1].setAdr(2);

		pt.table[2].setPageNum(3);
		pt.table[2].setModify_bit(0);
		pt.table[2].setAdr(3);

		pt.table[3].setPageNum(4);
		pt.table[3].setModify_bit(0);
		pt.table[3].setAdr(4);

		System.out.println("输入任务长度：");
		int n = sc.nextInt();
		int[] tasks = new int[n];
		System.out.println("输入页面走向：");
		for(int i=0;i<n;i++)
			tasks[i] = sc.nextInt();
		sc.close();
		
		PCB pcb = new PCB(pt,tasks);
		pcb.print_Table();
		pcb.print_task_seq();
			
		for(int i=0;i<tasks.length;i++){
			
			SwapZone.alloc(stack,pcb,new Memory(tasks[i],pt.table[tasks[i]-1].getPhyNum(), pt.table[tasks[i]-1]));
			SwapZone.print_stack(stack);
			pcb.print_Table();
			System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

		}
		pcb.end(stack);
		SwapZone.print_stack(stack);
		pcb.print_Table();


		
		
	}
	
	
}

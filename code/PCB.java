package os.pg_storage_management;


public class PCB {
	PageTable pt;
	int[] tasks;

	public PCB(PageTable pt,int tk[]) {
		super();
		this.pt = pt;
		this.tasks = tk;
		
	}
	
	
	public void print_Table(){
		System.out.println("当前页表：");
		System.out.println("页号\t"+" 状态\t"+" 外存地址\t"+"物理块号");
		for(int i=0;i<pt.len;i++){
			System.out.print(i+1+"\t"+pt.table[i].state_bit+"\t");
			if(pt.table[i].state_bit==0){
				System.out.print(pt.table[i].adr+"\t");
				System.out.println("-1");
			}
			else{
				System.out.print("-1"+"\t");
				System.out.println(pt.table[i].phyNum);

			}

		}
		System.out.println("/------------------------------------------------------------/");

		
	}
	
	public void print_task_seq(){
		System.out.print("页面走向：");
		for(int j=0;j<tasks.length;j++)
			System.out.print(tasks[j]+", ");
		System.out.print("\n");
		System.out.println("/------------------------------------------------------------/");
	}
	
	public void end(SeqStack<Memory> stack){
		System.out.println("进程结束,开始回收");
		while(true){
			if(!stack.isEmpty()){
				stack.pop().page.state_bit = 0;
			}
			else{
				break;
			}
		}
	}

}

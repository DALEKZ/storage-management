package os.pg_storage_management;

public class SwapZone {

	public static void alloc( SeqStack<Memory> stack,PCB pcb,Memory my){
		int flag = 0;
		if(stack.isEmpty()){
			System.out.println("物理块空-中断");
			System.out.println("压入"+my.pageNum);
			stack.push(my);
			my.page.phyNum = stack.list.size();
			my.page.state_bit = 1;
			System.out.println("/------------------------------------------------------------/");

			
		}else{
			if(stack.list.size()==3){
				for(int i=0;i<3;i++){
					int re = my.pageNum;
					
					if(re == stack.list.get(i).pageNum){
						flag = 1;
						break;
					}
				}
				
				if(flag==0){
					System.out.println("物理块满-中断");
					int re = deAlloc(stack, my);
					System.out.println("压入"+my.pageNum);
					stack.push(my);
					my.page.state_bit = 1;
					my.page.phyNum = re;

					System.out.println("/------------------------------------------------------------/");

				}else{
					System.out.println(my.pageNum+"在物理块中");

					System.out.println("/------------------------------------------------------------/");

				}
			}else{
				for(int i=0;i<3;i++){
					int re = my.pageNum;
					
					if(re == stack.peek().pageNum){
						flag = 1;
						break;
					}
				}
				if(flag==0){
					System.out.println("物理块未满而未压入-中断");
					System.out.println("压入"+my.pageNum);
					stack.push(my);
					my.page.state_bit = 1;
					my.page.phyNum = stack.list.size();

					System.out.println("/------------------------------------------------------------/");

				}
			}
		}
	
	}
	
	public static int deAlloc(SeqStack<Memory> stack, Memory my){
		System.out.print("页号:");
		Page page = stack.pop_bottom().page;
		page.state_bit = 0;
		int re = page.phyNum;
		page.phyNum = -1;

		System.out.println(page.pageNum+" 被回收");
		return re;

	}
	
	public static void print_stack(SeqStack<Memory> stack){
		System.out.println("物理块分配情况：");
		for(int i =0;i<stack.list.size();i++){
			
			System.out.print(stack.list.get(i).pageNum+"  ;");

		}
		
		System.out.print("\n");
		System.out.println("/------------------------------------------------------------/");



	}
	
	
}

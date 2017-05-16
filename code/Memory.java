package os.pg_storage_management;

public class Memory {
	int pageNum;
	int phyNum;
	Page page;
	public Memory(int pageNum, int phyNum,Page page) {
		this.pageNum = pageNum;
		this.phyNum = phyNum;
		this.page = page;
	}
	
	public Memory(){
		
	}
	
	
}

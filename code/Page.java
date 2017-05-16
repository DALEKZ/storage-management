package os.pg_storage_management;

public class Page {
	public int pageNum;
	public int phyNum;
	public int state_bit;
	public int adr;
	
	public Page(int pageNum, int phyNum, int state_bit, int adr ) {
		this.pageNum = pageNum;
		this.phyNum = phyNum;
		this.state_bit = state_bit;
		this.adr = adr;
	}
	
	public Page(){
		this.pageNum = -1;
		this.phyNum = -1;
		this.state_bit = 0;
		this.adr = -1;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getAdr() {
		return adr;
	}
	
	public void setAdr(int adr) {
		this.adr = adr;
	}
	
	public int getPhyNum() {
		return phyNum;
	}
	
	public void setPhyNum(int phyNum) {
		this.phyNum = phyNum;
	}
	
	public int getModify_bit() {
		return state_bit;
	}
	
	public void setModify_bit(int state_bit) {
		this.state_bit = state_bit;
	}
	
	
}

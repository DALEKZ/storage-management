package os.pg_storage_management;

public class PageTable {
	public Page[] table;
	public int len;
	public PageTable(int len) {
		this.len = len;
		table = new Page[len];
		for(int i=0;i<len;i++)
			table[i] = new Page();
	}
	
	
	
}

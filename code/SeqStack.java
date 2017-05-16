package os.pg_storage_management;


public final class SeqStack<T>{
	public  SeqList<T> list;
	public SeqStack(int length){
		this.list = new SeqList<T>(length);
	}
	
	public SeqStack(){
		this(64);
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.list.isEmpty();
	}

	
	public void push(T x) {
		// TODO Auto-generated method stub
		this.list.insert(x);
	}

	
	public T peek() {
		// TODO Auto-generated method stub
		return this.list.get(list.size()-1);
	}

	
	public T pop() {
		// TODO Auto-generated method stub
		return list.remove(list.size()-1);
	}
	
	public T pop_bottom() {
		// TODO Auto-generated method stub
		return list.remove(0);
	}
	
}

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class LongWrapper {
	
	private Object key = new Object();

	private Long l;
	
	public LongWrapper(Long l){
		this.l = l;
	}
	
	public Long getValue(){
		return l;
	}
	
	public void increamentValue(){
		synchronized (key) {
			l=l+1;
		}
		
	}

}

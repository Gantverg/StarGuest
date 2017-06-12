
public class StarGuest {
	private boolean [][] known;
	private boolean [][] unknown;
	private int count;
	
	public StarGuest(int count) {
		super();
		this.count = count;
		known = new boolean[count][count];
		unknown = new boolean[count][count];
	}
	
	public void setKnown(int who, int whom) {
		set(who, whom, true);
	}
	
	public void setUnKnown(int who, int whom) {
		set(who, whom, false);
	}

	public void set(int i, int j, boolean b) {
		known[i][j] = b;
		unknown[j][i] = !b;
	}
	
	public boolean isStar(int i) {
		for(int index = 1; index < count; index++) {
			if(!known[index][i]){
				return false;
			}
		}
		for(int index = 1; index < count; index++) {
			if(!unknown[index][i]){
				if(i!=index) {
					return false;
				}
			}
		}
		return true;
	}
	
}

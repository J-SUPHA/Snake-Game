
public class xy { //class to carry the x and y coordinates as a single object 
	public int x; // saves space 
	public int y;

	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public boolean equals(xy a) { // done to compare the position of a snake to a pre dtermined position 
		return x == a.x && y == a.y;
	}
}

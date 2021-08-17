import java.util.ArrayList;
public class Body {
 public ArrayList<xy> b = new ArrayList <xy>();//storing the body of the snake, the head is at position 0
 private int direction ; // number between 1-4. 1 is right, 2 is left, 3 is up and 4 is down  
 
 public Body() {
	 direction = 1;//the snake starts off by moving right 
	 b.add(new xy(0,0));// it starts at position 0. x coordinate of 0 and y coordinate of 0
 }
 
 public int getDirection() {
	 return direction; // reference direction
}
 public void setDirection(int a) {
	 direction = a;// setting direction base on user input
 }
 
	public void shift() {
		for (int i = b.size() - 1; i > 0; i--) { // for loop moves from back to front in order to move the snake forward (each cell is moved forward from the back) 
			b.set(i, b.get(i - 1));
		}
		switch(direction) {
		case 1: b.set(0, new xy(b.get(0).x + 1, b.get(0).y)); break;//switch statement to refer to snake movement 
		case 2: b.set(0, new xy(b.get(0).x - 1, b.get(0).y)); break;
		case 3: b.set(0, new xy(b.get(0).x, b.get(0).y + 1)); break;
		case 4: b.set(0, new xy(b.get(0).x, b.get(0).y - 1)); break;
		} 
	}
	
	public ArrayList<xy> getSnake() {
		return b;//return the snake ArrayList
	}
	
	public boolean Head(xy a) {
		return b.get(0).equals(a); //comparing head to any other point on the graph 
	}
	
	public boolean GG(int xlim, int ylim) { //pass size of the grid
		int X = b.get(0).x;//getting the separate x and y coordinates
		int Y = b.get(0).y;
		if (X > xlim || X < 0 || Y > ylim || Y < 0) {
			if (X > xlim) b.set(0, new xy(xlim, b.get(0).y));//if the snake is too far right 
			if (X < 0) b.set(0, new xy(0, b.get(0).y));//if the snake is too far left
			if (Y > ylim) b.set(0, new xy(b.get(0).x, ylim));// if the snake is too high
			if (Y < 0) b.set(0, new xy(b.get(0).x, 0));// if the snake is to low
			return true;
		}
		for (int i = 1; i < b.size(); i++) {
			if (Head(b.get(i))) { return true;}
		}
		return false;
	}
	public void Longr(int amount) { //snake extender when it hits the apple 
		for (int i = 0; i < amount; i++) {
			b.add(b.get(b.size() - 1));//
		}
	}
}
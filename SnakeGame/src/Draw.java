import java.awt.Color;
import java.util.ArrayList;

public class Draw {
	
	private void Grid() {
		StdDraw.setPenColor(30, 55, 0); //color of the grid lines
		for (double x = 0.5; x < 25; x++) { //nested for loop to draw square of square to fill the space
			for (double y = 0.5; y < 25; y++) {
				StdDraw.square(x / 25.0, y / 25.0, 1/50.0);//
			}
		}
	}
	public void draw(ArrayList<xy> snake, xy apple) {
		StdDraw.clear(new Color(10, 10, 10)); //background paint 
		StdDraw.setPenColor(2, 255, 2); // painting the head a different color 
		xy a = snake.get(0);
		StdDraw.filledSquare((a.x+0.5) / 25.0, (a.y + 0.5) / 25.0, 1 / 50.0); //filling the head 
		StdDraw.setPenColor(2, 2, 255); // painting the body 
		for (int i = 1; i < snake.size(); i++) { // color each segment of the snake 
			xy b = snake.get(i);
			StdDraw.filledSquare((b.x+0.5) / 25.0, (b.y + 0.5) / 25.0, 1 / 50.0); 
		}
		StdDraw.setPenColor(255, 2, 2); //choosing color 
		StdDraw.filledSquare((apple.x + 0.5) / 25.0, (apple.y + 0.5) / 25.0, 1 / 50.0);//filling the apple with color
		Grid();//implementing Grid lines
		StdDraw.show(); //show each canvas once made 
	}
}


public class Game {
	public static void main(String[] args) {
		while(new Game().start());
		System.exit(0);
	
		}
	
	private xy randomBlock() {
		int x = 0;
		int y = 0;
			x = (int) (Math.random() * 25);//30 unit area therefore apple must be in the range of 30x30 units 
			y = (int) (Math.random() * 25);
		return new xy(x, y); //returns xy position coordinates of of apple new location
}
	public boolean start() {
		Body snake = new Body();//initializing body size of one unit
		Draw draw = new Draw();// initializing sketching class
		xy apple = randomBlock();// setting the first apple location
		int speed = 0; // making sure there is a delay between canvas refresh
		boolean on = true;//keep the game going 
		while(on) {	
			StdDraw.enableDoubleBuffering();//enable double buffering 
			if (StdDraw.isKeyPressed(39) && snake.getDirection()!=2)// if opposite key if selected snake does not change direction
			{ snake.setDirection(1);} //right
			if (StdDraw.isKeyPressed(37) && snake.getDirection()!=1)// instead snake will keep moving in the direction that it was previously moving in
			{snake.setDirection(2);} //left 
			if (StdDraw.isKeyPressed(38) && snake.getDirection()!=4)
			{snake.setDirection(3);} //up
			if (StdDraw.isKeyPressed(40) && snake.getDirection()!=3)
			{snake.setDirection(4);} //down
			draw.draw(snake.getSnake(), apple); //redrawing 
			if (speed == 4) { //5 loop delay, arbitrary number that can be changed accordingly
				speed = 0;
				snake.shift();//moving the snake 
				if (snake.GG(25,25)) on = false;
				if (snake.Head(apple)) {
					snake.Longr(2);// extension by 2 units 
					apple = randomBlock();// picking a new spot for the apple
				}
				}
			speed++;
		}
		return false;

	}


	}

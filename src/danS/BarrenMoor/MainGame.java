package danS.BarrenMoor;

public class MainGame {

	public static void main(String[] args) {
		
		//create object of main game class
		GameLoop mainLoop = new GameLoop();
		mainLoop.intro();
		mainLoop.getInformation();
		mainLoop.gameLoop();
		
	}
}

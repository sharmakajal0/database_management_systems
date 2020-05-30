public class Football extends Game{
	@Override
	void endPlay(){
		System.out.println("End the game now");
	}

	@Override
	void initialize(){
		System.out.println("Football game has been initialized. Start the game");
	}

	@Override
	void startPlay(){
		System.out.println("Start the game now.");
	}
}

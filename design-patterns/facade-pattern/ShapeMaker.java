public class ShapeMaker{
	private Shape circle;
	private Shape square;
	private Shape rectangle;

	public ShapeMaker(){
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle(){
		circle.draw();
	}

	public void drawSquare(){
		square.draw();
	}

	public void drawRectangle(){
		rectangle.draw();
	}
}


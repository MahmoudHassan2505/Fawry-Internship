package Facade;

public class FacadeShape {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public FacadeShape(){
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawCircle(){
        circle.Draw();
    }

    public void drawSquare(){
        square.Draw();
    }

    public void drawRectangle(){
        rectangle.Draw();
    }


}

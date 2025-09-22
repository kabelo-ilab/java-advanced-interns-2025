package Chapter7.inheritance;

public class MyShapeRunner {
    public static void main(String[] args) {
        MyShape objShape = new MyShape(5,6);
        objShape.display("Shape");

        MyRectangle objRec = new MyRectangle(9,4);
        objRec.display("Rectangle");

        MySquare objSq = new MySquare(6);
        objSq.display("Square");

        MyCircle objCircle = new MyCircle(25);
        objCircle.display("Circle");

        MyTriangle objTriangle = new MyTriangle(25,15);
        objTriangle.display("Triangle");
    }
}

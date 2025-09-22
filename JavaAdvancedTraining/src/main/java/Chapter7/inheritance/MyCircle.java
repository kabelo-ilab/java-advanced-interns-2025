package Chapter7.inheritance;

public class MyCircle extends MyShape{
    public MyCircle(int radius){
        super(0,radius);
    }

    @Override
    public double calcArea(){
        return Math.PI * (this.width * this.width);
    }
    @Override
    public void display(String shape){
        System.out.println("\n======== " + shape + " ========");
        System.out.println("Radius: " + this.width);
        System.out.println("Area: " + this.calcArea());
    }
}

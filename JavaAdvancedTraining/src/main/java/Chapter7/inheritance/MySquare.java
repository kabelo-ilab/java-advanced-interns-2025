package Chapter7.inheritance;

public class MySquare extends MyShape {

    public MySquare(int side) {
        super(side,0);
    }

    @Override
    public double calcArea(){
        return this.length * this.length;
    }

    @Override
    public void display(String shape){
        System.out.println("\n======== " + shape + " ========");
        System.out.println("Side: " + this.length);
        System.out.println("Area: " + this.calcArea());
    }
}

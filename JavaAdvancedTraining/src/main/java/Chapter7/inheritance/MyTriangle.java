package Chapter7.inheritance;

public class MyTriangle extends MyShape{


    public MyTriangle(int base, int height) {
        super(base, height);
    }
    @Override
    public double calcArea(){
        return (this.length * 0.5) * this.width;
    }

    @Override
    public void display(String shape){
        System.out.println("\n======== " + shape + " ========");
        System.out.println("Base: " + this.length);
        System.out.println("Height: " + this.width);
        System.out.println("Area: " + this.calcArea());
    }
}

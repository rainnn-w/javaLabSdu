package ex09;

abstract public class Shape {
    protected double side1;
    protected double side2;
    protected double square;
    protected double length;

    public Shape(){}
    public Shape(double side1,double side2){
        this.side1=side1;
        this.side2=side2;
    }

    public abstract double square();
    public abstract double length();
}

class Rectangle extends Shape{

    public void setWidth(double width){
        this.side1=width;
    }
    public void setHeight(double height){
        this.side2=height;
    }
    public Rectangle(double side1,double side2) {super(side1,side2);}

    @Override
    public double square() {
        square=side1*side2;
        return square;
    }

    @Override
    public double length() {
        length=(side1+side2)*2;
        return length;
    }
}

class Square extends Rectangle{

    public Square(double side) {super(side,side);}

    @Override
    public double square() {
        square=side1*side2;
        return square;
    }

    @Override
    public double length() {
        length=(side1+side2)*2;
        return length;
    }
}

class Diamond extends Shape{

    public Diamond(double diagonal1,double diagonal2){super(diagonal1,diagonal2);}

    @Override
    public double square() {
        square=side1*side2/2;
        return square;
    }

    @Override
    public double length() {
        length=2*(Math.sqrt(side1*side1+side2*side2));
        return length;
    }
}

class Circle extends Shape{

    public Circle(double r) {
        super(r,r);
    }

    @Override
    public double square() {
        square=Math.PI*side1*side1;
        return square;
    }

    @Override
    public double length() {
        length=2*Math.PI*side1;
        return length;
    }

}

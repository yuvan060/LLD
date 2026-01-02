package behavioural.Visitor;

public class Square implements Shape{
    @Override
    public Double calculateArea(ShapeVisitor visitor) {
        return visitor.calculateSquareArea(this);
    }
}

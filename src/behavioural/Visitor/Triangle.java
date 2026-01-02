package behavioural.Visitor;

public class Triangle implements Shape{

    @Override
    public Double calculateArea(ShapeVisitor visitor) {
        return visitor.calculateTriangleArea(this);
    }
}

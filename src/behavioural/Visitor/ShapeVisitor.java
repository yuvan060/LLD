package behavioural.Visitor;

public interface ShapeVisitor {
    public Double calculateSquareArea(Square s);
    public Double calculateTriangleArea(Triangle t);
}

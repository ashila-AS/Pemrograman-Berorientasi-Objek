public class TestShape {
    public static void main(String[] args) {

        System.out.println("=== Shape ===");
        Shape s1 = new Shape();
        System.out.println(s1);
        s1.setColor("blue");
        s1.setFilled(false);
        System.out.println("color=" + s1.getColor() + " filled=" + s1.isFilled());
        System.out.println(s1);

        Shape s2 = new Shape("green", true);
        System.out.println(s2);

        System.out.println("\n=== Circle ===");
        Circle c1 = new Circle();
        System.out.println(c1);
        Circle c2 = new Circle(2.5);
        System.out.println(c2);
        Circle c3 = new Circle(3.0, "yellow", false);
        System.out.println(c3);
        c3.setRadius(4.0);
        System.out.println("radius=" + c3.getRadius()
            + " area=" + c3.getArea()
            + " perimeter=" + c3.getPerimeter());

        System.out.println("\n=== Rectangle ===");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        Rectangle r2 = new Rectangle(2.0, 3.0);
        System.out.println(r2);
        Rectangle r3 = new Rectangle(4.0, 5.0, "purple", false);
        System.out.println(r3);
        r3.setWidth(6.0);
        r3.setLength(7.0);
        System.out.println("width=" + r3.getWidth() + " length=" + r3.getLength()
            + " area=" + r3.getArea()
            + " perimeter=" + r3.getPerimeter());

        System.out.println("\n=== Square ===");
        Square sq1 = new Square();
        System.out.println(sq1);
        Square sq2 = new Square(5.0);
        System.out.println(sq2);
        Square sq3 = new Square(3.0, "orange", true);
        System.out.println(sq3);

        sq3.setSide(4.0);
        System.out.println("setSide(4)   -> " + sq3);
        sq3.setWidth(6.0);
        System.out.println("setWidth(6)  -> " + sq3);
        sq3.setLength(8.0);
        System.out.println("setLength(8) -> " + sq3);
        System.out.println("side=" + sq3.getSide()
            + " area=" + sq3.getArea()
            + " perimeter=" + sq3.getPerimeter());
    }
}

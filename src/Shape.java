public interface Shape {
    void calculateSquare();
    void calculatePerimeter();
    double getSquare();
    double getPerimeter();
}

abstract class Form implements Shape {
    protected String name;
    protected double square;
    protected double perimeter;
    protected String backgroundColor;
    protected String borderColor;

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setBackgroundColor(String color) {
        this.backgroundColor = color;
    }

    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    public abstract void calculateSquare();

    public abstract void calculatePerimeter();

    public String toString() {
        return name + "Square = " + square + ", Perimeter = " + perimeter + ", цвет фона = " + backgroundColor
                + ", цвет границы= " + borderColor;
    }

    static class Circle extends Form {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
            calculateSquare();
            calculatePerimeter();
        }

        @Override
        public void calculateSquare() {
            this.square = Math.PI * Math.pow(radius, 2);
        }

        @Override
        public void calculatePerimeter() {
            this.perimeter = 2 * Math.PI * radius;
        }

    }

    static class Rect extends Form {
        private double a;
        private double b;

        public Rect(double a, double b) {
            this.a = a;
            this.b = b;
            calculateSquare();
            calculatePerimeter();
        }

        @Override
        public void calculateSquare() {
            this.square = a * b;
        }

        @Override
        public void calculatePerimeter() {
            this.perimeter = 2 * (a + b);
        }
    }

    static class Triangle extends Form {
        private double a;
        private double b;
        private double h;

        public Triangle(double a, double b, double h) {
            this.a = a;
            this.b = b;
            this.h = h;
            calculateSquare();
            calculatePerimeter();
        }

        @Override
        public void calculateSquare() {
            this.square = (a * h) / 2;
        }

        @Override
        public void calculatePerimeter() {
            this.perimeter = a + b + h;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Circle circle = new Circle(5);
            circle.name = "Параметры круга:";
            circle.setBackgroundColor("синий");
            circle.setBorderColor("желтый");
            Rect rect = new Rect(5, 10);
            rect.name = "Параметры прямоугольника:";
            rect.setBackgroundColor("красный");
            rect.setBorderColor("зеленый");
            Triangle triangle = new Triangle(5, 10, 15);
            triangle.name = "Параметры треугольника:";
            triangle.setBackgroundColor("оранжевый");
            triangle.setBorderColor("фиолетовый");

            System.out.println(triangle.toString());
            System.out.println(rect.toString());
            System.out.println(circle.toString());
        }
    }
}

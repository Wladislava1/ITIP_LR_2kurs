package LR2;

abstract class GeometricFigure {

    protected String name;
    protected String color;
    protected double volume;
    public static void main(String[] args) {

        Sphere sphere = new Sphere("Red", 5);
        sphere.calculateVolume();
        sphere.displayInfo();

        Parallelepiped parallelepiped = new Parallelepiped("Blue", 2, 3, 4);
        parallelepiped.calculateVolume();
        parallelepiped.displayInfo();

        Cylinder cylinder = new Cylinder("Green", 3, 7);
        cylinder.calculateVolume();
        cylinder.displayInfo();

        System.out.println("Общее количество созданных сфер:" + Sphere.getSphereCount());
    }

    public GeometricFigure() {
        this.name = "Unknown Figure";
        this.color = "No color";
        this.volume = 0.0;
    }


    public GeometricFigure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public abstract void calculateVolume();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getVolume() {
        return volume;
    }

    public void displayInfo() {
        System.out.println("Figure: " + name + ", Color: " + color + ", Volume: " + volume);
    }
}


class Sphere extends GeometricFigure {
    private double radius; 
    private static int sphereCount = 0; 

    public Sphere() {
        super("Sphere", "No color");
        this.radius = 0.0;
        sphereCount++;
    }

    public Sphere(String color, double radius) {
        super("Sphere", color);
        this.radius = radius;
        sphereCount++;
    }

    @Override
    public void calculateVolume() {
        this.volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getSphereCount() {
        return sphereCount;
    }
}


class Parallelepiped extends GeometricFigure {
    private double length, width, height;

    public Parallelepiped() {
        super("Parallelepiped", "No color");
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    public Parallelepiped(String color, double length, double width, double height) {
        super("Parallelepiped", color);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public void calculateVolume() {
        this.volume = length * width * height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Cylinder extends GeometricFigure {
    private double radius, height; 

    public Cylinder() {
        super("Cylinder", "No color");
        this.radius = 0.0;
        this.height = 0.0;
    }

    public Cylinder(String color, double radius, double height) {
        super("Cylinder", color);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public void calculateVolume() {
        this.volume = Math.PI * Math.pow(radius, 2) * height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}




package solidprinciple;

class Rectangle {
	protected double width;
	protected double height;

	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}

	public double area() {
		return width * height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setHeight(double h) {
		height = h;
	}
}

class Square extends Rectangle {
	public Square(double size) {
		super(size, size);
	}

	public void setWidth(double w) {
		width = height = w;
	}

	public void setHeight(double h) {
		height = width = h;
	}
}

public class LiskovSubstituationPrinciple {

	public static void main(String[] args) {

		Square s = new Square(5);
		s.setWidth(10);

		System.out.println("Area: " + s.area());

	}

}

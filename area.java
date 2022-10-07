import java.util.Scanner;

public class AreaCalculator {

	public static void main(String[] args) {
		System.out.println("Shape Area Calculator V1.0");
		Scanner input = new Scanner(System.in);
		double option = 0;
		do {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println();
			System.out.println("1) Triangle");
			System.out.println("2) Rectangle");
			System.out.println("3) Square");
			System.out.println("4) Circle");
			System.out.println("5) Quit");
			System.out.print("Which shape: ");
			option = input.nextInt();
			input.nextLine(); // Clear Keyboard
			if (option == 1) {
				System.out.println("You selected Triangle Area Calculation.");
				System.out.println("Now continue with Area Calculation Logic");
				System.out.println("...");
				System.out.print("Please enter Triangle Base Length: ");
				double base = input.nextInt();
				System.out.print("Please enter Triangle Height: ");
				double height = input.nextInt();
				double area = area_triangle(base, height);
				System.out.println("Based on the values entered, the Triangle has an area of " + area);
			} else if (option == 2) {
				System.out.println("You selected Rectangle Area Calculation.");
				System.out.println("Now continue with Area Calculation Logic");
				System.out.println("...");
				System.out.print("Please enter Rectangle Length: ");
				double length = input.nextInt();
				System.out.print("Please enter Rectangle Width: ");
				double width = input.nextInt();
				double area = area_rectangle(length, width);
				System.out.println("Based on the values entered, the Rectangle has an area of " + area);
			} else if (option == 3) {
				System.out.println("You selected Square Area Calculation.");
				System.out.println("Now continue with Area Calculation Logic");
				System.out.println("...");
				System.out.print("Please enter Square Side Length: ");
				double side = input.nextInt();
				double area = area_square(side);
				System.out.println("Based on the value entered, the Square has an area of " + area);
			} else if (option == 4) {
				System.out.println("You selected Circle Area Calculation.");
				System.out.println("Now continue with Area Calculation Logic");
				System.out.println("...");
				System.out.print("Please enter Circle Radius: ");
				double radius = input.nextInt();
				double area = area_circle(radius);
				System.out.println("Based on the values entered, the Circle has an area of " + area);

			} else if (option != 5) {
				System.out.println("Illegal Option");
			}
		} while (option != 5);
		input.close();
	}

	private static double area_circle(double radius) {
		return Math.PI * (radius * radius);
	}

	private static double area_square(double side) {
		return side * side;
	}

	private static double area_rectangle(double length, double width) {
		return length * width;
	}

	private static double area_triangle(double base, double height) {
		return .5 * base * height;
	}

}

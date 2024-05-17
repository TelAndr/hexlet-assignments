package exercise;

// BEGIN
public class App {
	public static void printSquare(Circle curCircle) {
		try {
			System.out.print(Math.round(curCircle.getSquare())); //transferMoney(inputCard, outputCard, value);
		} catch (NegativeRadiusException e) {
			System.out.print("Не удалось посчитать площадь");
		}
		System.out.print("\nВычисление окончено");
	}
}
// END

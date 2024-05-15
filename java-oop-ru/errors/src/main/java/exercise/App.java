package exercise;

// BEGIN
public class App {
	public static void printSquare(Circle curCircle) {
		try {
			System.out.println(curCircle.getSquare()); //transferMoney(inputCard, outputCard, value);
		} catch (NegativeRadiusException e) {
			System.out.println("Не удалось посчитать площадь");
		}
		System.out.println("Вычисление окончено");
	}
}
// END

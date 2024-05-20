package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;
public class Validator {
	public static List<String> validate(Address address) {
		//Field[] fields = address.getClass().getDeclaredFields();
		//for (Field field : fields) {
		//	System.out.println(field);
		//}
		List<String> nameFieldsNotValidate = new ArrayList<>();
		for (Field field : address.getClass().getDeclaredFields()) {
			RandomNumber randomNumber = field.getAnnotation(NotNull);
			if (randomNumber == null) {
				nameFieldsNotValidate.add(field);
				//Random random = new Random();
				//int randomValue = random.nextInt(randomNumber.max() - randomNumber.min() + 1) + randomNumber.min();
				//try {
				//	field.setAccessible(true);
				//	field.set(user3, String.valueOf(randomValue));
				//} catch (IllegalAccessException e) {
				//	e.printStackTrace();
				//}
			}
		}
		return nameFieldsNotValidate;
	}
}
// END

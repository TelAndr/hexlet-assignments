package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import java.util.Random;
public class Validator {
	public static List<String> validate(Address address) {
		List<String> nameFieldsNotValidate = new ArrayList<>();
		for (Field field : address.getClass().getDeclaredFields()) {
			NotNull notNull = field.getAnnotation(NotNull.class);
			if (field.isAnnotationPresent(NotNull.class) && field.getName() == null) {
			//if (notNull == null && field.getName() == null) {
				nameFieldsNotValidate.add(field.getName());
			}
		}
		return nameFieldsNotValidate;
	}
}
// END

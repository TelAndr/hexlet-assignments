package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import java.util.Random;
/*public class Validator {
	//public static List<String> validate(Address address) {
	public static List<String> validate(Object instance) {
		List<String> nameFieldsNotValidate = new ArrayList<>();
		Field[] fields = instance.getClass().getDeclaredFields();
		//for (Field field : address.getClass().getDeclaredFields()) {
		for (Field field : fields) {
			//NotNull notNull = field.getAnnotation(NotNull.class);
			//if (field.isAnnotationPresent(NotNull.class) && field.getName() == null) {
			////if (notNull == null && field.getName() == null) {
			//	nameFieldsNotValidate.add(field.getName());
			if (field.isAnnotationPresent(NotNull.class)) {
				Object value;
				try {
					field.setAccessible(true);
					value = field.get(instance);
					field.setAccessible(false);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				if (value == null) {
					nameFieldsNotValidate.add(field.getName());
				}
			}
		}
		return nameFieldsNotValidate;
	}
} */
public class Validator {
    public static List<String> validate(Object instance) {
        List<String> nameFieldsNotValidate = new ArrayList<>();
        Field[] fields = instance.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(NotNull.class)) {
				Object value;
				try {
					field.setAccessible(true);
					value = field.get(instance);
					field.setAccessible(false);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				if (value == null) {
					nameFieldsNotValidate.add(field.getName());
				}
			}
		}

    return nameFieldsNotValidate;
	}
}
// END

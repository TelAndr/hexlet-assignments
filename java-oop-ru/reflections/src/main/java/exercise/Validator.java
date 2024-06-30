package exercise;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {
	public static List<String> validate(Address address) {
		Class<Address> addressClass = Address.class;
		Field[] fields = addressClass.getDeclaredFields();
		List<String> list = new ArrayList<>();
		for (var field : fields) {
			if (field.isAnnotationPresent(NotNull.class)) {
				field.setAccessible(true);
				Object value = null;
				try {
					value = field.get(address);
				} catch (IllegalAccessException e) {
					System.err.println("Ошибка доступа к полю: " + field.getName() + ": " + e.getMessage());
				}
				if (value == null) {
					String fieldName = field.getName();
					list.add(fieldName);
				}
				field.setAccessible(false);
			}
		}
		return list;
	}
}
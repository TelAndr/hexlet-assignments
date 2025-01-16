package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        // Итерируем все методы класса
        for (Method method : address.getClass().getMethods()) {

            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {
                var returnedType = method.getReturnType().getSimpleName();
                System.out.printf("Method %s returns a value of type %s%n",
                        method.getName(), returnedType);
                //try {
                    // Выполняем метод с аннотацией Inspect
                //    method.invoke(address);
                //} catch (Exception e) {
                //    e.printStackTrace();
                //}

                //

                //System.out.println("Executed method: " + method.getName());
                //System.out.println("Execution time: " + executionTime + " milliseconds");
            }
        }
        // END
    }
}

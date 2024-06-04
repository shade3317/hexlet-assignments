package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[]      fields = address.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();

        for (var field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(address) == null && field.isAnnotationPresent(NotNull.class)) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[]                   fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> result = new HashMap<>();

        for (var field : fields) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    errors.add("can not be null");
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    var value     = (String) field.get(address);
                    var minLength = field.getAnnotation(MinLength.class).minLength();

                    if (minLength > String.valueOf(value).length()) {
                        errors.add("length less than " + minLength);
                    }
                }
                if (!errors.isEmpty()) {
                    result.put(field.getName(), errors);
                }
            } catch (IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
        }
        return result;
    }
}
// END

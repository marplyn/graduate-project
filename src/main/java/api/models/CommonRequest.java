package api.models;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;
import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;
import static org.apache.commons.lang3.reflect.FieldUtils.getFieldsListWithAnnotation;
import static org.assertj.core.api.Fail.fail;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class CommonRequest {

    public Map<String, Object> getQueryParams() {
        return !this.getClass().equals(CommonRequest.class)
                ? getFieldsMap(null)
                : Collections.emptyMap();
    }

    private Map<String, Object> getFieldsMap(Class<? extends Annotation> annotationClass) {
        List<Field> fields = getFields(annotationClass);
        Map<String, Object> fieldsMap = new HashMap<>();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();

            if ((isPrimitiveOrWrapper(fieldType) || fieldType.equals(Object.class) || fieldType.equals(String.class))) {
                String name = getFieldName(field, annotationClass);
                Object value = getFieldValue(field);
                fieldsMap.put(name, value);
            }
        }
        return Maps.filterValues(fieldsMap, Objects::nonNull);
    }

    private List<Field> getFields(Class<? extends Annotation> annotationClass) {
        List<Field> fields;
        Class<? extends CommonRequest> requestClass = this.getClass();

        if (nonNull(annotationClass)) {
            fields = getFieldsListWithAnnotation(requestClass, annotationClass);
        } else {
            fields = getAllFieldsList(requestClass);
            ArrayList<Field> fieldsWithoutAnnotations = getFieldsWithoutAnnotations(fields);
            fields.retainAll(fieldsWithoutAnnotations);
        }
        return fields;
    }

    private ArrayList<Field> getFieldsWithoutAnnotations(List<Field> fields) {
        ArrayList<Field> fieldsWithoutAnnotations = new ArrayList<>();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();

            if (annotations.length == 0) {
                fieldsWithoutAnnotations.add(field);
            }
        }
        return fieldsWithoutAnnotations;
    }

    private String getFieldName(Field field, Class<? extends Annotation> annotationClass) {
        String name = "'";

        if (nonNull(annotationClass)) {
            Annotation annotation = field.getAnnotation(annotationClass);
            Class<? extends Annotation> type = annotation.annotationType();
            Map<String, Method> declaredMethods = Arrays.stream(type.getDeclaredMethods())
                    .collect(Collectors.toMap(Method::getName, Function.identity()));

            if (declaredMethods.containsKey("name")) {
                Method method = declaredMethods.get("name");
                try {
                    name = (String) method.invoke(annotation);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return name.isEmpty() ? field.getName() : name;
    }

    private Object getFieldValue(Field field) {
        try {
            return field.get(this);
        } catch (IllegalAccessException e) {
            fail(String.format("No access: failed to get the value of [%s] from %s.", field.getName(), this.getClass()));
        }
        return null;
    }
}
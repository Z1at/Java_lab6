package NikandrovLab5.data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Source class
 */
public class Human implements Serializable {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Double height; //Значение поля должно быть больше 0
    private final java.time.LocalDate birthday;

    public Human(String name, Double height, LocalDate date) {
        this.name = name;
        this.height = height;
        this.birthday = date;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}

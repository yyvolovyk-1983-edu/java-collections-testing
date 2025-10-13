import java.util.HashSet;                         // Імпорт класу HashSet
import java.util.Objects;                         // Імпорт класу Objects для equals/hashCode
import java.util.Set;                            // Імпорт інтерфейсу Set

public class Main {                               // Основний клас
    public static void main(String[] args) {      // Точка входу
        Set<User> set = new HashSet<>();         // Створюємо HashSet для User
        set.add(new User("Max", 12));             // Додаємо перший об'єкт
        set.add(new User("Max", 12));            // Додаємо другий (з такими ж даними)
        set.add(new User("Max", 12));            // Додаємо третій
        set.add(new User("Max", 12));            // Додаємо четвертий

        if (set.size() == 1) {                    // Якщо в множині лише 1 унікальний елемент
            System.out.println("Passed!");       // Виводимо Passed!
        } else {
            System.out.println("Failed!");       // Інакше Failed!
        }
    }

    static class User {                            // Внутрішній клас User
        String name;                               // Ім'я користувача
        int age;                                  // Вік користувача

        public User(String name, int age) {        // Конструктор
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {         // Перевизначення equals
            if (this == o) return true;           // Якщо це той самий об'єкт — true
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&           // Порівнюємо поля age
                    Objects.equals(name, user.name); // user name
        }

        @Override
        public int hashCode() {                 // Перевизначення hashCode
            return Objects.hash(name, age);     // Формуємо хеш на основі полів
        }
    }
}

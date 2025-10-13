Третє практичне завдання: Проаналізуйте код і те що він буде виводити на екран. Чому так відбувається?
Failed!


Причина: кожен new User("Max", 12) — це різний об’єкт у пам’яті, а HashSet вважає їх різними, бо в класі User не перевизначено equals() і hashCode().
Отже, set.size() = 4, а не 1.
 Щоб було Passed! — потрібно перевизначити equals() і hashCode() у User, щоб об’єкти з

 
 import java.util.Set;                       // Імпорт інтерфейсу Set
public class Main {                         // Оголошення основного класу
    public static void main(String[] args) { // Точка входу в програму
        Set<User> set = new HashSet<>();     // Створюємо HashSet для об'єктів User
        set.add(new User("Max", 12));        // Додаємо перший об'єкт
        set.add(new User("Max", 12));        // Додаємо другий (такий самий) об'єкт
        set.add(new User("Max", 12));        // Додаємо третій об'єкт
        set.add(new User("Max", 12));        // Додаємо четвертий об'єкт

        if (set.size() == 1) {               // Перевіряємо розмір множини
            System.out.println("Passed!");   // Якщо 1 — друкуємо Passed!
        } else {
            System.out.println("Failed!");   // Інакше — Failed!
        }
    }

    static class User {                      // Внутрішній клас User
        String name;                         // Поле ім'я
        int age;                             // Поле вік

        public User(String name, int age) {   // Конструктор
            this.name = name;
            this.age = age;
        }
    }
}

висновок : клас User не має equals() і hashCode().
HashSet бачить 4 різні об’єкти → size = 4 — Failed!



Як виправити : 






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

Код спочатку виводив Failed!, бо HashSet вважав усі 4 об’єкти різними — не було перевизначених equals() і hashCode().
Після їх додавання однакові об’єкти розпізнаються як один, set.size() = 1 → Passed!.


<div align="center">

# Java Collections Testing

**HashSet та контракт equals/hashCode — практична демонстрація**

[![Java](https://img.shields.io/badge/Java_17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://github.com/yyvolovyk-1983-edu/java-collections-testing)
[![JUnit](https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://github.com/yyvolovyk-1983-edu/java-collections-testing)

</div>

---

## Ключова ідея

`HashSet` визначає унікальність елементів через `equals()` та `hashCode()`.
Без їх перевизначення — однакові об'єкти вважаються різними.

---

## Реалізація

```java
static class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User u)) return false;
        return age == u.age && name.equals(u.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

## Тест

```java
HashSet<User> set = new HashSet<>();
set.add(new User("Max", 12));
set.add(new User("Max", 12));
set.add(new User("Max", 12));
set.add(new User("Max", 12));

if (set.size() == 1) System.out.println("Passed!");
else                 System.out.println("Failed!");
```

---

## Порівняння поведінки

| Ситуація | hashCode | equals | Розмір HashSet |
|---|---|---|---|
| Без перевизначення | різний (адреса) | == (адреса) | 4 — всі "різні" |
| З перевизначенням | однаковий | за полями | 1 — дублікати прибрані |

---

## Правило

> Якщо перевизначаєш `equals()` — **завжди** перевизначай `hashCode()`.

---

## Roadmap

- [x] HashSet — equals/hashCode контракт
- [ ] HashMap — ключі та колізії
- [ ] LinkedHashSet — порядок вставки
- [ ] TreeSet — сортування через Comparable/Comparator

---

## Запуск

```bash
mvn test
```

---

<div align="center">

**Автор:** [Євген Воловик](https://github.com/yyvolovyk-1983-edu) · Харків, Україна
📧 y.y.volovyk@student.khai.edu · [LinkedIn](https://www.linkedin.com/in/yevhen-volovyk/)

</div>
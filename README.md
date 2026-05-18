# Java Selenium Web Testing — Лабораторні роботи

> Автоматизоване тестування веб-застосунків на Java з використанням Selenium WebDriver.

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://openjdk.org)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=flat&logo=selenium&logoColor=white)](https://selenium.dev)

## Зміст

Серія практичних завдань з автоматизованого тестування:

| Репо | Тема |
|------|------|
| `java-selenium-basics` | Базові Selenium тести, локатори елементів |
| `java-selenium-pageobject` | PageObject паттерн, тест-сюіти |
| `java-collections-testing` | Java Collections — аналіз HashSet/equals/hashCode |

## Лаб 1.3 — HashSet та equals()/hashCode()

Демонструє критичну помилку при роботі з колекціями Java:

```java
// Без перевизначення equals/hashCode — HashSet вважає об'єкти різними
Set<User> set = new HashSet<>();
set.add(new User("John", 25));
set.add(new User("John", 25)); // дублікат — але set.size() == 2!

// Після правильного перевизначення:
// set.size() == 1 → "Passed!"
```

**Урок:** Завжди перевизначай `equals()` та `hashCode()` для об'єктів у колекціях.

## Технологічний стек

- Java 17+
- Selenium WebDriver 4.x
- JUnit 5
- Maven / Gradle

## Запуск

```bash
mvn test
# або
gradle test
```

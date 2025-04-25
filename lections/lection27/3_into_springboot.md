## 🔹 3. Введение в Spring Boot

---

### 🚀 Что такое Spring Boot

**Spring Boot** — это фреймворк на базе Spring, который:
- Упрощает настройку и запуск приложений
- Позволяет **запустить готовое приложение одной строкой** (`main` метод)
- Убирает необходимость XML-конфигурации
- Включает встроенные серверы (`Tomcat`, `Jetty`, `Undertow`)

---

### 🎯 Зачем он нужен

- **Быстрый старт** (вместо недели настройки — проект за 5 минут)
- **Автоконфигурация** (`Spring Boot` сам подключает всё нужное на основе зависимостей)
- **Starter-зависимости** — один `starter` вместо 5+ библиотек
- **Встроенный HTTP-сервер** — не нужно деплоить `.war` в Tomcat
- Легко создавать REST API и микросервисы

---

### 📁 Структура проекта Spring Boot

```
src/
└── main/
    ├── java/
    │   └── com/example/demo/
    │       └── DemoApplication.java      <-- главный класс
    │       └── controllers/              <-- контроллеры
    │       └── services/                 <-- бизнес-логика
    └── resources/
        ├── application.properties        <-- конфигурация
        ├── static/                       <-- css, js, картинки
        └── templates/                    <-- HTML-шаблоны (Thymeleaf)
```

---

### ⚙️ pom.xml — зависимости

#### Минимальный набор для REST API:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

#### Для Thymeleaf:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

---

### 🧾 application.properties

```properties
server.port=8081
spring.application.name=demo-api
```

Можно задать: порт, логгинг, время жизни сессии, параметры БД и многое другое.

---

### 🧠 Важные аннотации

| Аннотация                | Назначение                                      |
|--------------------------|--------------------------------------------------|
| `@SpringBootApplication` | Главный класс, объединяет: `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan` |
| `@RestController`        | Класс, который обрабатывает HTTP-запросы и возвращает JSON |
| `@GetMapping`, `@PostMapping` | Обработка GET и POST запросов по URI |
| `@RequestBody`           | Считывает JSON-тело запроса и мапит в объект    |
| `@RequestParam`, `@PathVariable` | Параметры из строки запроса или URI        |

---

### 📌 Пример простого REST контроллера

```java
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Привет от Spring Boot!";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String input) {
        return "Вы сказали: " + input;
    }
}
```

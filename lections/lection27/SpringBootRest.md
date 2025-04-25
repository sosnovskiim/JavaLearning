## 📘 Лекция: Java Web, REST и Spring Boot

---

### 🔹 1. [Основы REST: архитектура и принципы](1_Rest.md)

- Что такое REST (и чем отличается от SOAP)
- Принципы REST: stateless, ресурсы, идентификаторы (URI), представления
- HTTP-методы:
  - `GET`, `POST`, `PUT`, `PATCH`, `DELETE`
- Примеры REST-запросов
- Где применяется REST: микросервисы, фронтенд-приложения, мобильные API

---

### 🔹 2. [HTTP-протокол в контексте REST](2_Rest_protocol.md)

- Структура HTTP-запроса/ответа
- Заголовки, тело, методы
- Коды статуса:
  - Успех: `200`, `201`, `204`
  - Клиентские ошибки: `400`, `401`, `403`, `404`
  - Серверные ошибки: `500`, `502`

---

### 🔹 3. [Введение в Spring Boot](3_into_springboot.md)

- Что такое Spring Boot и зачем он нужен
- Автоконфигурация, starter-зависимости, embedded-сервер (Tomcat)
- Структура проекта Spring Boot
- `pom.xml` и `application.properties`
- Аннотации: `@SpringBootApplication`, `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestBody`

---

### 🔹 4. [Создание REST API с Spring Boot](SpringBootRest.md)
- Разработка контроллера с `GET` и `POST`
- Работа с `@RequestBody`, `@PathVariable`, `@RequestParam`
- Пример JSON-запроса и ответа
- Тестирование с помощью Postman или `curl`

---

### 🔹 5. [Фильтрация HTTP-запросов](5_filters.md)

- Что такое `Filter` и зачем он нужен
- Реализация логирующего фильтра (`Filter` + `@Component`)
- Пример вывода информации о запросах в консоль

---

### 🔹6. [Обработка ошибок в REST API](6_error_handler_springboot.md)

- Как Spring обрабатывает исключения по умолчанию
- Создание собственного `@RestControllerAdvice`
- Использование `ResponseEntity` для возврата структурированных ошибок (JSON)

---

### 🔹 7. [Интеграция с Thymeleaf](7_Thymeleaf.md)

- Что такое `@Controller` vs `@RestController`
- Шаблонизатор Thymeleaf: подключение, структура `templates`
- Создание HTML-страниц с переменными из `Model`
- Обработка ошибок на стороне клиента: `error.html` и `server.error.path`

---

### 🔹 8. [HttpSession: управление пользовательскими данными](8_httpSession.md)

- Что такое `HttpSession`
- Сохранение имени пользователя в сессии
- Использование данных в шаблоне (через `Model`)
- Установка времени жизни сессии
- Практика: форма входа, приветствие по имени

---

## 🔹 8. `HttpSession`: управление пользовательскими данными

---

### 🧠 Что такое `HttpSession`

`HttpSession` — это **временное хранилище на сервере**, связанное с клиентом.  
Spring Boot (и весь сервлет-контейнер) автоматически создаёт сессию при первом запросе и привязывает к ней ID через cookie `JSESSIONID`.

Сессия:
- создаётся автоматически при первом вызове `request.getSession()`
- живёт определённое время (таймаут)
- позволяет **сохранять пользовательские данные между запросами**

---

### 📦 Пример использования `HttpSession`

```java
@PostMapping("/login")
public String login(@RequestParam String username, HttpSession session) {
    session.setAttribute("username", username); // сохраняем имя пользователя
    return "redirect:/";
}

@GetMapping("/")
public String index(HttpSession session, Model model) {
    String name = (String) session.getAttribute("username");
    model.addAttribute("username", name);
    return "index";
}
```

---

### 🧾 Использование данных в шаблоне

```html
<h1 th:if="${username != null}">Привет, <span th:text="${username}">гость</span>!</h1>

<div th:if="${username == null}">
    <form th:action="@{/login}" method="post">
        <input type="text" name="username" placeholder="Введите имя">
        <button type="submit">Войти</button>
    </form>
</div>
```

---

### ⏱ Установка времени жизни сессии

#### В `application.properties`:

```properties
server.servlet.session.timeout=30m
```

#### Или программно:

```java
session.setMaxInactiveInterval(60 * 30); // 30 минут в секундах
```

---

### 🔐 Где хранится сессия

По умолчанию — в **памяти сервера**.  
Для продакшена можно хранить сессии в:
- Redis (Spring Session)
- Базе данных
- Hazelcast и других распределённых хранилищах

---

### 🧠 Практика: логика входа

1. Открываем главную страницу `/`
2. Если `session.getAttribute("username") == null` → форма входа
3. После `POST /login` → сохраняем имя в сессию
4. Перенаправляем на `/`, где имя уже отображается

---

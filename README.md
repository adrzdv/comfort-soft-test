# Comfort Soft Test

Тестовое задание: REST-сервис, предоставляющий API для поиска минимального значения в массиве чисел.

## Сборка и запуск

### Запуск через JVM (локально)

#### Требования:

- Java 21+
- Maven 3+
- Spring Boot 3.3.2

#### Команды:

Сборка проекта

```bash
mvn clean install
```

Запуск приложения

```bash
java -jar target/comfort-soft-test-1.0-SNAPSHOT.jar
```

Приложение будет доступно по адресу:  
[http://localhost:8080](http://localhost:8080)

---

## Swagger UI

Документация API доступна по адресу:  
[http://http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## API

Пример запроса:

```
GET /find?src=C%3A%2Ffiles%2Fnumbers.xlsx&n=3

```

Ответ:

```json
{
  1
}
```
---

### Улучшения

Можно было бы реализовать docker-контейнер для данного сервиса, однако для этих целей требуется отступить от ТЗ 
и изменить контроллер: вместо пути файла в качестве параметра запроса стоит передавать в теле MultipartFile и менять 
бизнес-логику сервисов.

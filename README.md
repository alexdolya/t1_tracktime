# Overview

В приложении реализован функционал отслеживания времени выполнения методов. 

Реализовано 2 аннотации:
- Аннотация @TrackTime - методы отмеченные этой аннотацией вызываются синхронно, с асинхронным сохранением в БД данных
о времени выполнения метода.
- Аннотация @TrackAsyncTime - аннотация включает в себя аннотацию @Async. Методы отмеченные этой аннотацией вызываются асинхронно, 
с асинхронным сохранением в БД данных о времени выполнения метода.

При старте приложения для демонстрации запускаются 10 методов с аннотацией @TrackTime. После их выполнения запускается
50 методов с аннотацией @TrackAsyncTime. Результаты их выполнения сохраняются в БД. 

Тестовые методы выводят в лог информацию о старте метода, останавливают поток на 1 секунду, 
после выводят информацию об окончании выполнения метода.

#### Предоставляются следующие статистические данные:
- имя метода
- суммарное количество вызовов
- дата и время последнего вызова
- время последнего выполнения метода
- среднее время выполнения метода

##### Присутствует возможность взаимодействия с приложением:
- просмотр статистики по всем методам, присутствующим в БД
- просмотр статистики по конкретному методу
- вызов однократного выполнения метода с аннотацией @TrackTime;
- вызов выполнения метода с аннотацией @TrackTime N раз;
- вызов однократного выполнения метода с аннотацией @TrackAsyncTime;
- вызов выполнения метода с аннотацией @TrackAsyncTime N раз.

#### Open-API: src/main/resources/openapi/api-docs.json

## Запуск приложения

Запуск приложения и БД происходит в контейнере с помощью docker-compose. Выполните следующие инструкции.

1. Клонируйте репозиторий

2. В терминале перейдите в папку с проектом.

3. В терминале выполните следющую команду
    ```
    docker-compose up
    ```

4. После сборки приложение по умолчанию запустится на порте 8080, Swagger UI представлен по адресу /swagger-ui/index.html

## Технологии

При разработке использован следующий стэк технологий:
- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- Spring AOP
- PostgreSQL
- Liquibase
- Lombok
- MapStruct
- OpenAPI

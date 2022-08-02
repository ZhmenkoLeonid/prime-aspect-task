# Тестовое задание для Prime Aspect 2022г.
## Задание
Разработать Spring Boot приложение с использованием java 11, выполняющее загрузку флагов стран.
На вход должны приниматься список кодов стран (пр. gb, pe, col, at), путь к директории выгрузки файлов (пр. C:\tmp\countries\flags, /tmp/countries/flags)
и формат изображения (png или svg).

Приложение должно обращаться к внешнему API restcountries.com:
https://restcountries.com/v2/alpha?codes={code},{code},{code}
Из полученного ответа использовать URL хранения флага заданного формата
и сохранять изображение в указанную директорию с названием файла {полное_название_страны}.{формат_файла}

Доп. требования:
1) Загрузка флагов не должна выполняться последовательно,
2) Разрешено в дополнение использовать любые сторонние библиотеки,
3) Приветствуются оптимизации описанного выше формата работы, полученные изучением возможностей внешнего API и не ухудшающие работоспособность приложения.
## Описание
В данном репозитории реализован REST API сервиc, который позволяет выполнять следующее:
POST /api/flags - Скачивает картинки флагов в формате imageFormat, соответствующих кодам countriesCodesList стран, и сохраняет их на сервере по пути saveDirectoryPath, где:
1) imageFormat - формат изображения (png или svg),
2) countriesCodesList - список кодов стран,
3) saveDirectoryPath - путь к директории, в которую будут сохраняться изображения флагов
Имя файла формируется следующим образом: {полное_название_страны}.{формат_файла}.
## Инструменты
- Java 11
- Spring Boot
- Spring Validation
- Spring Web
- Swagger UI
## Сборка
mvn clean package
## Запуск 
### Cmd
1) cd target
2) java -jar primeaspecttask-0.0.1-SNAPSHOT.jar
### Docker (Для запуска необходим установленный Docker)
1) cd docker
2) docker-compose up
## Дополнительно
Доступ к swagger-ui: http://<ip_адрес>/swagger-ui/index.html. Например, http://localhost/swagger-ui/index.html.
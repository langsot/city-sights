## Инструкция по запуску

---

### 1. Подключение БД

Для запуска БД через Docker необходимо выполнить в терминале 

    docker-compose up

Postgres : необходимо создать Базу данных из property, либо указать свою

### 2. Проверка Endpoint

Для просмотра api проектика перейти по ссылке:

http://localhost:8080/swagger-ui/index.html

Косяки в реализации:

    отсутсвует слой бизнеслогики -> захламленный контроллер

    отсутсвует слой  dto -> фронт видит много мусора
    
    

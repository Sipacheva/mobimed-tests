# Проект автотестов для сайта mobimed.ru

## В данном проекте автоматизированными тестами покрыт следующий функционал:
:heavy_check_mark: Создание и удаление записи на приём

:heavy_check_mark: Смена языка на английский, французский, русский

:heavy_check_mark: Проверка наличия оплаченного счёта

:heavy_check_mark: Проверка работы поиска на главной странице

:heavy_check_mark: Проверка отображения карты

:heavy_check_mark: Проверка наличия записи в медкарте

:heavy_check_mark: Проверка наличия прошедших назначений


## Стек технологий:
![Intelij_IDEA](https://user-images.githubusercontent.com/17838471/146488140-9913750f-e6a0-4298-bf05-815cb16bca72.png)
![Java](https://user-images.githubusercontent.com/17838471/146488154-8c60ad32-5ecc-453a-9d64-b14a2e258ffb.png)
![Selenoid](https://user-images.githubusercontent.com/17838471/146488174-abb91292-9098-4a18-a7b0-bdb1d5e460e3.png)
![Allure_Report](https://user-images.githubusercontent.com/17838471/146488178-950401a9-0a8e-48bf-9cfc-ca7a894b2ffc.png)
![AllureTestOps](https://user-images.githubusercontent.com/17838471/146488180-71e90e75-7ae1-4254-b9f9-80a5cd8b8656.png)
![Github](https://user-images.githubusercontent.com/17838471/146488184-7543df19-2bb5-46ea-9493-004441224225.png)
![Jenkins](https://user-images.githubusercontent.com/17838471/146488189-02f0268f-379d-4406-a309-4cf249376beb.png)
![Telegram](https://user-images.githubusercontent.com/17838471/146488195-751c2641-11ca-4551-af9f-0877905629c7.png)
![Jira](https://user-images.githubusercontent.com/17838471/146488206-32acf0dc-e859-4e0f-8498-ac3b38094f1c.png)
![Selenide](https://user-images.githubusercontent.com/17838471/146488211-dfd6298d-6507-4d48-bbb5-2335d8696736.png)
![Gradle](https://user-images.githubusercontent.com/17838471/146488213-c8eb7bc2-0c06-4f1d-8554-ec6d7b625f2a.png)


## Как запустить

### Перед выполением необходимо:

в local.properies определить параметры конфигурации (для запуска тестов локально)

в remote.properies определить параметры конфигурации (для запуска тестов удаленно) или передать значения:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

### Запуск локально:
```bash
gradle clean test
```

### Запуск удалённо:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

## Для запуска автотестов используется Jenkins

### При запуске можно выбрать параметры
![JenkinsParam](https://user-images.githubusercontent.com/17838471/146490872-7e4283e7-8df4-46fc-8a1e-33b6843f77be.png)

### Есть возможность посмотреть статистику запусков
![JenkinsHistory](https://user-images.githubusercontent.com/17838471/146491309-f82a1f5f-3a43-470d-89c4-3137682f3130.png)


## Отчет о прохождении автотестов формируется в AllureReport
![Allure](https://user-images.githubusercontent.com/17838471/146491527-f033940a-1a27-4487-aee1-c4a0dd87ab72.png)

### В AllureReport можно посмотреть шаги выполнения тестов, а также провести диагностику ошибок для тестов, которые не выполнены
![AllureError](https://user-images.githubusercontent.com/17838471/146491847-f1a712be-2d2d-4b2c-a8be-09090b069ea7.png)


## Отчет о прохождении автотестов также можно увидеть в AllureTestOps
![TestOps](https://user-images.githubusercontent.com/17838471/146492277-2d6863a3-39ac-41f7-97ca-fc9cffb72246.png)

### В AllureTestOps хранится тестовая документация: автоматизированные и ручные сценарии
![TestOpsCases](https://user-images.githubusercontent.com/17838471/146493071-e9a5d8ab-9d56-4321-bccd-874a09697afe.png)


## При прохождении автотеста записывается видео
![AddDeleteVisitTest](https://user-images.githubusercontent.com/17838471/146497374-90b40a1b-4b91-405c-83f6-9dc7cca59610.gif)



## Уведомления о результатах прогона автотестов приходят в Telegram-канал
![TelegramNotifications](https://user-images.githubusercontent.com/17838471/146496370-c31c57a5-8015-4c24-81fa-4bdef0198d37.png)












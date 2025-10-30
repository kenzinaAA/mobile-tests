# 🚀 Дипломный проект по автоматизации mobile тестов для приложения [Wikipedia](https://ru.wikipedia.org/)

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/Wikipedia-logo.png)

> Проект по автоматизации mobile тестов для приложения Wikipedia

## 📋 О проекте

Проект представляет собой фреймворк для автоматизированного и ручного тестирования альфа-версии мобильного приложения [Wikipedia](https://ru.wikipedia.org/) (интернет-энциклопедия со свободным доступом).
Проект включает в себя:
- **Набор автоматизированных положительных и отрицательных тест-кейсов** для запуска как локально, так и удаленно через сервис Browserstack;
- **Возможность удаленного запуска** тестов в Jenkins;
- **Получение продвинутой отчетности** с Allure Framework;
- **Интеграция со средой Allure TestOps** для управления процессом ручного и автоматизированного тестирования;
- **Интеграция со средой управления проектами Jira**
---

## 📚 Содержание

- [Технологии и инструменты, используемые в данном проекте](#технологии-и-инструменты)
- [Архитектура тестов](#архитектура-тестов)
- [Тест-кейсы](#тест-кейсы)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Информация о тестах в Allure report](#-allure-отчет)
- [Интеграция с TestOps](#-интеграция-с-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Телеграмм-бот с уведомлениями о результатах тестов](#-телеграмм-бот-с-уведомлениями-о-результатах-тестов)
- Страница сервиса BrowserStack с результатами запусков тестов
- Видео-пример проверки корректности работы Новостного блока на титульной странице

---
<a id="технологии-и-инструменты"></a>
## 🛠 Технологии и инструменты, используемые в данном проекте

[<img alt="Allure" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Allure.svg" width="70"/>](https://github.com/allure-framework/allure2)
[<img alt="Allure_EE" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Allure_EE.svg" width="70"/>](https://qameta.io/)
[<img alt="Java" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Android.svg" width="70"/>](https://developer.android.com/studio?hl=ru)
[<img alt="Java" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Appium.svg" width="70"/>](https://appium.io//)
[<img alt="Java" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Browserstack.svg" width="70"/>](https://www.browserstack.com/)
[<img alt="Github" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/GitHub.svg" width="70"/>](https://github.com/)
[<img alt="Gradle" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Gradle.svg" width="70"/>](https://gradle.org/)
[<img alt="IDEA" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Idea.svg" width="70"/>](https://www.jetbrains.com/idea/)
[<img alt="Java" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Java.svg" width="70"/>](https://www.java.com/)
[<img alt="Jenkins" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Jenkins.svg" width="70"/>](https://www.jenkins.io/)
[<img alt="JUnit 5" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Junit5.svg" width="70"/>](https://junit.org/junit5/)
[<img alt="JUnit 5" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Selenide.svg" width="70"/>](https://selenide.org/)
[<img alt="Telegram" height="70" src="https://github.com/kenzinaAA/mobile-tests/blob/main/images/logo/Telegram.svg" width="70"/>](https://telegram.org/)
---

<a id="архитектура-тестов"></a>
## 🏗 Архитектура тестов

```bash
src/test/java/
├── 📁 config/                        # ⚙️ Настройки конфигурации
│   ├── BrowserStackConfig.java
│   └── EmulatorConfig.java
├── 📁 drivers/                       # 🛠 Вспомогательные классы
│   ├── BrowserstackDriver.java
│   └── EmulatorDriver.java    
├── 📁 helpers/                       # 🛠 Вспомогательные классы
│   ├── Attach.java              
│   └── Browserstack.java             
├── 📁 tests/                         # 🧪 Тестовые классы
│   ├── TestBase.java         
│   └── WikiTests.java         
└── 📁 resources/                     # Данные для запусков тестов
    ├── browserstack.properties
    └── emulator.properties
```
---
<a id="Покрытие функциональности"></a>
## 🏗 Тест кейсы

✅ Успешный поиск легальной статьи

✅ Неуспешный поиск нелегальной статьи

✅ Проверка актуальности даты статей на главной странице

✅ Переход на статью из поиска

✅ Проверка новостного блока на главной странице

---
## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/KenzinaAA_Diploma_Mobile/)

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/JenkinsMain.png)
![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/JenkinsConfig.png)

## Информация о тестах в [Allure report](https://jenkins.autotests.cloud/job/KenzinaAA_Diploma_Mobile/allure/)

### Окно с тестовыми кейсами

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/AllureTestCases.png)

### Окно с графиками

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/AllureMain.png)

## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/4977/)

### Тест-кейсы

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/TestOppsCases.png)

### Тест-кейсы с историей запусков

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/TestOppsLaunches.png)

## Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1521)

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/Jira.png)

## Телеграмм-бот с уведомлениями о результатах тестов

После завершения тестов отчет о прохождении приходит в Telegram с помощью заранее созданного бота

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/ChatBot.jpg)

## Страница сервиса [BrowserStack](https://app-automate.browserstack.com/projects/KenzinaAA_Diploma_Mobile) с результатами запусков тестов

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/BrowserStack.png)

## Видео-пример проверки корректности работы Новостного блока на титульной странице

![](https://github.com/kenzinaAA/mobile-tests/blob/main/images/TestNews.gif)

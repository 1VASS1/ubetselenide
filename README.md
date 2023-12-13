# Ubet-qa-project


# В этом репозитаории содержатся UI Selenide + Allure  автотесты

## Для запуска и генерации Allure отчёта:


- `mvn clean` очищает проект от созданных в процессе сборки файлов
- `mvn test` запускает тесты
- `mvn allure:report` генерирует отчет
- `mvn allure:serve` отображает отчет в браузере на случайном порте
- `mvn allure:serve -Dallure.serve.port={your_port}` запустить отчет на определенном порте

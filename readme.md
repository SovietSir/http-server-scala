Сборка и запуск сервера осуществляется командой sbt compile "run 8080", где 8080 - номер порта (необходимый параметр).

Выполнять команду нужно из консоли корневой директории проекта.

В процессе работы приложения в корневой директории проекта создаётся файл users.mv.db, являющийся хранилищем для
embedded базы данных H2.

В папке src/test есть небольшой шелл-скрипт для проверки работоспособности сервера (скрипт отлаживался только из под
linux, работа из под других ОС не гарантируется).

На моей локальной машине сервер выдерживал до 5000 запросов в минуту.

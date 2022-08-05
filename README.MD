# Запускаем Intellij IDEA → Terminal:

Команда на запуск chrome локально:
>./gradlew clean test -Dlaunch=localLaunch -DbrowserName=CHROME

Команда на запуск chrome удаленно:
>./gradlew clean test -Dlaunch=localLaunch -DbrowserName=CHROME -DbrowserIsRemote=true

Команда на запуск firefox локально:
>./gradlew clean test -Dlaunch=remoteLaunch -DbrowserName=FIREFOX -DbrowserIsRemote=false

Команда на запуск chrome удаленно:
>./gradlew clean test -Dlaunch=remoteLaunch -DbrowserName=FIREFOX
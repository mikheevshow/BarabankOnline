//WhatWeNeedToDo

//Сделать так,чтобы версии зависимостей были в верхней части pom файла
//Сделать конвертер TimeStamp в LocalDate пока оставлено java.util.date
//Поправить пути к header и footer (исправлено)


//Банк должен поддерживать перевод денежных  средств между клиентами данного банка и сторонних банков.

//Сторонние банки это банки других команд.

//Идентификация клиента по паспорту в формате 1234567890 (10 цифр без пробелов).
//

// возможность выгрузить счет клиента (историю операций по счету) в формате json и xml

//-Выгрузка отчета xml/json  по операциям клиента за выбранный промежуток времени.

//-Возможность "батчево-транзакционной" загрузки операций через входящий xml/json файл .

// Т.е. в файле от 1 до 1000 операций, и надо загрузить либо все операции, либо ни одной , если какая-то операция невозможна.

//-Вынести настройку подключения к базе данных в property файл, кто еще не сделал этого.

//-Выгрузка отчета xml/json  по всем операциям в банке за выбранную дату.
//getAll

//-Настроить логирование программы с профилями "дебаг" и "продакшн".

// Подразумевается, что "поддержка" могла заглянуть в логи и посмотреть, как проходят операции.
// Либо же выгрузить лог "вам".
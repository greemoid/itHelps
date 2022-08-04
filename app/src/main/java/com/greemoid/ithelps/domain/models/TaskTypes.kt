package com.greemoid.ithelps.domain.models

enum class TaskTypes(val chapter: String) {
    IMPORTANTANDURGENT("Термінові і важливі"),
    IMPORTANT("Важливі, але не термінов"),
    URGENT("Термінові, але не важливі"),
    NOTIMPORTANTANDNOTURGENT("Не термінові і не важливі"),
    DAILY("Мій день"),
    GROCERIES("Покупки"),
    HISTORY("Історія")
}
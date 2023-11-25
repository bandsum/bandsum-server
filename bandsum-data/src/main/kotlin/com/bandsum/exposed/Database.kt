package com.bandsum.exposed

import org.jetbrains.exposed.sql.Database

object Connection {

    fun connect() {
        Database.connect(
            url = "jdbc:h2:file:./database/data;DB_CLOSE_DELAY=-1;",
            user = "root",
            driver = "org.h2.Driver",
            password = ""
        )
    }
}

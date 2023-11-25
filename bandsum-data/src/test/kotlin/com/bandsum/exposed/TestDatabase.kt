package com.bandsum.exposed

import com.bandsum.exposed.entity.RoomEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object TestDatabase {

    fun connect() = Database.connect(
        url = "jdbc:h2:mem:bandsum;DB_CLOSE_DELAY=-1;",
        user = "root",
        driver = "org.h2.Driver",
        password = ""
    )

    fun createTables() {
        transaction {
            SchemaUtils.create(
                RoomEntity
            )
        }
    }

    fun dropTables() {
        transaction {
            SchemaUtils.drop(
                RoomEntity
            )
        }
    }
}

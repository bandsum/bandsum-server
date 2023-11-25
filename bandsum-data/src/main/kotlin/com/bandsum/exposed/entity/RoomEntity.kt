package com.bandsum.exposed.entity

import com.bandsum.exposed.entity.RoomEntity.primaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.json.json

object RoomEntity : Table("rooms") {
    val id = long("id")
    val name = varchar("name", 255)
    val tags = json<RoomTagEntity>("tags", Json.Default)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
    val deletedAt = datetime("deleted_at").nullable()

    override val primaryKey = PrimaryKey(id)
}

@Serializable
data class RoomTagEntity(val list: List<String>)

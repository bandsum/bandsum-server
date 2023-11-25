package com.bandsum.exposed.entity

import com.bandsum.room.domain.Room
import com.bandsum.room.domain.RoomRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.upsert

class ExposedRoomRepository : RoomRepository {

    override fun save(room: Room) {
        RoomEntity.upsert(RoomEntity.id) {
            it[id] = room.id.value
            it[name] = room.name
            it[tags] = RoomTagEntity(room.tags)
            it[createdAt] = room.createdAt
            it[updatedAt] = room.updatedAt
            it[deletedAt] = room.deletedAt
        }
    }
}

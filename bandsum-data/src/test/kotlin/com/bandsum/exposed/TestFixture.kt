package com.bandsum.exposed

import com.bandsum.room.domain.Room
import com.bandsum.room.domain.RoomId
import java.time.LocalDateTime

object TestFixture {

    fun createRoom(
        id: RoomId = RoomId.generateNextId(),
        name: String = "name",
        tags: List<String> = listOf("tag1", "tag2"),
        createdAt: LocalDateTime = LocalDateTime.now(),
        updatedAt: LocalDateTime = LocalDateTime.now(),
        deletedAt: LocalDateTime? = null,
    ): Room {
        return Room(
            id = id,
            name = name,
            tags = tags,
            createdAt = createdAt,
            updatedAt = updatedAt,
            deletedAt = deletedAt,
        )
    }
}

package com.bandsum.room.domain

import java.time.LocalDateTime

data class Room(
    val id: RoomId,
    val name: String,
    val tags: List<String>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime?,
)

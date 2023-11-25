package com.bandsum.room

data class Room(
    val id: RoomId,
    val name: String,
    val tags: List<String>
)

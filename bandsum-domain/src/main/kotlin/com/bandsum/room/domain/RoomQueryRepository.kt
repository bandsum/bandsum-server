package com.bandsum.room.domain

interface RoomQueryRepository {

    fun findById(id: RoomId): Room
}

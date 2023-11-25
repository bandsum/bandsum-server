package com.bandsum.room

interface RoomQueryRepository {

    fun findById(id: RoomId): Room?
}

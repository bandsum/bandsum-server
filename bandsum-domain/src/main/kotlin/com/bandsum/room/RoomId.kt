package com.bandsum.room

import com.bandsum.libs.Snowflake

@JvmInline
value class RoomId(val value: Long) {

    companion object {

        fun generateNextId(): RoomId {
            return RoomId(Snowflake.DEFAULT.nextId())
        }
    }
}

package com.bandsum.exposed.entity

import com.bandsum.exposed.TestDatabase
import com.bandsum.exposed.TestFixture
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class ExposedRoomRepositoryE2ESpec : FunSpec({

    val repository = ExposedRoomRepository()

    beforeTest {
        TestDatabase.connect()
        TestDatabase.createTables()
    }

    test("Room 이 저장이 잘 되는지 확인해요") {
        newSuspendedTransaction {
            val room = TestFixture.createRoom()

            repository.save(room)

            val roomEntity = RoomEntity.select { RoomEntity.id eq room.id.value }.single()
            roomEntity[RoomEntity.id] shouldBe room.id.value
            roomEntity[RoomEntity.name] shouldBe room.name
            roomEntity[RoomEntity.tags] shouldBe room.tags
            roomEntity[RoomEntity.createdAt] shouldBe room.createdAt
            roomEntity[RoomEntity.updatedAt] shouldBe room.updatedAt
            roomEntity[RoomEntity.deletedAt] shouldBe room.deletedAt
        }
    }

    afterTest {
        TestDatabase.dropTables()
    }
})

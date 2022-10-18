package technology.cyan.logIds

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

internal class LogIdsTest {
    @Test
    fun test() {
        data class TestClazz(val id: Long, val userId: String, val name: String, val serialId: UUID)

        val id = Random().nextLong()
        val serialId = UUID.randomUUID()
        val userId = UUID.randomUUID().toString()
        val name = Random().nextDouble().toString()

        val testClazz = TestClazz(id = id, userId = userId, name = name, serialId = serialId)
        val result = LogIds.toIdsMap(testClazz)
        assertEquals(result.size, 3)
        assertEquals(result["id"], id.toString())
        assertEquals(result["userId"], userId)
        assertEquals(result["serialId"], serialId.toString())
    }
}
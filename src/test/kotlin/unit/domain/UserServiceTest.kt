package unit.domain

import com.comeonyo.domain.domain.user.User
import com.comeonyo.domain.domain.user.UserRepository
import com.comeonyo.domain.domain.user.UserService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserServiceTest {
    private val userRepository = mockk<UserRepository>(relaxed = true)
    private val sut = UserService(userRepository)

    @Test
    fun `getUserById returns a user when user exists`() {
        // Given
        val userId = 1
        val expectedUser = User(id = userId, name = "John Doe", email = "john.doe@example.com", password = "password")
        every { userRepository.getUserById(userId) } returns expectedUser

        // When
        val result = sut.getUserById(userId)

        // Then
        assertNotNull(result)
        assertEquals(expectedUser, result)
        verify(exactly = 1) { userRepository.getUserById(userId) }
    }
}

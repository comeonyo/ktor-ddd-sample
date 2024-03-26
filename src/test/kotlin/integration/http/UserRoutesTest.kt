package integration.http

import com.comeonyo.domain.application.user.dto.RegisterUserRequest
import com.comeonyo.domain.domain.user.dto.GetUserResponse
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import org.koin.core.context.GlobalContext.stopKoin
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRoutesTest {
    @BeforeTest
    fun beforeTest() {
        stopKoin()
    }

    @Test
    fun `register user should return created status`() =
        testApplication {
            val client =
                createClient {
                    install(ContentNegotiation) {
                        json()
                    }
                }

            val registerUserResponse =
                client.post("/users") {
                    contentType(ContentType.Application.Json)
                    setBody(RegisterUserRequest("test", "test@comeonyo.com", "test1234"))
                }
            assertEquals(HttpStatusCode.Created, registerUserResponse.status)
        }

    @Test
    fun `get users should return ok status`() =
        testApplication {
            val client =
                createClient {
                    install(ContentNegotiation) {
                        json()
                    }
                }

            val getUsersResponse = client.get("/users")
            assertEquals(HttpStatusCode.OK, getUsersResponse.status)
        }

    @Test
    fun `get user should return ok status`() =
        testApplication {
            // Given: 테스트 환경 설정
            val client =
                createClient {
                    install(ContentNegotiation) {
                        json()
                    }
                }

            // 사용자 등록을 위한 초기 POST 요청
            val request = RegisterUserRequest("user1", "user1@comeonyo.com", "test1234")
            val response =
                client.post("/users") {
                    contentType(ContentType.Application.Json)
                    setBody(request)
                }
            val userId = response.body<GetUserResponse>().id

            // When: 실제 테스트 대상이 되는 액션 실행
            val getUserResponse = client.get("/users/$userId")

            // Then: 결과 검증
            assertEquals(HttpStatusCode.OK, getUserResponse.status)
            assertEquals(response.body<GetUserResponse>(), getUserResponse.body<GetUserResponse>())
        }
}

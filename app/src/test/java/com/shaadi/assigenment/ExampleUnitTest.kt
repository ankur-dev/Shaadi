package com.shaadi.assigenment


import com.shaadi.assigenment.data.network.ApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var articlesService: ApiService? = null
    var retrofit: Retrofit? = null
    var testUtils: TestUtills? = null

    @Before
    fun before() {
        testUtils = TestUtills()
        retrofit = testUtils?.buildRetrofit()
        articlesService = retrofit?.create(ApiService::class.java)
    }


    @Test
    fun urlMatch_check() {
        assertEquals("https://api.nytimes.com/svc/mostpopular/v2/", BuildConfig.BASE_URL)
    }


}

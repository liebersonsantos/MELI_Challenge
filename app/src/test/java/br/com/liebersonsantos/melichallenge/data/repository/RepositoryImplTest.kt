package br.com.liebersonsantos.melichallenge.data.repository

import br.com.liebersonsantos.melichallenge.common.mock.getMockCategories
import br.com.liebersonsantos.melichallenge.common.mock.getMockProducts
import br.com.liebersonsantos.melichallenge.data.api.Api
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Created by lieberson on 9/16/21.
 *
 * @author lieberson.xsantos@gmail.com
 */
@ExperimentalCoroutinesApi
class RepositoryImplTest : TestCase() {

    private val testCoroutinesDispatcher = TestCoroutineDispatcher()
    private val api = mock(Api::class.java)

    @Test
    fun `test get categories`() = testCoroutinesDispatcher.runBlockingTest {
        val repository = RepositoryImpl(api)
        val response = getMockCategories()

        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(response).`when`(api).getCategories(anyString())

        repository.getCategories(anyString()).let {
            assertThat(it).isEqualTo(response)
        }
    }

    @Test
    fun `test get products by category`() = testCoroutinesDispatcher.runBlockingTest {
        val repository = RepositoryImpl(api)
        val response = getMockProducts()

        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(response).`when`(api).getProducts(anyString(), anyString())

        repository.getProductsByCategory(anyString(), anyString()).let {
            assertThat(it).isEqualTo(response)
        }
    }

    @Test
    fun `test get products by name`() = testCoroutinesDispatcher.runBlockingTest {
        val repository = RepositoryImpl(api)
        val response = getMockProducts()

        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(response).`when`(api).getProductsByName(anyString(), anyString(), anyInt())

        repository.getProductsByName(anyString(), anyString(), anyInt()).let {
            assertThat(it).isEqualTo(response)
        }
    }
}

package br.com.liebersonsantos.melichallenge.view.product.fragment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.liebersonsantos.melichallenge.common.mock.getMockProducts
import br.com.liebersonsantos.melichallenge.data.core.State
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory.GetProductByCategoryImpl
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.exceptions.base.MockitoException
import java.io.IOException

/**
 * Created by lieberson on 9/16/21.
 *
 * @author lieberson.xsantos@gmail.com
 */
@ExperimentalCoroutinesApi
class ProductViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testCoroutinesDispatcher = TestCoroutineDispatcher()
    private val mockGetProductByCategoryImpl = mock(GetProductByCategoryImpl::class.java)
    private lateinit var viewModel: ProductViewModel

    @Before
    fun setup(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = ProductViewModel(testCoroutinesDispatcher, mockGetProductByCategoryImpl)
    }

    @After
    fun tearDown(){
        testCoroutinesDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun `test loading product`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(true).`when`(mockGetProductByCategoryImpl).invoke(anyString(), anyString())

        viewModel.getProducts(anyString(), anyString())

        assertThat(viewModel.products.value).isEqualTo(State.loading<Boolean>(true))
    }

    @Test
    fun `testing loading success get products`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(getMockProducts()).`when`(mockGetProductByCategoryImpl).invoke(anyString(), anyString())

        viewModel.getProducts(anyString(), anyString())

        assertThat(viewModel.products.value).isEqualTo(State.loading<ProductResponse>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.products.value).isEqualTo(State.success(getMockProducts()))
    }

    @Test (expected = MockitoException::class)
    fun `testing error get product`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doThrow(IOException::class.java).`when`(mockGetProductByCategoryImpl).invoke(anyString(), anyString())

        viewModel.getProducts(anyString(), anyString())
        assertThat(viewModel.products.value).isEqualTo(State.loading<ProductResponse>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.products.value).isEqualTo(State.error<ProductResponse>(IOException()))
    }

}
package br.com.liebersonsantos.melichallenge.view.home.fragment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.liebersonsantos.melichallenge.common.mock.getMockCategories
import br.com.liebersonsantos.melichallenge.common.mock.getMockProducts
import br.com.liebersonsantos.melichallenge.data.core.State
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname.GetProductsByNameUseCaseImpl
import br.com.liebersonsantos.melichallenge.domain.usecase.getcategories.GetCategoriesUseCaseImpl
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
import org.junit.experimental.categories.Categories
import org.mockito.Mockito.*
import org.mockito.exceptions.base.MockitoException
import java.io.IOException

/**
 * Created by lieberson on 9/16/21.
 *
 * @author lieberson.xsantos@gmail.com
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testCoroutinesDispatcher = TestCoroutineDispatcher()
    private val mockGetCategoriesUseCaseImpl = mock(GetCategoriesUseCaseImpl::class.java)
    private val mockGetProductByNameUseCaseImpl = mock(GetProductsByNameUseCaseImpl::class.java)
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HomeViewModel(testCoroutinesDispatcher, mockGetCategoriesUseCaseImpl, mockGetProductByNameUseCaseImpl)
    }

    @After
    fun tearDown(){
        testCoroutinesDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun `test loading categories`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(true).`when`(mockGetCategoriesUseCaseImpl).invoke(anyString())

        viewModel.getCategories(anyString())

        assertThat(viewModel.categories.value).isEqualTo(State.loading<Boolean>(true))
    }

    @Test
    fun `test loading product`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(true).`when`(mockGetProductByNameUseCaseImpl).invoke(anyString(), anyString(), anyInt())

        viewModel.getProductsByName(anyString(), anyString(), anyInt())

        assertThat(viewModel.products.value).isEqualTo(State.loading<Boolean>(true))
    }

    @Test
    fun `testing loading success get categories`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(getMockCategories()).`when`(mockGetCategoriesUseCaseImpl).invoke(anyString())

        viewModel.getCategories(anyString())

        assertThat(viewModel.categories.value).isEqualTo(State.loading<Categories>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.categories.value).isEqualTo(State.success(getMockCategories()))
    }

    @Test
    fun `testing loading success get product`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doReturn(getMockProducts()).`when`(mockGetProductByNameUseCaseImpl).invoke(anyString(), anyString(), anyInt())

        viewModel.getProductsByName(anyString(), anyString(), anyInt())

        assertThat(viewModel.products.value).isEqualTo(State.loading<ProductResponse>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.products.value).isEqualTo(State.success(getMockProducts()))
    }

    @Test (expected = MockitoException::class)
    fun `testing error get categories`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doThrow(IOException::class.java).`when`(mockGetCategoriesUseCaseImpl).invoke(anyString())

        viewModel.getCategories(anyString())
        assertThat(viewModel.categories.value).isEqualTo(State.loading<Categories>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.categories.value).isEqualTo(State.error<Categories>(IOException()))
    }

    @Test (expected = MockitoException::class)
    fun `testing error get product`() = testCoroutinesDispatcher.runBlockingTest {
        testCoroutinesDispatcher.pauseDispatcher()

        doThrow(IOException::class.java).`when`(mockGetProductByNameUseCaseImpl).invoke(anyString(), anyString(), anyInt())

        viewModel.getProductsByName(anyString(), anyString(), anyInt())
        assertThat(viewModel.products.value).isEqualTo(State.loading<ProductResponse>(true))

        testCoroutinesDispatcher.resumeDispatcher()
        assertThat(viewModel.products.value).isEqualTo(State.error<ProductResponse>(IOException()))
    }
}
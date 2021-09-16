package br.com.liebersonsantos.melichallenge.view.home.fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.liebersonsantos.melichallenge.data.core.State
import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname.GetProductsByNameUserCase
import br.com.liebersonsantos.melichallenge.domain.usecase.getcategories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named("io") private val ioDispatcher: CoroutineDispatcher,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsByNameUserCase: GetProductsByNameUserCase
): ViewModel() {

    private val _categories = MutableLiveData<State<MutableList<Categories>>>()
    val categories: LiveData<State<MutableList<Categories>>>
    get() = _categories

    private val _products = MutableLiveData<State<ProductResponse>>()
    val products: LiveData<State<ProductResponse>>
        get() = _products

    fun getCategories(sites: String) = viewModelScope.launch {
        try {
            _categories.value = State.loading(true)
            val response = withContext(ioDispatcher){
                getCategoriesUseCase(sites)
            }

            _categories.value = State.success(response)
        } catch (e: Exception){
            Timber.e(e)
            _categories.value = State.error(e)
        }
    }

    fun getProductsByName(sites: String, query: String, page: Int) = viewModelScope.launch {
        try {
            _products.value = State.loading(true)
            val response = withContext(ioDispatcher){
                getProductsByNameUserCase(sites, query, page)
            }

            _products.value = State.success(response)
        } catch (e: Exception){
            Timber.e(e)
            _products.value = State.error(e)
        }
    }
}
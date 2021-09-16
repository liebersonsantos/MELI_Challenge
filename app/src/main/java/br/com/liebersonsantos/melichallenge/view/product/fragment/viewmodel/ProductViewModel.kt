package br.com.liebersonsantos.melichallenge.view.product.fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.liebersonsantos.melichallenge.data.core.State
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory.GetProductByCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
@HiltViewModel
class ProductViewModel @Inject constructor(
    @Named("io") private val ioDispatcher: CoroutineDispatcher,
    private val getProductByCategory: GetProductByCategory
) : ViewModel() {

    private val _products = MutableLiveData<State<ProductResponse>>()
    val products: LiveData<State<ProductResponse>>
        get() = _products

    fun getProducts(sites: String, category: String) = viewModelScope.launch {
        try {
            _products.value = State.loading(true)
            val response = withContext(ioDispatcher){
                getProductByCategory(sites, category)
            }

            _products.value = State.success(response)
        } catch (e: Exception){
            Timber.e(e)
            _products.value = State.error(e)
        }
    }
}
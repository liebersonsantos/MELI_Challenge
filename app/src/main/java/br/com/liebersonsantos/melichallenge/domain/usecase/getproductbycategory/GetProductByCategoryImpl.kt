package br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory

import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.data.repository.Repository
import javax.inject.Inject

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetProductByCategoryImpl @Inject constructor(private val repository: Repository): GetProductByCategory {
    override suspend fun invoke(sites: String, category: String): ProductResponse =
        repository.getProductsByCategory(sites, category)
}
package br.com.liebersonsantos.melichallenge.data.repository

import br.com.liebersonsantos.melichallenge.data.api.Api
import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import javax.inject.Inject

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
class RepositoryImpl @Inject constructor(private val api: Api): Repository {
    override suspend fun getCategories(sites: String): MutableList<Categories> =
        api.getCategories(sites = sites)

    override suspend fun getProductsByCategory(sites: String, category: String): ProductResponse =
        api.getProducts(sites, category)

    override suspend fun getProductsByName(sites: String, query: String, page: Int): ProductResponse =
        api.getProductsByName(sites, query, page)
}
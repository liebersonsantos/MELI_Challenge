package br.com.liebersonsantos.melichallenge.data.repository

import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
interface Repository {
    suspend fun getCategories(sites: String): MutableList<Categories>
    suspend fun getProductsByCategory(sites: String, category: String): ProductResponse
    suspend fun getProductsByName(sites: String, query: String, page: Int): ProductResponse
}
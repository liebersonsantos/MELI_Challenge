package br.com.liebersonsantos.melichallenge.data.api

import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
interface Api {

    @GET("sites/{sites}/categories")
    suspend fun getCategories(
    @Path("sites") sites: String): MutableList<Categories>

    @GET("sites/{sites}/search")
    suspend fun getProducts(
        @Path("sites") sites: String,
        @Query("category") category: String
    ): ProductResponse

    @GET("sites/{sites}/search")
    suspend fun getProductsByName(
        @Path("sites") sites: String,
        @Query("q") query: String,
        @Query("offset") page: Int
    ): ProductResponse

}
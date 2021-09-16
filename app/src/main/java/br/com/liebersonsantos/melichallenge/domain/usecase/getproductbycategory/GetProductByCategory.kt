package br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory

import br.com.liebersonsantos.melichallenge.data.model.ProductResponse

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetProductByCategory {
    suspend operator fun invoke(sites: String, category: String): ProductResponse
}
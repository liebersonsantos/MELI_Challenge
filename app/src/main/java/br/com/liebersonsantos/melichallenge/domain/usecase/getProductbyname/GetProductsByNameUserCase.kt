package br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname

import br.com.liebersonsantos.melichallenge.data.model.ProductResponse

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetProductsByNameUserCase {
    suspend operator fun invoke(sites: String, query: String, page: Int): ProductResponse
}
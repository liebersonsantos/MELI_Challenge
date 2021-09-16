package br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname

import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import br.com.liebersonsantos.melichallenge.data.repository.Repository
import javax.inject.Inject

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetProductsByNameUseCaseImpl @Inject constructor(private val repository: Repository): GetProductsByNameUserCase{
    override suspend fun invoke(sites: String, query: String, page: Int): ProductResponse =
        repository.getProductsByName(sites, query, page)
}
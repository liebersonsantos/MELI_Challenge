package br.com.liebersonsantos.melichallenge.domain.usecase.getcategories

import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.data.repository.Repository
import javax.inject.Inject

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetCategoriesUseCaseImpl @Inject constructor(private val repository: Repository): GetCategoriesUseCase{
    override suspend fun invoke(sites: String): MutableList<Categories> =
        repository.getCategories(sites)

}
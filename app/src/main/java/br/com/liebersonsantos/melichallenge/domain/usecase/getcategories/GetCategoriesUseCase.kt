package br.com.liebersonsantos.melichallenge.domain.usecase.getcategories

import br.com.liebersonsantos.melichallenge.data.model.Categories

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetCategoriesUseCase {
    suspend operator fun invoke(sites: String): MutableList<Categories>
}
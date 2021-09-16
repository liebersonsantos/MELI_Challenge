package br.com.liebersonsantos.melichallenge.domain.di

import br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname.GetProductsByNameUseCaseImpl
import br.com.liebersonsantos.melichallenge.domain.usecase.getProductbyname.GetProductsByNameUserCase
import br.com.liebersonsantos.melichallenge.domain.usecase.getcategories.GetCategoriesUseCase
import br.com.liebersonsantos.melichallenge.domain.usecase.getcategories.GetCategoriesUseCaseImpl
import br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory.GetProductByCategory
import br.com.liebersonsantos.melichallenge.domain.usecase.getproductbycategory.GetProductByCategoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindGetCategoriesUseCase(useCase: GetCategoriesUseCaseImpl): GetCategoriesUseCase

    @Binds
    fun bindGetProductByCategory(useCase: GetProductByCategoryImpl): GetProductByCategory

    @Binds
    fun bindGetProductsByNameUseCase(useCaseImpl: GetProductsByNameUseCaseImpl): GetProductsByNameUserCase

}
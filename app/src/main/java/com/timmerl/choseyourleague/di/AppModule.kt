package com.timmerl.choseyourleague.di

import com.timmerl.data.api.RetrofitProvider
import com.timmerl.data.api.SportApi
import com.timmerl.data.mapper.LeagueDataModelMapper
import com.timmerl.data.mapper.LeagueDataModelMapperImpl
import com.timmerl.data.repository.LeagueRepositoryImpl
import com.timmerl.domain.repository.LeagueRepository
import com.timmerl.domain.usecase.FilterLeaguesByNameUseCase
import com.timmerl.domain.usecase.FilterLeaguesByNameUseCaseImpl
import com.timmerl.presentation.screen.selectleague.LeaguesViewModel
import com.timmerl.presentation.screen.selectleague.mapper.LeagueUiModelMapper
import com.timmerl.presentation.screen.selectleague.mapper.LeagueUiModelMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SportApi> { RetrofitProvider.getApi() }
    single<LeagueDataModelMapper> { LeagueDataModelMapperImpl() }
    single<LeagueRepository> { LeagueRepositoryImpl(get(), get()) }
    single<FilterLeaguesByNameUseCase> { FilterLeaguesByNameUseCaseImpl(get()) }
    single<LeagueUiModelMapper> { LeagueUiModelMapperImpl() }
    viewModel { LeaguesViewModel(get(), get()) }
}
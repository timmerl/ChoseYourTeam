package com.timmerl.choseyourleague.di

import com.timmerl.data.api.RetrofitProvider
import com.timmerl.data.api.SportApi
import com.timmerl.data.mapper.LeagueDataModelMapper
import com.timmerl.data.mapper.LeagueDataModelMapperImpl
import com.timmerl.data.mapper.TeamDataModelMapper
import com.timmerl.data.mapper.TeamDataModelMapperImpl
import com.timmerl.data.repository.LeagueRepositoryImpl
import com.timmerl.data.repository.TeamRepositoryImpl
import com.timmerl.domain.repository.LeagueRepository
import com.timmerl.domain.repository.TeamRepository
import com.timmerl.domain.usecase.GetTeamsUseCaseImpl
import com.timmerl.domain.usecase.GetLeaguesUseCaseImpl
import com.timmerl.domain.usecase.GetLeaguesUseCase
import com.timmerl.domain.usecase.GetTeamsUseCase
import com.timmerl.presentation.screen.selectleague.LeaguesViewModel
import com.timmerl.presentation.screen.selectleague.mapper.LeagueUiModelMapper
import com.timmerl.presentation.screen.selectleague.mapper.LeagueUiModelMapperImpl
import com.timmerl.presentation.screen.showteams.ShowTeamsViewModel
import com.timmerl.presentation.screen.showteams.mapper.TeamUiModelMapper
import com.timmerl.presentation.screen.showteams.mapper.TeamUiModelMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SportApi> { RetrofitProvider.getApi() }
    single<LeagueDataModelMapper> { LeagueDataModelMapperImpl() }
    single<LeagueRepository> { LeagueRepositoryImpl(get(), get()) }
    single<GetLeaguesUseCase> { GetLeaguesUseCaseImpl(get()) }
    single<LeagueUiModelMapper> { LeagueUiModelMapperImpl() }
    viewModel { LeaguesViewModel(get(), get()) }

    single<TeamDataModelMapper> { TeamDataModelMapperImpl() }
    single<TeamRepository> { TeamRepositoryImpl(get(), get()) }
    single<GetTeamsUseCase> { GetTeamsUseCaseImpl(get()) }
    single<TeamUiModelMapper> { TeamUiModelMapperImpl() }
    viewModel { ShowTeamsViewModel(get(), get()) }

}
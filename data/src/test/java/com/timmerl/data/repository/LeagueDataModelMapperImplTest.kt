package com.timmerl.data.repository

import com.timmerl.data.api.SportApi
import com.timmerl.data.mapper.LeagueDataModelMapper
import com.timmerl.data.mapper.LeagueDataModelMapperImpl
import com.timmerl.data.model.LeagueDataModel
import com.timmerl.data.model.LeaguesDataModel
import com.timmerl.domain.model.LeagueModel
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.given
import org.mockito.kotlin.then
import org.mockito.kotlin.times
import retrofit2.Response
import kotlin.test.assertEquals

class LeagueDataModelMapperImplTest {


    @Mock
    lateinit var sportApi: SportApi

    private val mapper = LeagueDataModelMapperImpl()

    private lateinit var repository: LeagueRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = LeagueRepositoryImpl(sportApi, mapper)
    }

    @Test
    fun `first call, should call api and return result`() = runTest {
        given(sportApi.getAllLeagues())
            .willReturn(Response.success(getResponse()))

        assertEquals(getExpected(), repository.getAllLeagues())

        then(sportApi).should().getAllLeagues()
    }

    @Test
    fun `second call, should return result`() = runTest {
        given(sportApi.getAllLeagues())
            .willReturn(Response.success(getResponse()))

        repository.getAllLeagues()
        repository.getAllLeagues()
        then(sportApi).should(times(1)).getAllLeagues()
    }
}

private fun getResponse() = LeaguesDataModel(
    listOf(
        LeagueDataModel("1", "Premier League", "Football", "EPL"),
        LeagueDataModel("2", "La Liga", "Football", "Primera Division"),
        LeagueDataModel("3", "NBA", "Basketball", "National Basketball Association"),
        LeagueDataModel("4", "NFL", "American Football", "National Football League"),
        LeagueDataModel("5", "MLB", "Baseball", "Major League Baseball"),
        LeagueDataModel("6", "Serie A", "Football", "Serie A TIM"),
        LeagueDataModel("7", "NHL", "Ice Hockey", "National Hockey League"),
        LeagueDataModel("8", "Ligue 1", "Football", "Ligue 1 Uber Eats"),
        LeagueDataModel("9", "Bundesliga", "Football", "Bundesliga"),
        LeagueDataModel("10", "Premiership Rugby", "Rugby", "Gallagher Premiership")
    )
)

private fun getExpected() = listOf(
    LeagueModel("1", "Premier League", "Football", "EPL"),
    LeagueModel("2", "La Liga", "Football", "Primera Division"),
    LeagueModel("3", "NBA", "Basketball", "National Basketball Association"),
    LeagueModel("4", "NFL", "American Football", "National Football League"),
    LeagueModel("5", "MLB", "Baseball", "Major League Baseball"),
    LeagueModel("6", "Serie A", "Football", "Serie A TIM"),
    LeagueModel("7", "NHL", "Ice Hockey", "National Hockey League"),
    LeagueModel("8", "Ligue 1", "Football", "Ligue 1 Uber Eats"),
    LeagueModel("9", "Bundesliga", "Football", "Bundesliga"),
    LeagueModel("10", "Premiership Rugby", "Rugby", "Gallagher Premiership")
)
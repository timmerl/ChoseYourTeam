package com.timmerl.domain.usecase

import com.timmerl.domain.model.LeagueModel
import com.timmerl.domain.repository.LeagueRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.given
import kotlin.test.assertEquals

class GetLeaguesUseCaseImplTest {

    @Mock
    lateinit var repository: LeagueRepository

    @InjectMocks
    lateinit var useCase: GetLeaguesUseCaseImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `given list does not contain search should return emptyList`() = runTest {
        val givenList = getFakeList()
        given(repository.getAllLeagues()).willReturn(givenList)

        val expected = emptyList<LeagueModel>()

        assertEquals(expected, useCase.invoke("aaaaa"))
    }

    @Test
    fun `given list contains search should return three elem`() = runTest {
        val givenList = getFakeList()
        given(repository.getAllLeagues()).willReturn(givenList)

        val expected = listOf(
            LeagueModel("2", "La Liga", "Football", "Primera Division"),
            LeagueModel("8", "Ligue 1", "Football", "Ligue 1 Uber Eats"),
            LeagueModel("9", "Bundesliga", "Football", "Bundesliga"),
        )

        assertEquals(expected, useCase.invoke("lig"))
    }
}

private fun getFakeList() = listOf(
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

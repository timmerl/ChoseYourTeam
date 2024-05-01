package com.timmerl.choseyourleague.di

import org.koin.test.KoinTest
import org.koin.test.verify.verify
import kotlin.test.Test

class AppModuleTest : KoinTest {

    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}
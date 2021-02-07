package com.shaadi.assigenment.di

import com.shaadi.assigenment.data.repository.MatchCardRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MatchCardRepository(get(),get ())
    }

}
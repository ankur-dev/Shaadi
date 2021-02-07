package com.shaadi.assigenment.di


import com.shaadi.assigenment.ui.viewModel.MatchCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MatchCardViewModel(get())
    }
}
package com.shaadi.assigenment.ui.viewModel

import androidx.lifecycle.ViewModel
import com.shaadi.assigenment.data.repository.MatchCardRepository

class MatchCardViewModel constructor(var repository: MatchCardRepository) : ViewModel() {

    var resultsItem = repository.getAllCards(10)

    fun updateData(actionName: String, email: String) {
        repository.updateData(actionName, email)
    }

}



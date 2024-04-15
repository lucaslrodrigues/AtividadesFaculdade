package com.example.aula_28_03

import androidx.lifecycle.ViewModel
class MainViewModel: ViewModel() {
    var list = List(5) {
        EmailModel.getMock()
    }
        private set

    fun getEmails(): List<EmailModel> {
        return list
    }
}


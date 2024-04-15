package com.example.aula_28_03

import com.example.aula_28_03.Utils.getRandomColor
import com.example.aula_28_03.Utils.getRandomLetter

data class EmailModel(
    val id: Int,
    val initials: NameInitials,
    val subject: String,
    val body: String
) {
    companion object {
        fun getMock(): EmailModel {
            return EmailModel(
                id = 1,
                initials = NameInitials.getRandomNameInitials(),
                subject = "Solicitação de acesso",
                body = "Venho por meio deste e-mail solicitar o acesso ao github"
            )
        }
    }
}

data class NameInitials(
    val text: String,
    val color: String
) {
    companion object {
        fun getRandomNameInitials(): NameInitials {
            return NameInitials(
                text = "${getRandomLetter()}${getRandomLetter()}",
                color = "#${getRandomColor()}${getRandomColor()}${getRandomColor()}"
            )
        }
    }
}
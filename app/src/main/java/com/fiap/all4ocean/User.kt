package com.fiap.all4ocean

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(val nome: String? = null, val telefone: String? = null) {
}

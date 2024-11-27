package br.edu.up.a134508741.dados

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Objeto(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val nome: String,
    val tamanho: String
)


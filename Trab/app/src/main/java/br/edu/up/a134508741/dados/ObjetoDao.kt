package br.edu.up.a134508741.dados

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ObjetoDao {

    @Upsert
    fun gravarObjeto(objeto: Objeto)

    @Query("SELECT * FROM objeto")
    fun listarObjeto(): Flow<List<Objeto>>

    @Query("SELECT * FROM objeto WHERE id= :idx")
    fun buscarID(idx: Int): Objeto

    @Delete
    fun deletarObjeto(objeto: Objeto)
}
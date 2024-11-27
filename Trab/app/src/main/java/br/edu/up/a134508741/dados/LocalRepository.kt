package br.edu.up.a134508741.dados

import kotlinx.coroutines.flow.Flow

class LocalRepository(
    private val dao : ObjetoDao
) : IRepository {

    override fun listarObjeto(): Flow<List<Objeto>> {
        return dao.listarObjeto()
    }

    override suspend fun buscarID(idx: Int): Objeto {
        return dao.buscarID(idx)
    }

    override suspend fun gravarObjeto(objeto: Objeto) {
        dao.gravarObjeto(objeto)
    }

    override suspend fun deletarObjeto(objeto: Objeto) {
        dao.deletarObjeto(objeto)
    }

}
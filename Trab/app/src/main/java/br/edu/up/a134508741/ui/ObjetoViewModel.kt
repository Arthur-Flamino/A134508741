package br.edu.up.a134508741.ui

import br.edu.up.a134508741.dados.Objeto
import br.edu.up.a134508741.dados.RemoteRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ObjetoViewModel(private val repository: RemoteRepository) : ViewModel() {


    // StateFlow para listar objetos
    private val _objetos = MutableStateFlow<List<Objeto>>(emptyList())
    val objetos: StateFlow<List<Objeto>> get() = _objetos


    // Função para listar os objetos
    init {
        viewModelScope.launch {
            repository.listarObjeto().collect { objetos ->
                _objetos.value = objetos
            }
        }
    }

    // Função para gravar ou atualizar um objeto
    fun gravarObjeto(objeto: Objeto) {
        viewModelScope.launch {
            repository.gravarObjeto(objeto)
        }
    }

    // Função para buscar um objeto pelo ID
    suspend fun buscarObjetoPorId(id: Int): Objeto? {
        return repository.buscarID(id)
    }

    // Função para deletar um objeto
    fun deletarObjeto(objeto: Objeto) {
        viewModelScope.launch {
            repository.deletarObjeto(objeto)
        }
    }
}

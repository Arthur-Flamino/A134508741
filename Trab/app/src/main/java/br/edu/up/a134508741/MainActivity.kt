package br.edu.up.a134508741

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import br.edu.up.a134508741.dados.LocalRepository
import br.edu.up.a134508741.ui.ObjetoViewModel
import br.edu.up.a134508741.dados.ObjetoDB.ObjetoDataB.Companion.abrirDB
import br.edu.up.a134508741.dados.RemoteRepository
import br.edu.up.a134508741.ui.ObjetoNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = abrirDB(this)
        val local = LocalRepository(db.objetoDao())
        val remoto = RemoteRepository()
        val viewModel = ObjetoViewModel(remoto)
        setContent {
            ObjetoNavHost(viewModel)
        }
    }
}

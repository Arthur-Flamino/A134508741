package br.edu.up.a134508741.dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class ObjetoDB {

    @Database(entities = [Objeto::class], version = 1)
    abstract class ObjetoDataB : RoomDatabase(){

        abstract fun objetoDao(): ObjetoDao

        companion object{
            fun abrirDB(context: Context): ObjetoDataB {
                return Room.databaseBuilder(
                    context.applicationContext,
                    ObjetoDataB::class.java,"Objeto.db"
                ).build()
            }
        }
    }
}
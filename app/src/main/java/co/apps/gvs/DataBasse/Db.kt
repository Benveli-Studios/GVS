package co.apps.gvs.DataBasse

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val dBNome = "BancoDeDadosGVS"

val dBTabelaPessoas = "dBTabelaPessoas"

val dBEmailPessoa = "dBEmailPessoa"
val dBNumeroPessoa = "dBNumeroPessoa"
val dBNomePessoa = "dBNomePessoa"
val dBImagemPessoa = "dBImagemPessoa"

class Db(contexT: Context)
    : SQLiteOpenHelper(contexT, dBNome, null, 3) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE $dBTabelaPessoas (
            $dBEmailPessoa TEXT,
            $dBNumeroPessoa TEXT,
            $dBNomePessoa TEXT, 
            $dBImagemPessoa TEXT,
            id INTEGER PRIMARY KEY AUTOINCREMENT
            );""".trimIndent()
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $dBTabelaPessoas")
        onCreate(db)
    }
}
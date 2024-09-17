
package co.apps.gvs.DataBasse.InteraçõesBásicas

import android.content.Context
import android.database.Cursor
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBEmailPessoa
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.DataBasse.dBNumeroPessoa
import co.apps.gvs.DataBasse.dBTabelaPessoas
import co.apps.gvs.Objetos.Objeto

fun Db.VerificadoPopulaçãoPessoas():Boolean {

    val pessoa = mutableListOf<Objeto>()
    val sql = "SELECT * FROM $dBTabelaPessoas"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            val objetos = Objeto(
                cursor.getString(cursor.getColumnIndexOrThrow(dBEmailPessoa)),
                cursor.getString(cursor.getColumnIndexOrThrow(dBNumeroPessoa)),
                cursor.getString(cursor.getColumnIndexOrThrow(dBNomePessoa))
            )
            pessoa.add(objetos)
        };cursor.close()
    }

    return if (pessoa.size == 1) true else false
}

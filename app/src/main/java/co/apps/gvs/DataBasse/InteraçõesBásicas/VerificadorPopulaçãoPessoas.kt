package co.apps.gvs.DataBasse.InteraçõesBásicas

import android.database.Cursor
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBTabelaPessoas

fun Db.VerificadoPopulaçãoPessoas():Boolean{

    val sql = "SELECT * FROM $dBTabelaPessoas"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    return if (cursor.count > 0) true else false
}
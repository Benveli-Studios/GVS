package co.apps.gvs.DataBasse.InteraçõesBásicas

import android.content.Context
import android.database.Cursor
import android.widget.Toast
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBEmailPessoa
import co.apps.gvs.DataBasse.dBImagemPessoa
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.DataBasse.dBNumeroPessoa
import co.apps.gvs.DataBasse.dBTabelaPessoas
import co.apps.gvs.Objetos.Objeto

fun Db.LeituraSimplesPessoa(context: Context):Objeto{

    var pessoa = Objeto()
    val sql = "SELECT * FROM $dBTabelaPessoas"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            pessoa = Objeto(
                cursor.getString(cursor.getColumnIndexOrThrow(dBEmailPessoa)),
                cursor.getString(cursor.getColumnIndexOrThrow(dBNumeroPessoa)),
                cursor.getString(cursor.getColumnIndexOrThrow(dBNomePessoa)),
                cursor.getString(cursor.getColumnIndexOrThrow(dBImagemPessoa))
            )
        };cursor.close()
    }
    return pessoa
}
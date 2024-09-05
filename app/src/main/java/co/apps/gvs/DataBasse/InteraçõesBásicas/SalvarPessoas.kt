package co.apps.gvs.DataBasse.InteraçõesBásicas

import androidx.core.content.contentValuesOf
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBEmailPessoa
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.DataBasse.dBNumeroPessoa
import co.apps.gvs.DataBasse.dBTabelaPessoas
import co.apps.gvs.Objetos.Objeto

fun Db.SalvarPessoas(listItem: Objeto):Boolean{

    val test = writableDatabase.insert(dBTabelaPessoas, null, contentValuesOf().apply {

        put("$dBEmailPessoa", listItem.ObjEmailPessoas)
        put("$dBNumeroPessoa", listItem.ObjNumeroPessoas)
        put("$dBNomePessoa", listItem.ObjNomesPessoas)
    })
    return test > 0
}
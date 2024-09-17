package co.apps.gvs.DataBasse.InteraçõesBásicas

import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.DataBasse.dBTabelaPessoas
import co.apps.gvs.Objetos.Objeto

fun Db.ExcluirPessoas(){

    //writableDatabase.delete("$dBTabelaPessoas", "$dBNomePessoa=($pessoaId)", null)
    writableDatabase.delete("$dBTabelaPessoas", null, null)

}
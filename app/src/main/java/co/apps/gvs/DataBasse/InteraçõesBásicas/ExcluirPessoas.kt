package co.apps.gvs.DataBasse.InteraçõesBásicas

import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.DataBasse.dBTabelaPessoas

fun Db.ExcluirPessoas(pessoaId: Int){

    writableDatabase.delete("$dBTabelaPessoas", "$dBNomePessoa=($pessoaId)", null)

}
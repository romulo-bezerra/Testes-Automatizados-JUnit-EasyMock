
package com.ifpb.atividadefixacao.easymock.interfaces.parteI;

import com.ifpb.atividadefixacao.easymock.entidades.parteI.Pessoa;
import java.util.List;

public interface IPessoaDAO {
 
    public boolean inserir(Pessoa p);
    public boolean atualizar(Pessoa p);
    public boolean deletar(Pessoa p);
    public List<Pessoa> listar();
   
}

package com.ifpb.atividadefixacao.easymock.controladores.parteI;

import com.ifpb.atividadefixacao.easymock.entidades.parteI.Pessoa;
import com.ifpb.atividadefixacao.easymock.interfaces.parteI.IPessoaDAO;
import java.util.List;

public class PessoaManager {

    IPessoaDAO ipessoaDao;

    public PessoaManager(IPessoaDAO ipessoaDao) {
        this.ipessoaDao = ipessoaDao;
    }

    public boolean validaDados(Pessoa p) {
        return (p.getCpf().length() == 14);
    }

    public boolean inserir(Pessoa p) {
        if (validaDados(p)) {
            return ipessoaDao.inserir(p);
        }
        return false;
    }

    public boolean atualizar(Pessoa p) {
        return ipessoaDao.atualizar(p);
    }

    public boolean deletar(Pessoa p) {
        return ipessoaDao.deletar(p);
    }

    public List<Pessoa> listar() {
        return ipessoaDao.listar();
    }

}
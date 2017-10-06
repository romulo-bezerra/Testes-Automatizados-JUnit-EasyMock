package com.ifpb.atividadefixacao.easymock.testes.parteI;

import com.ifpb.atividadefixacao.easymock.controladores.parteI.PessoaManager;
import com.ifpb.atividadefixacao.easymock.entidades.parteI.Pessoa;
import com.ifpb.atividadefixacao.easymock.interfaces.parteI.IPessoaDAO;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestePessoaManager {
    
    IPessoaDAO ipessoaDAO;
    PessoaManager pessoaManager;

    @Before
    public void setUp() {
        ipessoaDAO = EasyMock.createMock(IPessoaDAO.class);
        pessoaManager = new PessoaManager(ipessoaDAO);
    }
    
    @Test
    public void testeValidaDados1() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        //Ativa os obj mock
        EasyMock.replay(ipessoaDAO);

        //Chama ometodo a ser testado
        assertEquals(true, pessoaManager.validaDados(p));

        //Verifica se os obj mock foram chamados
        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeValidaDados2() {
        Pessoa p = new Pessoa("111.111.111-111", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        //Ativa os obj mock
        EasyMock.replay(ipessoaDAO);

        //Chama ometodo a ser testado
        assertEquals(false, pessoaManager.validaDados(p));

        //Verifica se os obj mock foram chamados
        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeInserirPessoa1() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        //Cria comportamento do obj
        EasyMock.expect(ipessoaDAO.inserir(p)).andReturn(true);

        //Ativa os obj mock
        EasyMock.replay(ipessoaDAO);

        //Chama ometodo a ser testado
        assertEquals(true, pessoaManager.inserir(p));

        //Verifica se os obj mock foram chamados
        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeInserirPessoa2() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        //Cria comportamento do obj
        EasyMock.expect(ipessoaDAO.inserir(p)).andReturn(false);

        //Ativa os obj mock
        EasyMock.replay(ipessoaDAO);

        //Chama ometodo a ser testado
        assertEquals(false, pessoaManager.inserir(p));

        //Verifica se os obj mock foram chamados
        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeAtualizarPessoa1() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        EasyMock.expect(ipessoaDAO.atualizar(p)).andReturn(true);

        EasyMock.replay(ipessoaDAO);

        assertEquals(true, pessoaManager.atualizar(p));

        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeAtualizarPessoa2() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        EasyMock.expect(ipessoaDAO.atualizar(p)).andReturn(false);

        EasyMock.replay(ipessoaDAO);

        assertEquals(false, pessoaManager.atualizar(p));

        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeDeletarPessoa1() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        EasyMock.expect(ipessoaDAO.deletar(p)).andReturn(true);

        EasyMock.replay(ipessoaDAO);

        assertEquals(true, pessoaManager.deletar(p));

        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeDeletarPessoa2() {
        Pessoa p = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");

        EasyMock.expect(ipessoaDAO.deletar(p)).andReturn(false);

        EasyMock.replay(ipessoaDAO);

        assertEquals(false, pessoaManager.deletar(p));

        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeListarPessoa1() {
        Pessoa p1 = new Pessoa("111.111.111-11", "Romulo", 20,
                "romulo@gmail.com", "111111111", "sem info");
        Pessoa p2 = new Pessoa("222.222.222-22", "Renan", 18,
                "renan@gmail.com", "222222222", "sem info");

        List<Pessoa> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        EasyMock.expect(ipessoaDAO.listar()).andReturn(list);

        EasyMock.replay(ipessoaDAO);

        assertEquals(list, pessoaManager.listar());

        EasyMock.verify(ipessoaDAO);
    }

    @Test
    public void testeListarPessoa2() {
        EasyMock.expect(ipessoaDAO.listar()).andReturn(null);

        EasyMock.replay(ipessoaDAO);

        assertEquals(null, pessoaManager.listar());

        EasyMock.verify(ipessoaDAO);
    }

}

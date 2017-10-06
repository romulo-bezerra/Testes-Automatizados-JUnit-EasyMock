package com.ifpb.atividadefixacao.easymock.testes.parteII;

import com.ifpb.atividadefixacao.easymock.controladores.parteII.PortfolioProduto;
import com.ifpb.atividadefixacao.easymock.entidades.parteII.Produto;
import com.ifpb.atividadefixacao.easymock.interfaces.parteII.IPrecoProdutoServico;
import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestePortfolioProduto {

    IPrecoProdutoServico iPrecoProdutoServico;
    PortfolioProduto portfolioProduto;

    @Before
    public void setUp() {
        iPrecoProdutoServico = EasyMock.createMock(IPrecoProdutoServico.class);
        portfolioProduto = new PortfolioProduto(iPrecoProdutoServico);
    }

    @Test
    public void testeAdicionaProduto() {
        Produto p = new Produto(0, "sabão", 1);

        //Ativa os obj mock
        EasyMock.replay(iPrecoProdutoServico);

        //Chama ometodo a ser testado
        assertEquals(true, portfolioProduto.addProduto(p));

        //Verifica se os obj mock foram chamados
        EasyMock.verify(iPrecoProdutoServico);
    }

    @Test
    public void testeGetValorPortfolio1() {
        Produto p1 = new Produto(0, "sabão", 1);
        Produto p2 = new Produto(1, "café", 1);

        portfolioProduto.addProduto(p1);
        portfolioProduto.addProduto(p2);

        //Cria comportamento do obj
        EasyMock.expect(iPrecoProdutoServico.getPrecoProduto(p1)).andReturn(2.5);
        EasyMock.expect(iPrecoProdutoServico.getPrecoProduto(p2)).andReturn(2.5);

        //Ativa os obj mock
        EasyMock.replay(iPrecoProdutoServico);

        //Chama ometodo a ser testado
        assertEquals(5, portfolioProduto.getValorPortfolio(), 0.1);

        //Verifica se os obj mock foram chamados
        EasyMock.verify(iPrecoProdutoServico);
    }

    @Test
    public void testeGetValorPortfolio2() {
        Produto p1 = new Produto(0, "sabão", 2);
        Produto p2 = new Produto(1, "café", 2);

        portfolioProduto.addProduto(p1);
        portfolioProduto.addProduto(p2);

        //Cria comportamento do obj
        EasyMock.expect(iPrecoProdutoServico.getPrecoProduto(p1)).andReturn(2.5);
        EasyMock.expect(iPrecoProdutoServico.getPrecoProduto(p2)).andReturn(2.5);

        //Ativa os obj mock
        EasyMock.replay(iPrecoProdutoServico);

        //Chama ometodo a ser testado
        assertEquals(10, portfolioProduto.getValorPortfolio(), 0.1);

        //Verifica se os obj mock foram chamados
        EasyMock.verify(iPrecoProdutoServico);
    }

    @Test
    public void testeGetProdutos() {
        Produto p1 = new Produto(0, "sabão", 2);
        Produto p2 = new Produto(1, "café", 2);

        portfolioProduto.addProduto(p1);
        portfolioProduto.addProduto(p2);

        EasyMock.replay(iPrecoProdutoServico);

        assertEquals(2, portfolioProduto.getProdutos().size());

        EasyMock.verify(iPrecoProdutoServico);
    }

}

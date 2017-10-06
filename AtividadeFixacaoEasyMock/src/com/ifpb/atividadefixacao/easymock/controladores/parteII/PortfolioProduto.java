
package com.ifpb.atividadefixacao.easymock.controladores.parteII;

import com.ifpb.atividadefixacao.easymock.entidades.parteII.Produto;
import com.ifpb.atividadefixacao.easymock.interfaces.parteII.IPrecoProdutoServico;
import java.util.ArrayList;
import java.util.List;

public class PortfolioProduto {
    
    private IPrecoProdutoServico iPrecoProdutoServico;
    private List<Produto> produtos;
    
    public PortfolioProduto(){
        this.produtos = new ArrayList<>();
    }
    
    public PortfolioProduto(IPrecoProdutoServico iPrecoProdutoServico){
        this.iPrecoProdutoServico = iPrecoProdutoServico;
        this.produtos = new ArrayList<>();
    }
    
    public boolean addProduto(Produto p){
        return produtos.add(p);
    }
    
    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public double getValorPortfolio(){
        double valor = 0;
        for (Produto p : produtos) {
            valor += p.getQuantidade() * iPrecoProdutoServico.getPrecoProduto(p);
        }
        return valor;
    }
 
}

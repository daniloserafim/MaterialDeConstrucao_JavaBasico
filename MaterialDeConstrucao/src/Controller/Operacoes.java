package Controller;

import java.util.ArrayList;
import View.*;
import Model.*;

public class Operacoes {

	private static int geradorCodigo = 0;

	static ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

	static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

	public static void cadastrarProduto() {

		int quantidadeProdutos = EntradaSaida.solicitaQuantidadeProdutos();

		for (int i = 0; i < quantidadeProdutos; i++) {
			Produto produto = new Produto();

			geradorCodigo += 1;

			produto.setCodigo(geradorCodigo);
			produto.setNome(EntradaSaida.solicitaNome());
			produto.setDescricao(EntradaSaida.solicitaDescricao());
			produto.setPreco(EntradaSaida.solicitaPreco());
			produto.setQuantidade(EntradaSaida.solicitaQuantidadeProduto());
			listaDeProdutos.add(produto);
		}
	}
	
	public static void adicionarProduto() {
		
		if (!listaDeProdutos.isEmpty()) {
		
		String[] opcoes = new String[listaDeProdutos.size()];
		int i = 0;
		for (Produto produto : listaDeProdutos) {
			opcoes[i] = produto.getNome();
			i++;
		}
		
		int opcao = EntradaSaida.solicitaProdutoAdicionado(opcoes);
		int quantidadeAAdicionar = EntradaSaida.solicitaQuantidadeAAdicionar();
		int quantidadeAtual = listaDeProdutos.get(opcao).getQuantidade();
		
		int quantidadeTotal = quantidadeAtual + quantidadeAAdicionar;
		listaDeProdutos.get(opcao).setQuantidade(quantidadeTotal);
		EntradaSaida.produtoAdicionadoMsg(opcoes[opcao], quantidadeAAdicionar, quantidadeTotal);		
		} else {
			EntradaSaida.estoqueVazioMsg();
		}		
	}

	public static void verEstoque() {

		if (!listaDeProdutos.isEmpty()) {

			String listaDeProdutosString = "";

			// int totalProdutos = listaDeProdutos.size();

			for (Produto produto : listaDeProdutos) {
				listaDeProdutosString += "Código: " + produto.getCodigo() + "\nNome: " + produto.getNome()
						+ "\nDescricao: " + produto.getDescricao() + "\nQuantidade em estoque: "
						+ produto.getQuantidade() + "\nPreço: " + produto.getPreco() + "\n\n";
			}

			EntradaSaida.mostraEstoque(listaDeProdutosString);
		} else {
			EntradaSaida.estoqueVazioMsg();
		}
	}

	public static void venderProduto() {

		if (!listaDeProdutos.isEmpty()) {

			String[] opcoes = new String[listaDeProdutos.size()];
			int i = 0;
			for (Produto produto : listaDeProdutos) {
				opcoes[i] = produto.getNome();
				i++;
			}

			int opcao = EntradaSaida.solicitaProdutoVendido(opcoes);
			int quantidadeAVender = EntradaSaida.solicitaQuantidadeAVender();
			int quantidadeAtual = listaDeProdutos.get(opcao).getQuantidade();

			if (quantidadeAVender <= quantidadeAtual) {
				int quantidadeRestante = quantidadeAtual - quantidadeAVender;
				listaDeProdutos.get(opcao).setQuantidade(quantidadeRestante);
				EntradaSaida.vendaRealizadaMsg(opcoes[opcao], quantidadeAVender, quantidadeRestante);

				double valorDaVenda = listaDeProdutos.get(opcao).getPreco() * quantidadeAVender;
				gerarMovimentacao(valorDaVenda, quantidadeAVender, listaDeProdutos.get(opcao).getNome());
			} else {
				EntradaSaida.semEstoqueMsg();
			}
		} else {
			EntradaSaida.estoqueVazioMsg();
		}
	}

	public static void gerarMovimentacao(double valorDaVenda, int quantidadeVendida, String nomeDoProduto) {
		Movimentacao movimentacao = new Movimentacao();

		movimentacao.setValor(valorDaVenda);
		movimentacao.setData();
		movimentacao.setQuantidadeVendida(quantidadeVendida);
		movimentacao.setNomeDoProduto(nomeDoProduto);
		movimentacoes.add(movimentacao);
	}

	public static void verExtratoVendas() {
		String listaExtrato = "";

		for (Movimentacao movimentacao : movimentacoes) {
			listaExtrato += "Valor da venda: "+movimentacao.getValor() + "\nData: " + movimentacao.getData() + "\nQuantidade vendida: "
					+ movimentacao.getQuantidadeVendida() + "\nProduto:" + movimentacao.getNomeDoProduto() + "\n\n";
		}
		EntradaSaida.exibeExtratoVendas(listaExtrato);
	}

	public static void verCaixa() {
		double caixaTotal = 0;
		for (Movimentacao movimentacao : movimentacoes) {
			caixaTotal += movimentacao.getValor();
		}
		EntradaSaida.exibeCaixa(caixaTotal);
	}

}

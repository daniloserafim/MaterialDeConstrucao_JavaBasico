package View;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Cadastrar Produto", "Adicionar Produtos", "Ver Estoque", "Vender Produto", "Ver Extrato de Vendas", "Ver Caixa", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	
	public static int solicitaQuantidadeProdutos() {
		
		int numeroDeProdutos = 0;

		do {
			numeroDeProdutos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos a serem cadastrados"));

			if (numeroDeProdutos <= 0) {
				JOptionPane.showMessageDialog(null, "É necessário informar um valor maior que 0!");
			}

		} while (numeroDeProdutos <= 0);

		return numeroDeProdutos;
	}
	
	public static String solicitaNome() {
		String nome = JOptionPane.showInputDialog("Informe o nome do produto");
		return nome;
	}
	
	public static String solicitaDescricao() {
		String descricao = JOptionPane.showInputDialog("Informe a descrição do produto");
		return descricao;
	}
	
	public static double solicitaPreco() {
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto"));
		return preco;
	}
	
	public static int solicitaQuantidadeProduto() {
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de unidades que entrarão para o estoque"));
		return quantidade;
	}
	
	public static void mostraEstoque(String listaDeProdutos) {
		JOptionPane.showMessageDialog(null, listaDeProdutos);
	}
	
	public static int solicitaProdutoVendido(String[] opcoes) {				
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	
	public static int solicitaQuantidadeAVender() {
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de unidades serão vendidas"));
		return quantidade;
	}
	
	public static void vendaRealizadaMsg(String produto, int quantidadeVendida, int quantidadeRestante) {
		JOptionPane.showMessageDialog(null, "Você vendeu "+quantidadeVendida+" unidades do produto: "+produto+", restando um total de: "+quantidadeRestante+" unidades em estoque.");
	}
	
	public static void semEstoqueMsg() {
		JOptionPane.showMessageDialog(null, "Este produto não possui tantas unidades em estoque!");
	}
	
	public static void estoqueVazioMsg() {
		JOptionPane.showMessageDialog(null, "O estoque está vazio!");
	}
	
	public static void exibeExtratoVendas(String listaExtrato) {
		JOptionPane.showMessageDialog(null, listaExtrato);
	}
	
	public static void exibeCaixa(double caixaTotal) {
		JOptionPane.showMessageDialog(null, "O valor total do seu caixa é de: R$"+caixaTotal);
	}
	
	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}
	
	public static int solicitaProdutoAdicionado(String[] opcoes) {
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	
	public static int solicitaQuantidadeAAdicionar() {
		int numeroDeProdutos = 0;

		do {
			numeroDeProdutos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos a serem adicionados"));

			if (numeroDeProdutos <= 0) {
				JOptionPane.showMessageDialog(null, "É necessário informar um valor maior que 0!");
			}

		} while (numeroDeProdutos <= 0);

		return numeroDeProdutos;
	}
	
	public static void produtoAdicionadoMsg(String produto, int quantidadeAAdicionar, int quantidadeTotal) {
		JOptionPane.showMessageDialog(null, "Você adicionou "+quantidadeAAdicionar+" unidades do produto: "+produto+", somando um total de: "+quantidadeTotal+" unidades em estoque.");
	}
}

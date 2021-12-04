package Controller;

import View.*;

public class Controladora {	
	
	public void iniciaApp() {
		exibeMenu();
	}
	
	public void exibeMenu() {
		
		int opcao;
		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				Operacoes.cadastrarProduto();
				break;
			case 1:
				Operacoes.adicionarProduto();
				break;
			case 2:
				Operacoes.verEstoque();
				break;
			case 3:
				Operacoes.venderProduto();
				break;
			case 4:
				Operacoes.verExtratoVendas();
				break;
			case 5:
				Operacoes.verCaixa();
				break;
			case 6:
				EntradaSaida.exibeMsgEncerraPrograma();
				break;
			}
		} while (opcao != 6);
	}
}

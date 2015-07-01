package Enums;

public enum enumTipoProduto {
	TODAS_OFERTAS(1), ALIMENTACAO(2), SAUDE(3), FITNESS(4), CURSOS(5), CLASSIFICADOS(6);
	
	private int opc;
	private enumTipoProduto(int opc) {
		this.opc = opc;		
	}
	public int getOpc() {
		return this.opc;
	}
	
}

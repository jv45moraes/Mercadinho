package Model;

public class ProdutoVenda {
	private String idProdutoVenda;
	private String idVenda;
	private String idProduto;
	private String quantidade;
	
	public ProdutoVenda() {
		super();
	}
	public ProdutoVenda(String idProdutoVenda, String idVenda, String idProduto, String quantidade) {
		super();
		this.idProdutoVenda = idProdutoVenda;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	public String getIdProdutoVenda() {
		return idProdutoVenda;
	}
	public void setIdProdutoVenda(String idProdutoVenda) {
		this.idProdutoVenda = idProdutoVenda;
	}
	public String getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}

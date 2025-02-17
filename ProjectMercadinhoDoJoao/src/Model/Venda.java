package Model;

public class Venda {
	private String idVenda;
	private String idCliente;
	private String idFuncionario;
	private String formaPGTO;
	private String desconto;
	private String dataVend;
	private String valorTotal;
	
	public Venda() {
		super();
	}
	public Venda(String idVenda, String idCliente, String idFuncionario, String formaPGTO, String desconto,
			String dataVend, String valorTotal) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
		this.formaPGTO = formaPGTO;
		this.desconto = desconto;
		this.dataVend = dataVend;
		this.valorTotal = valorTotal;
	}
	public String getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getFormaPGTO() {
		return formaPGTO;
	}
	public void setFormaPGTO(String formaPGTO) {
		this.formaPGTO = formaPGTO;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getDataVend() {
		return dataVend;
	}
	public void setDataVend(String dataVend) {
		this.dataVend = dataVend;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}

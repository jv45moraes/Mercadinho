package Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import Model.Funcionario;
import Model.Produto;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class controllerMain implements Initializable{

    @FXML
    private Button btClientes;

    @FXML
    private Button btFornecedores;

    @FXML
    private Button btFuncionarios;

    @FXML
    private Button btMain;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRegistrarVenda;

    @FXML
    private Button btRelatorioVenda;

    @FXML
    private Button btSair;

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private Label txtTotalVendido;
    
    @FXML
    private Label txtUser;
    
    @FXML
    private TableColumn<Produto, String> columnCodBarra;

    @FXML
    private TableColumn<Produto, String> columnCodBarraAVencer;

    @FXML
    private TableColumn<Produto, String> columnDataFab;

    @FXML
    private TableColumn<Produto, String> columnDataFabAVencer;

    @FXML
    private TableColumn<Produto, String> columnDataVal;

    @FXML
    private TableColumn<Produto, String> columnDataValAVencer;

    @FXML
    private TableColumn<Produto, String> columnEstoque;

    @FXML
    private TableColumn<Produto, String> columnEstoqueAVencer;

    @FXML
    private TableColumn<Produto, String> columnIndice;

    @FXML
    private TableColumn<Produto, String> columnIndiceAVencer;

    @FXML
    private TableColumn<Produto, String> columnProduto;

    @FXML
    private TableColumn<Produto, String> columnProdutoAVencer;

    @FXML
    private TableView<Produto> tableProdutosAVencer;

    private ObservableList<Produto> ArrayProdutosAVencer;
    private ObservableList<Produto> ArrayProdutos;

    @FXML
    void logOut(ActionEvent event) {
    	Main.changeScreen("login");
    }

    @FXML
    void telaCliente(ActionEvent event) throws IOException {
    	Main.TelaCliente();
    }

    @FXML
    void telaFornecedor(ActionEvent event) {

    }

    @FXML
    void telaFuncionario(ActionEvent event) {

    }

    @FXML
    void telaMain(ActionEvent event) {

    }

    @FXML
    void telaProduto(ActionEvent event) {

    }

    @FXML
    void telaRelatorioVenda(ActionEvent event) {

    }

    @FXML
    void telaVenda(ActionEvent event) {

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		String totalVendido;
		totalVendido = funcionarioDAO.getTotalVendido(controllerLogin.funcionario.getId());
		
		double valorTotal = Double.parseDouble(totalVendido);
		totalVendido = String.format("%.2f", valorTotal);
		
		txtTotalVendido.setText("R$ "+ totalVendido);
		txtUser.setText("Usuário: "+controllerLogin.funcionario.getNome());
		carregarTableProdutos();
		carregarTableProdutosAVencer();
	}
	
	private void carregarTableProdutos() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayProdutos = FXCollections.observableList(produtoDAO.getByEstoque());
		
		columnIndice.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnCodBarra.setCellValueFactory(new PropertyValueFactory<>("codBarra"));
		columnDataFab.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataVal.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		
		tableProdutos.setItems(ArrayProdutos);
	}
	
	private void carregarTableProdutosAVencer() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayProdutosAVencer = FXCollections.observableList(produtoDAO.getByDataVal());
		
		columnIndiceAVencer.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnProdutoAVencer.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnCodBarraAVencer.setCellValueFactory(new PropertyValueFactory<>("codBarra"));
		columnDataFabAVencer.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataValAVencer.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnEstoqueAVencer.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		
		tableProdutosAVencer.setItems(ArrayProdutosAVencer);
	}
	

}

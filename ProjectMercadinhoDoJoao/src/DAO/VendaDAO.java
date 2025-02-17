package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Venda;

public class VendaDAO {
    
    public void create(Venda venda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        try {
        	stmt = con.prepareStatement("INSERT INTO Venda VALUES(?, ?, ?, ?, ?, ?)");
        		stmt.setString(1, venda.getIdCliente());
        		stmt.setString(2, venda.getIdFuncionario());
        		stmt.setString(3, venda.getFormaPGTO());
        		stmt.setString(4, venda.getDesconto());
        		stmt.setString(5, venda.getDataVend());
        		stmt.setString(6, venda.getValorTotal());

            
            stmt.executeUpdate();
            System.out.println("Venda cadastrada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar a venda!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Venda> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Venda");
            rs = stmt.executeQuery();
     
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setDataVend(rs.getString(1));
                venda.setIdCliente(rs.getString(2));
                venda.setIdFuncionario(rs.getString(3));
                venda.setFormaPGTO(rs.getString(4));
                venda.setDesconto(rs.getString(5));
                venda.setDataVend(rs.getString(6));
                venda.setValorTotal(rs.getString(7));
                
                vendas.add(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler as vendas!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        
        return vendas;
    }
    
    public ArrayList<Venda> search(Venda vendaFiltro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Venda WHERE idCliente = ? OR idFuncionario = ?");
            stmt.setString(1, vendaFiltro.getIdCliente());
            stmt.setString(2, vendaFiltro.getIdFuncionario());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setDataVend(rs.getString(1));
                venda.setIdCliente(rs.getString(2));
                venda.setIdFuncionario(rs.getString(3));
                venda.setFormaPGTO(rs.getString(4));
                venda.setDesconto(rs.getString(5));
                venda.setDataVend(rs.getString(6));
                venda.setValorTotal(rs.getString(7));
                
                vendas.add(venda); 
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar as vendas!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        
        return vendas;
    }
    
    public void update(Venda venda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Venda SET idClienteVenda = ?, idFuncionarioVenda = ?, idFormaDePagamentoVenda = ?, descontoVenda = ?, dataVendaVenda = ?, precoTotalVenda = ? WHERE idVenda = ?");
            stmt.setString(1, venda.getIdCliente());
            stmt.setString(2, venda.getIdFuncionario());
            stmt.setString(3, venda.getFormaPGTO());
            stmt.setString(4, venda.getDesconto());
            stmt.setString(5, venda.getIdVenda());
            stmt.setString(6, venda.getValorTotal());
            stmt.setString(7, venda.getIdVenda());
            
            stmt.executeUpdate();
            System.out.println("Venda atualizada!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    
    public void delete(Venda venda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        try {    
            stmt = con.prepareStatement("DELETE FROM Venda WHERE idVenda = ?");
            stmt.setString(1, venda.getIdVenda());
            
            stmt.executeUpdate();
            System.out.println("Venda excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir venda!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
}

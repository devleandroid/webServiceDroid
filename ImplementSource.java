package br.service.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ImplementSource {

  Connection con;
		
	public ImplementSource() {
		try {
			con =  Connector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	//Consulta nome do paciente
	/**
	 * @param nome Paciente
	 * @return
	 * @throws SQLException
	 */
	public String[] selectPaciente(String nome)throws SQLException {

		String[] retorno = null;
		ArrayList<String> dados = new ArrayList<String>();
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();//consulta de registro do paciente
			ResultSet result = stmt.executeQuery("SELECT * FROM tb_paciente WHERE nome LIKE '"+ nome +"%'");
			System.out.println("Resultados");
			
			while (result.next()) {
				
				dados.add(result.getString("data"));
				dados.add(result.getString("nome"));
				dados.add(result.getString("idade"));
				dados.add(result.getString("registro"));
				dados.add(result.getString("descricao"));
				dados.add(result.getString("dose_vol"));
				dados.add(result.getString("via"));
				dados.add(result.getString("frequencia"));
				dados.add(result.getString("hora"));
				
				retorno = (String[]) dados.toArray(new String[dados.size()]);	
				
				
			}
			System.out.println(nome);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()); 
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally{
			Connector.closeStatement(stmt);
			Connector.closeJDBC(con);
		}
		return retorno;
	}
	
	//consulta o registro do paciente
	/**
	 * @param registro
	 * @return
	 * @throws SQLException
	 */
	public String[] selectRegistro(int registro)throws SQLException {

		String[] retorno = null;
		ArrayList<String> dados = new ArrayList<String>();
		Statement stmt = null;

		try {
			stmt = con.createStatement();//consulta de registro do paciente
			ResultSet result = stmt.executeQuery("SELECT * FROM tb_paciente WHERE registro = '"+ registro +"'");
			System.out.println("Resultados");
			
			while (result.next()) {
				dados.add(result.getString("data"));
				dados.add(result.getString("nome"));
				dados.add(result.getString("idade"));
				dados.add(result.getString("registro"));
				dados.add(result.getString("descricao"));
				dados.add(result.getString("dose_vol"));
				dados.add(result.getString("via"));
				dados.add(result.getString("frequencia"));
				dados.add(result.getString("hora"));
				
				retorno = (String[]) dados.toArray(new String[dados.size()]);
			}
			System.out.println(registro);
		} catch (SQLException e) {
			System.out.println(e.getMessage());//JOptionPane.showMessageDialog(null, e.getMessage());
		}finally{
			Connector.closeStatement(stmt);
			Connector.closeJDBC(con);
		}
		
		return retorno;
	}
	//consulta nome do medicamento
	/**
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public String[] selectMedicamento(String remedio)throws SQLException {

		String[] retorno = null;
		ArrayList<String> dados = new ArrayList<String>();
				
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();//consulta de registro do paciente
			ResultSet result = stmt.executeQuery("SELECT * FROM tb_medicamento WHERE nome_remedio LIKE '"+ remedio +"%'");
			System.out.println("Resultados");
			
			while (result.next()) {

				dados.add(result.getString("nome_remedio"));
				dados.add(result.getString("codigo"));
				dados.add(result.getString("nome_paciente"));
				
				retorno = (String[]) dados.toArray(new String[dados.size()]);
			}
			System.out.println(remedio);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());//JOptionPane.showMessageDialog(null, e.getMessage());
		}finally{
			Connector.closeStatement(stmt);
			Connector.closeJDBC(con);
		}
		return retorno;
	}
	
	//consulta codigo do medicamento
	/**
	 * @param codigo
	 * @return
	 * @throws SQLException
	 */
	public String[] selectCodigo(int codigo)throws SQLException {
		
		String[] retorno = null;
		ArrayList<String> dados = new ArrayList<String>();
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();//consulta de codigo de barras do paciente
			ResultSet result = stmt.executeQuery("SELECT * FROM tb_medicamento WHERE codigo = '"+ codigo +"'");
			System.out.println("Resultados");
			
			while (result.next()) {
				dados.add(result.getString("nome_remedio"));
				dados.add(result.getString("codigo"));
				dados.add(result.getString("nome_paciente"));
				
				retorno = (String[]) dados.toArray(new String[dados.size()]);
			}
			System.out.println(codigo);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());//JOptionPane.showMessageDialog(null, e.getMessage());
		}finally{
			Connector.closeStatement(stmt);
			Connector.closeJDBC(con);
		}
		return retorno;
	} 
}

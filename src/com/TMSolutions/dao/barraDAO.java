package com.TMSolutions.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMSolutions.cxdb.Conexion;
import com.TMSolutions.model.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



//import java.sql.ResultSet;

public class barraDAO {
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	// guardar barra
	public boolean guardar(Main barra) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO main (ID, in_date, ID_mineral, ID_status, or_weight, or_purity, up_date) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setDate(2, barra.getIn_date());
			statement.setInt(3, barra.getID_mineral());
			statement.setInt(4, barra.getID_status());
			statement.setDouble(5, barra.getOr_weight());
			statement.setDouble(6, barra.getOr_purity());
			statement.setDate(7, barra.getUp_date());
			
			estadoOperacion = statement.executeUpdate() > 0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	// editar barra
	public boolean editar(Main barra) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE main SET ID_status = ?, up_date = ? "
					+ "WHERE ID = ?";
			
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, barra.getID_status());
			statement.setDate(2, barra.getUp_date());
			statement.setInt(3, barra.getID());
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	// eliminar barra
	public boolean eliminar(int ID) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM main WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, ID);
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	// listar todas las barras
	public List<Main> obtenerBarras() throws SQLException {
		ResultSet resultSet = null;
		List<Main> listaBarras = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			
			sql = "SELECT * FROM main";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
		
			while (resultSet.next()) {
				
				Main b = new Main();
				
				b.setID(resultSet.getInt(1));
				b.setIn_date(resultSet.getDate(2));
				b.setID_mineral(resultSet.getInt(3));
				b.setID_status(resultSet.getInt(4));
				b.setOr_weight(resultSet.getDouble(5));
				b.setOr_purity(resultSet.getDouble(6));
				b.setUp_date(resultSet.getDate(7));
				
				listaBarras.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaBarras;
	}
	
	// obtener una barra
	public Main obtenerBarra(int ID) throws SQLException {
		ResultSet resultSet = null;
		Main b = new Main();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			
			sql = "SELECT * FROM main WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			
			resultSet = statement.executeQuery();
		
			if(resultSet.next()) {
				
				b.setID(resultSet.getInt(1));
				b.setIn_date(resultSet.getDate(2));
				b.setID_mineral(resultSet.getInt(3));
				b.setID_status(resultSet.getInt(4));
				b.setOr_weight(resultSet.getDouble(5));
				b.setOr_purity(resultSet.getDouble(6));
				b.setUp_date(resultSet.getDate(7));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;

	}
	
	// obtener conexión pool
	private Connection obtenerConexion( ) throws SQLException {
		return Conexion.getConnection();
	}
	
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.UtenteBean;

public class UtenteBeanDAO {
	
	public synchronized boolean doSave(UtenteBean ub) {
		String username = ub.getUsername();
		String password = ub.getPassword();
		String nome = ub.getNome();
		String cognome = ub.getCognome();
		String tipo = ub.getTipo();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "INSERT INTO utente (username, password, nome, cognome, tipo) values (?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, nome);
			ps.setString(4, cognome);
			ps.setString(5, tipo);
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			return false;
		} finally {
			try {
				DriverManagerConnectionPool.releaseConnection(conn);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized UtenteBean doRetrieveByKey(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			UtenteBean ub = new UtenteBean();
			ub.setUsername(username);
			ub.setPassword(password);
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM utente WHERE username=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet res = ps.executeQuery();
			
				if(res.next()) {
					ub.setNome(res.getString("nome"));
					ub.setCognome(res.getString("cognome"));
					ub.setTipo(res.getString("tipo"));
					
					return ub;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	
	public synchronized UtenteBean doRetrieveByOneKey(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			UtenteBean ub = new UtenteBean();
			ub.setUsername(username);
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM utente WHERE username=?");
			
			ps.setString(1, username);
			
			ResultSet res = ps.executeQuery();
			
				if(res.next()) {
					ub.setNome(res.getString("nome"));
					ub.setPassword(res.getString("password"));
					ub.setCognome(res.getString("cognome"));
					ub.setTipo(res.getString("tipo"));
					
					return ub;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	
	
	
	public synchronized boolean doUpdate(UtenteBean ub) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "UPDATE utente SET password=?, nome=?, cognome=?, tipo=? WHERE username=?";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, ub.getPassword());
			ps.setString(2, ub.getNome());
			ps.setString(3, ub.getCognome());
			ps.setString(4, ub.getTipo());
			ps.setString(5, ub.getUsername());
			
			ps.executeUpdate();
		
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
		
	public synchronized boolean doDelete(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
			
		try {	
			conn = DriverManagerConnectionPool.getConnection(); 
				
			String query = "DELETE FROM utente WHERE username=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, username);
				
			int i = ps.executeUpdate();
			if(i != 0) 
				return true;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public ArrayList<UtenteBean> doRetrieveAllCameriere() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			ArrayList<UtenteBean> ubs = new ArrayList<>();
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM utente WHERE tipo=? ORDER BY nome ASC");
			
			ps.setString(1, "cameriere");
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				UtenteBean ub = new UtenteBean();
				ub.setUsername(res.getString("username"));
				ub.setNome(res.getString("nome"));
				ub.setPassword(res.getString("password"));
				ub.setCognome(res.getString("cognome"));
				ub.setTipo("cameriere");
				ubs.add(ub);
			}
			return ubs; 
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

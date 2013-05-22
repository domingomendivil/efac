package xg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

import uy.gub.dgi.dao.AbstractDAO;
import uy.gub.dgi.dao.DAOException;
import uy.gub.dgi.dao.Filter;
import xg.beans.CFEBean;
import xg.beans.SobreBean;
import xg.xml.XMLMarshallerImpl;

public class SobreDAO extends AbstractDAO{
	
	

	@Override
	public void delete(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getByFilter(Filter arg0, Class arg1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(Filter arg0) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList getTotals(String arg0, String arg1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getTotals(Filter arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
/**	private void insertSobreRespuesta(SobreBean sobre){
			SobreBean cfe= (SobreBean)sobre;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("INSERT INTO SOBRES_RESPUESTAS VALUES (?,?)");
	                ps.setInt(1,sobre.getEnvioCFE().getCaratula().getIdemisor().intValue());
	                
	                int nro = ps.executeUpdate();
	                if (nro>=0){
	                    
	                }else{
	                	throw new DAOException("ERROR EN INSERT TABLA CFE");
	                }
	            } catch (Exception e1) {
	                throw new DAOException(e1);
	            } finally {
	                closeConnection(conn);
	            }
	        }else{
	        	throw new DAOException("ERROR AL OBTENER LA CONEXION A LA BD");
	        }
	}**/

	@Override
	public void insert(Object arg0) throws DAOException {
		if (arg0 instanceof SobreBean){
			SobreBean sobre= (SobreBean)arg0;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("INSERT INTO SOBRES VALUES(?,?,?)");
	                ps.setInt(1,sobre.getEnvioCFE().getCaratula().getIdemisor().intValue());
	                ps.setString(2,new XMLMarshallerImpl().unmarshall(sobre.getEnvioCFE()));
	                ps.setInt(3,SobreBean.ESTADO_DGI_SIN_ENVIAR);
	                int nro = ps.executeUpdate();
	                if (nro>=0){
	                }else{
	                	throw new DAOException("ERROR EN INSERT TABLA SOBRE");
	                }
	            } catch (Exception e1) {
	                throw new DAOException(e1);
	            } finally {
	                closeConnection(conn);
	            }
	        }else{
	        	throw new DAOException("ERROR AL OBTENER LA CONEXION A LA BD");
	        }
		}
		
	}

	@Override
	public void update(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		if (arg0 instanceof SobreBean){
			SobreBean sobre= (SobreBean)arg0;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("UPDATE SOBRES SET estadoDGI=? WHERE ID=?");
	                ps.setInt(1,sobre.getEstadoDGI());
	                ps.setInt(2,sobre.getEnvioCFE().getCaratula().getIdemisor().intValue());
	                int nro = ps.executeUpdate();
	                if (nro>=0){
	                    
	                }else{
	                	throw new DAOException("ERROR EN UPDATE TABLA SOBRES");
	                }
	            } catch (Exception e1) {
	                throw new DAOException(e1);
	            } finally {
	                closeConnection(conn);
	            }
	        }else{
	        	throw new DAOException("ERROR AL OBTENER LA CONEXION A LA BD");
	        }
		}
		
	}

}

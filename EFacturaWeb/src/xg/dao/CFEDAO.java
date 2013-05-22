package xg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Timestamp;
import java.util.ArrayList;

import uy.gub.dgi.cfe.ACKCFEdefType;
import uy.gub.dgi.cfe.CFEDefType;
import uy.gub.dgi.dao.AbstractDAO;
import uy.gub.dgi.dao.DAOException;
import uy.gub.dgi.dao.Filter;
import xg.beans.CFEBean;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLMarshallerException;

public class CFEDAO extends AbstractDAO {

	@Override
	public void delete(Object arg0) throws DAOException {
		
	}

	@Override
	public ArrayList getAll() throws DAOException {
		// TODO Auto-generated method stub
		
		ArrayList lista = new ArrayList();
        Connection conn = getConexion();
        if (conn != null){            
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement("SELECT * from CFE");
                rs = ps.executeQuery();
                while (rs.next()){
                	CFEBean cfe = getCFE(rs);
                	lista.add(cfe);
                   
                }
                return lista;
            } catch (Exception e1) {
                throw new DAOException(e1);
            } finally {
                closeConnection(conn);
            }
        }else{
        	return null;
        }
	}

	private CFEBean getCFE(ResultSet rs) throws SQLException, XMLMarshallerException {
		String xmlCFERes = rs.getString("xmlCFE");
		System.out.println("xml "+xmlCFERes);
		CFEBean cfe = new CFEBean(xmlCFERes);
		cfe.setTipoCFE(rs.getInt("tipoCFE"));
		cfe.setCodigoSucursal(rs.getInt("codigoSucursal"));
		cfe.setTimeStamp(rs.getTimestamp("fecha"));
		String xmlRes =rs.getString("xmlACK");
		if (xmlRes!=null)
			cfe.setAckCFE((ACKCFEdefType)new XMLMarshallerImpl().marshall(ACKCFEdefType.class, xmlRes));
		if (xmlCFERes!=null)
			cfe.setCfe((CFEDefType)new XMLMarshallerImpl().marshall(CFEDefType.class, xmlCFERes));
		return cfe;
	}

	@Override
	public ArrayList getByFilter(Filter arg0, Class arg1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		if (arg0 instanceof CFEBean){
			CFEBean cfe= (CFEBean)arg0;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("INSERT INTO CFE VALUES (CURRENT_TIMESTAMP,?,?,?,?,?,?");
	                ps.setInt(1,cfe.getTipoCFE());
	                ps.setBigDecimal(2,cfe.getMontoTotal());
	                ps.setString(3,new XMLMarshallerImpl().unmarshall(cfe.getCfe()));
	                ps.setString(4, new XMLMarshallerImpl().unmarshall(cfe.getAckCFE()));
	                ps.setInt(5,cfe.getEstado());
	                ResultSet rs = ps.executeQuery();
	                if (rs.next()){
	                	CFEBean res = getCFE(rs);
	                	return res;
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
		}else{
			throw new DAOException("ERROR EN CASTEO TABLA CFE");
		}
	}

	@Override
	public int getCount(Filter arg0) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList getTotals(String arg0, String arg1) throws DAOException {
		// TODO Auto-generated method stub
		
		ArrayList lista = new ArrayList();
        Connection conn = getConexion();
        if (conn != null){            
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement("SELECT sum(as) as montoTotal "+" group by "+arg0+" having ");
                rs = ps.executeQuery();
                if (rs.next()){
                 //   AccionBean accion = getAccion(rs);
               //     lista.add(accion);
                    return lista;
                }else{
                	return null;
                }
            } catch (SQLException e1) {
                throw new DAOException(e1);
            } finally {
                closeConnection(conn);
            }
        }else{
        	return null;
        }
	}

	@Override
	public void insert(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		if (arg0 instanceof CFEBean){
			CFEBean cfe= (CFEBean)arg0;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("INSERT INTO CFE VALUES(CURRENT_TIMESTAMP,?,?,?,?,?,?)");
	                ps.setInt(1,cfe.getTipoCFE());
	                ps.setBigDecimal(2,cfe.getMontoTotal());
	                ps.setString(3,getStringXML((cfe.getCfe())));
	                ps.setString(4, getStringXML(cfe.getAckCFE()));
	                ps.setInt(5,cfe.getEstado());
	                ps.setInt(6,cfe.getCodigoSucursal());
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
		}

	}

	@Override
	public void update(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		if (arg0 instanceof CFEBean){
			CFEBean cfe= (CFEBean)arg0;
	        Connection conn = getConexion();
	        if (conn != null){            
	            PreparedStatement ps = null;
	            try {
	                ps = conn.prepareStatement("UPDATE CFE SET xmlCFE=?, xmlACK=?, estado=? WHERE fecha=?");
	                ps.setString(1,getStringXML(cfe.getCfe()));
	                ps.setString(2, getStringXML(cfe.getAckCFE()));
	                ps.setInt(3,cfe.getEstado());
	                ps.setTimestamp(4,new Timestamp(cfe.getTimeStamp().getTime()));
	                int nro = ps.executeUpdate();
	                if (nro>=0){
	                    
	                }else{
	                	throw new DAOException("ERROR EN UPDATE TABLA CFE");
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

	private String getStringXML(Object objeto) throws XMLMarshallerException {
		if (objeto!=null)
			return new XMLMarshallerImpl().unmarshall(objeto);
		else
			return null;
	}

	@Override
	public ArrayList getTotals(Filter arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}

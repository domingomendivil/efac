package xg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import uy.gub.dgi.dao.AbstractDAO;
import uy.gub.dgi.dao.DAOException;
import uy.gub.dgi.dao.Filter;
import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.xml.XMLMarshallerException;

public class CAEUtilizadoDAO extends AbstractDAO {
	


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
		if (arg0 instanceof Integer) {
			Integer tipoCFE = (Integer) arg0;
			Connection conn = getConexion();
			if (conn != null) {
				try {
					PreparedStatement ps = conn
							.prepareStatement("SELECT * FROM CAE_UTILIZADO,CAE WHERE CAE_UTILIZADO.tipoCFE=? and CAE_UTILIZADO.fecha=CAE.fecha");
					ps.setInt(1,tipoCFE);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						CAEUtilizadoBean cae = getCAE(rs);
						return cae;
					} else {
						return null;
					}

				} catch (Exception e) {
					throw new DAOException(e);
				}
			} else {
				throw new DAOException("Error de conexión a la BD");
			}
		} else {
			throw new DAOException("Error en cast de ID tabla CAE");
		}
	}
	
	private CAEUtilizadoBean getCAE(ResultSet rs) throws SQLException, XMLMarshallerException {

		String xml = rs.getString("xml");
		CAEBean cae= new CAEBean(xml);
		CAEUtilizadoBean util = new CAEUtilizadoBean();
		util.setCae(cae);
		util.setTipoCFE(cae.getTipoCFE());
		util.setUltimoNumero(rs.getInt("ultimo_numero"));
		return util;
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

	@Override
	public void insert(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		CAEUtilizadoBean cae = (CAEUtilizadoBean) arg0;
		Connection conn = getConexion();
		if (conn != null) {
			PreparedStatement ps = null;
			try {
				ps = conn
						.prepareStatement("INSERT INTO CAE_UTILIZADO VALUES(?,?,?)");
				ps.setInt(1, cae.getTipoCFE());
				ps.setTimestamp(2,getTimeStamp(cae.getCae().getFecha()));
				ps.setInt(3,cae.getUltimoNumero());
				int i = ps.executeUpdate();
				if (i <= 0) {
					throw new DAOException(
							"No se pudo insertar en la tabla CAE_UTILIZADO");
				}
			} catch (Exception e1) {
				throw new DAOException(e1);
			} finally {
				closeConnection(conn);
			}
		}
	}


	@Override
	public void update(Object arg0) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private Timestamp getTimeStamp(Date fecha) {
		return new Timestamp(fecha.getTime());
	}
	
	private Date getDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

}

package xg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import uy.gub.dgi.cfe.CAEdefType;
import uy.gub.dgi.dao.AbstractDAO;
import uy.gub.dgi.dao.DAOException;
import uy.gub.dgi.dao.Filter;
import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLMarshallerException;

public class CAEDAO extends AbstractDAO {

	@Override
	public void delete(Object arg0) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList getAll() throws DAOException {
			ArrayList lista = new ArrayList();
			Connection conn = getConexion();
			if (conn != null) {
				try {
					PreparedStatement ps = conn
							.prepareStatement("SELECT * FROM CAE");
					ResultSet rs = ps.executeQuery();
					while (rs.next()){
						CAEBean cae = getCAE(rs);
						lista.add(cae);
					} 
					return lista;
				} catch (Exception e) {
					throw new DAOException(e);
				}
			} else {
				throw new DAOException("Error de conexión a la BD");
			}
	}

	@Override
	public ArrayList getByFilter(Filter arg0, Class arg1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Object arg0) throws DAOException {
		if (arg0 instanceof Date) {
			Date fecha = (Date) arg0;
			Connection conn = getConexion();
			if (conn != null) {
				try {
					PreparedStatement ps = conn
							.prepareStatement("SELECT * FROM CAE WHERE fecha=?");				
					Timestamp t = getTimeStamp(fecha);
					System.out.println(t);
					ps.setTimestamp(1, t);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						CAEBean cae = getCAE(rs);
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

	private CAEBean getCAE(ResultSet rs) throws SQLException, XMLMarshallerException {
		String xml = rs.getString("xml");
		CAEBean cae= new CAEBean(xml);
		return cae;
	}

	private Date getDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
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
	public void insert(Object arg0) throws DAOException {
		if (arg0 instanceof CAEBean) {
			CAEBean cae = (CAEBean) arg0;
			Connection conn = getConexion();
			if (conn != null) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					ps = conn
							.prepareStatement("INSERT INTO CAE VALUES(?,?,?)");
					ps.setTimestamp(1, getTimeStamp(cae.getFecha()));
					ps.setInt(2, cae.getTipoCFE());
					ps.setString(3,
							new XMLMarshallerImpl().unmarshall(cae.getCae()));
					int i = ps.executeUpdate();
					if (i <= 0) {
						throw new DAOException(
								"No se pudo insertar en la tabla CAE");
					}
				} catch (Exception e1) {
					throw new DAOException(e1);
				} finally {
					closeConnection(conn);
				}
			}
		}
	}

	@Override
	public void update(Object arg0) throws DAOException {
		
	}

	private Timestamp getTimeStamp(Date fecha) {
		return new Timestamp(fecha.getTime());
	}

	@Override
	public ArrayList getTotals(Filter arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}

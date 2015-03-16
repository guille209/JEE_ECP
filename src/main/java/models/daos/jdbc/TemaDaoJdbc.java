package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {
	 private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
	            + "%s VARCHAR(255), PRIMARY KEY (%s))";

	
	public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.PREGUNTA,
        		Tema.NOMBRE, Tema.ID);
    }

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";
	
	
	public Tema  create(ResultSet resultSet) {
		// TODO Auto-generated method stub
		   try {
	            if (resultSet != null && resultSet.next()) {
	                return new Tema(
	                        resultSet.getString(Tema.NOMBRE),
	                        resultSet.getString(Tema.PREGUNTA));
	            }
	        } catch (SQLException e) {
	            log.error("read: " + e.getMessage());
	        }
	        return null;
		
	}
	
	@Override
	public void  create(Tema tema) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		 ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Tema.TABLE, id));
	        return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";
	
	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		 this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.ID, Tema.NOMBRE,
	                Tema.PREGUNTA, entity.getId(), entity.getNombre(), entity.getPregunta()));
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		 this.updateSql(String.format(SQL_DELETE_ID, Tema.TABLE, id));
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		List<Tema> list = new ArrayList<Tema>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Tema.TABLE));
        Tema tema = this.create(resultSet);
        while (tema != null) {
            list.add(tema);
            tema = this.create(resultSet);
        }
        return list;	}

	@Override
	public Tema getTema(String nombreTema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByName(String nombreTema) {
		// TODO Auto-generated method stub
		
	}


}

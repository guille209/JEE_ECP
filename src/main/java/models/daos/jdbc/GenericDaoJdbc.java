package models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import models.daos.GenericDao;

public class GenericDaoJdbc<T, ID> implements GenericDao<T, ID> {
	private Class<T> persistentClass;
	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet result = null;

	public GenericDaoJdbc(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		
		conexion = null;
        sentencia = null;
        result = null;
        String url = "jdbc:mysql://localhost:3306/miwjee";
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Imposible cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Imposible conectar: " + e.getMessage());
        }
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		try {
            // begin
            conexion.setAutoCommit(false);

            // sentencias SQL
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT tabla1 VALUES (8,'Trans1')");
            sentencia.executeUpdate("INSERT tabla1 VALUES (8,'Trans2')");

            // Si se llega a este punto, todo ha ido bien
            conexion.commit();
        } catch (SQLException e) {
            try {
                // Hay problemas, se deshace todo
                conexion.rollback();
                System.out.println("Deshaciendo... " + e.getMessage());
            } catch (SQLException e1) {
                System.out.println("ERROR (rollback): " + e1.getMessage());
            }
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

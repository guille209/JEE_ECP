package models.daos.jpa;

import javax.persistence.*;

import org.apache.logging.log4j.LogManager;

import models.daos.DaoFactory;
import models.daos.*;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "JEE_ECP";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJpa();
    }

    @Override
    public VotoDao getVotoDao() {
        return new VotoDaoJpa();
    }
    
    public static void dropAndCreateTables() {
//        try {
//            Statement statement = getConnection().createStatement();
//            statement.executeUpdate(String.format(DROP_TABLE, User.TABLE));
//            statement.executeUpdate(String.format(DROP_TABLE, Category.TABLE));
//            statement.executeUpdate(CategoryDaoJdbc.sqlToCreateTable());
//            statement.executeUpdate(UserDaoJdbc.sqlToCreateTable());
//        } catch (SQLException e) {
//            LogManager.getLogger(DaoJdbcFactory.class).error("Drop tables: " + e.getMessage());
//        }
    	
    }
}

package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/gifts_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty007";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final int MAX_POOL_SIZE = 20;

    private HikariDataSource dataSource;
    private static DataBaseConfig instance;

    private DataBaseConfig(){
        try {
            HikariConfig config = new HikariConfig();
            config = new HikariConfig();
            config.setDriverClassName(DRIVER);
            config.setJdbcUrl(URL);
            config.setUsername(USERNAME);
            config.setPassword(PASSWORD);
            config.setMaximumPoolSize(MAX_POOL_SIZE);
            dataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure()
                    .dataSource(dataSource)
                    .load();
            flyway.migrate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DataBaseConfig getInstance(){
        if(instance == null){
            synchronized (DataBaseConfig.class){
                if(instance == null){
                    instance = new DataBaseConfig();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void close(){
        dataSource.close();
    }
}

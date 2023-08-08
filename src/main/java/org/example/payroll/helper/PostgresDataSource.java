package org.example.payroll.helper;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// DataSource
//
// DB Connection is an expensive memory resource and slow to create.
// Frequent opening and closing for every request is burdening.
// Management of connections manually is not recommended as well.
//
// Therefore, we need a "connection pool",
// where instead we made a new connection for every request,
// We make a lot of connections first so that it is only slow at the start.
//
// For every request, we just need one of the connections
// and return it to the pool.
// If all connections are used up, the request must wait first until
// the pool available again.
//
// We can use HikariCP to do a connection pool
// for database connections in our application
// https://github.com/brettwooldridge/HikariCP
public class PostgresDataSource {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/payroll?sslmode=disable";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static final int MAX_POOL_SIZE = 10;
    private static final int MIN_IDLE = 5;
    private static final long CONNECTION_TIMEOUT = 30_000; // in milliseconds


    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(MAX_POOL_SIZE);
        config.setMinimumIdle(MIN_IDLE);
        config.setConnectionTimeout(CONNECTION_TIMEOUT);

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}

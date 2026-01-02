package creational;

public class AbstractFactory {
    /*
    In Abstract factory, we will centralize the group of object creations in a single factory,
    for example in database connection factory simply returns single type of object, but in abstract design factory
    we will club group of object creations, clubbing the creation of MySQL database connection, MySQl Query builder & Transaction manager in single abstract factory
     */

    interface DatabaseConnection {
        void connect();
        void disconnect();
        String getConnectionInfo();
    }

    interface TransactionManager {
        void beginTransaction();
        void commit();
    }

    interface DatabaseFactory {
        DatabaseConnection createConnection();
        TransactionManager createTransactionManager();
    }

    public static class MySQLConnection implements DatabaseConnection {
        private String host;
        private int port;

        public MySQLConnection(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public void connect() {
            System.out.println("Connecting to MySQL at " + host + ":" + port);
        }

        @Override
        public void disconnect() {
            System.out.println("Disconnecting from MySQL");
        }

        @Override
        public String getConnectionInfo() {
            return "MySQL Connection";
        }
    }

    public static class PostgreSQLConnection implements DatabaseConnection {
        private String host;
        private int port;

        public PostgreSQLConnection(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public void connect() {
            System.out.println("Connecting to PostgreSQL at " + host + ":" + port);
        }

        @Override
        public void disconnect() {
            System.out.println("Disconnecting from PostgreSQL");
        }

        @Override
        public String getConnectionInfo() {
            return "PostgreSQL Connection";
        }
    }

    public static class MySQLTransactionManager implements TransactionManager {
        public void beginTransaction() { System.out.println("MySQL: START TRANSACTION"); }
        public void commit() { System.out.println("MySQL: COMMIT"); }
    }

    public static class PostgresqlTransactionManager implements TransactionManager {
        public void beginTransaction() { System.out.println("Postgresql: START TRANSACTION"); }
        public void commit() { System.out.println("Postgresql: COMMIT"); }
    }

    public static class MySQLFactory implements DatabaseFactory {
        @Override
        public DatabaseConnection createConnection() {
            return new MySQLConnection("JDBC", 429);
        }
        @Override
        public TransactionManager createTransactionManager() {
            return new MySQLTransactionManager();
        }
    }

    public static class PostgresqlFactory implements DatabaseFactory {

        @Override
        public DatabaseConnection createConnection() {
            return new PostgreSQLConnection("JDBC" , 474);
        }

        @Override
        public TransactionManager createTransactionManager() {
            return new PostgresqlTransactionManager();
        }
    }

}

package creational;

public class FactoryMethod {

    /*
    Let's say we have a class for Database connection, the application is to be centralized object creation strategy for database connection as they are expensive

    So to resolve this, we can have factory to create and supply the connection pools
     */

    public interface DatabaseConnection {
        void connect();
        void disconnect();
        String getConnectionInfo();
    }

    // Concrete implementations
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

    // Enum for type safety
    public enum DatabaseType {
        MYSQL, POSTGRESQL, MONGODB
    }

    // Simple Factory method
    public static DatabaseConnection createConnection(DatabaseType type,
                                                      String host,
                                                      int port) {
        switch (type) {
            case MYSQL:
                return new MySQLConnection(host, port);
            case POSTGRESQL:
                return new PostgreSQLConnection(host, port);
            default:
                throw new IllegalArgumentException("Unsupported database type: " + type);
        }
    }

    // Usage
    public static void main(String[] args) {
        DatabaseConnection connection = createConnection(DatabaseType.MYSQL, "localhost", 3306);
        connection.connect();
        // Use connection...
        connection.disconnect();
    }

}

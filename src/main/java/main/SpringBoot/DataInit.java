package main.SpringBoot;

import org.flywaydb.core.Flyway;

public class DataInit {
    public void initDb() {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./test", null, null)
                .load();

        flyway.migrate();
    }
}

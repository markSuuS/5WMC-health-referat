package at.htlleonding.health;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.sql.DataSource;
import java.sql.Connection;

@Readiness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {
    @Inject
    DataSource dataSource;

    @Override
    public HealthCheckResponse call() {
        try(Connection connection = dataSource.getConnection()) {
            if(!connection.isValid(2)){
                throw new Exception("invalid connection after calling connection.isValid with a timeout of 2s");
            }

            return HealthCheckResponse.up("database-connection-active");
        } catch (Exception e) {
            return HealthCheckResponse.down("database-connection-active");
        }
    }
}

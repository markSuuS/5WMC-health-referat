package at.htlleonding.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

import java.util.Random;

@Startup
@ApplicationScoped
public class StartupCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        boolean isUp = new Random().nextBoolean();

        if(isUp) {
            return HealthCheckResponse.up("startup-check");
        } else {
            return HealthCheckResponse.down("startup-check");
        }
    }
}

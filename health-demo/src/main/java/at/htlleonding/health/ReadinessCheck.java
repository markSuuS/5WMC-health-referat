package at.htlleonding.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.util.Random;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        boolean isUp = new Random().nextBoolean();

        if(isUp) {
            return HealthCheckResponse.up("readiness-check");
        } else {
            return HealthCheckResponse.down("readiness-check");
        }
    }
}

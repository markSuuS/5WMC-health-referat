package at.htlleonding.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import java.util.Random;

@Liveness
@ApplicationScoped
public class LivenessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        boolean isUp = new Random().nextBoolean();

        if(isUp) {
            return HealthCheckResponse.up("liveness-check");
        } else {
            return HealthCheckResponse.down("liveness-check");
        }
    }
}

package ie.williamswalsh.actuator_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class ActuatorApplication {
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ActuatorApplication.class);

        // this config is required to allow the /startup endpoint
        app.setApplicationStartup(new BufferingApplicationStartup(1000));
        app.run(args);
	}

}

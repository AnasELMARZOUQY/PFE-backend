package PFE.APIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

// @EnableZuulProxy

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-management-service", r -> r.path("/api/users/**", "/api/permissions/**")
                        .uri("lb://user-management-service"))
                .route("task-management-service", r -> r.path("/api/tasks/**")
                        .uri("lb://task-management-service"))
                .route("project-management-service", r -> r.path("/api/projects/**")
                        .uri("lb://project-management-service"))
                .build();
    }
}

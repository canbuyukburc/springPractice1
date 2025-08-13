package de.buyukburc.springPractice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")  // All endpoints will start with /api
public class ApiController {
    
    @Value("${spring.application.name}")
    String appName;

    // GET /api/info - Returns JSON
    @GetMapping("/info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("applicationName", appName);
        info.put("version", "1.0.0");
        info.put("status", "running");
        return info;  // Automatically converted to JSON
    }

    // GET /api/users - Returns JSON array
    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return List.of(
            Map.of("id", 1, "name", "Can", "email", "can@example.com"),
            Map.of("id", 2, "name", "John", "email", "john@example.com")
        );
    }

    // GET /api/user/{id} - Path variable example
    @GetMapping("/user/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "User " + id);
        user.put("email", "user" + id + "@example.com");
        return user;
    }

    // GET /api/hello - Simple string response
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from REST API!";
    }
}

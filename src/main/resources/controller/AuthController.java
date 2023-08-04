package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.AuthRequest;

@RestController
public class AuthController {

    @PostMapping("/authenticate")
public ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthRequest request) {
    if ("test@sunbasedata.com".equals(request.getLoginId()) && "Test@123".equals(request.getPassword())) {
        Map<String, String> response = new HashMap<>();
        response.put("token", "your_generated_token");
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

}

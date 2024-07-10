package Sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String token) {
        // For now, just print the token and return a success message
        System.out.println("Received token: " + token);
        return "Authentication successful for token: " + token;
    }
}

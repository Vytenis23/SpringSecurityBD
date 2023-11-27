//package lt.codeacademy.eshop.controller;
//
//import lt.codeacademy.eshop.dto.AuthResponse;
//import lt.codeacademy.eshop.dto.LoginRequest;
//import lt.codeacademy.eshop.model.Product;
//import lt.codeacademy.eshop.util.JwtTokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUsername(),
//                            loginRequest.getPassword()
//                    )
//            );
//            String username = authentication.getName();
//            String jwtToken = JwtTokenUtil.generateToken(authentication.getName());
//
//            return ResponseEntity.ok(new AuthResponse(jwtToken));
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nepavyko prisijungti");
//        }
//    }
//
////    @GetMapping("/login")
////    public String login() {
////        return "login";
////    }
//    @GetMapping("/logout")
//    public String logout() {
//        return "logout";
//    }
//}

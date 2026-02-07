//package com.catering.catering_hub.configs;
//
//import com.catering.catering_hub.models.order_models.AuthResponse;
//import com.catering.catering_hub.models.order_models.UserInfoJsonModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AuthController {
//    @Autowired
//    private AuthenticationManager authManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthToken(@RequestBody UserInfoJsonModel authRequest) throws Exception {
//        try {
//            authManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//        final String jwt = jwtUtil.generateToken(authRequest.getUserName());
//        return ResponseEntity.ok(new AuthResponse(jwt));
//    }
//
////    @GetMapping("/validate-token")
////    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader) {
////        String token = authHeader.substring(7); // Remove "Bearer "
////        String username = jwtUtil.extractUsername(token);
////        return ResponseEntity.ok("Token is valid for user: " + username);
////    }
//
//}
//

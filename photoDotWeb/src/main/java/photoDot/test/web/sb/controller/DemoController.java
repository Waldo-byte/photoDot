package photoDot.test.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import domain.service.GeneralResponse;

@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping("/ping")
    @ApiOperation(value = "Echo the ping", notes = "This is the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<String> ping(@RequestParam(value = "value that will be echoed", defaultValue = "pong")String echo){
        return new ResponseEntity<>(echo, HttpStatus.OK);
    }

    @PostMapping("/def")
    public String hashedpass(@RequestParam String string){
        int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
        int memoryCost = 8;      // increases memory usage
        int parallelization = 1; // currently not supported by Spring Security
        int keyLength = 32;      // key length in bytes
        int saltLength = 64;     // salt length in bytes

        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder(
                cpuCost,
                memoryCost,
                parallelization,
                keyLength,
                saltLength);
        String encodedPassword = sCryptPasswordEncoder.encode(string);
        return encodedPassword;
    }

}

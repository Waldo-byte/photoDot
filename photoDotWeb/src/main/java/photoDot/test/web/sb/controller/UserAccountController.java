package photoDot.test.web.sb.controller;

import domain.dto.CreateAccountDTO;
import domain.service.GeneralResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import logic.flow.CreateAccountFlow;
import logic.flow.FetchAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("UserAccount")
@ComponentScan(value = "logic.flow")
@CrossOrigin("*")
public class UserAccountController {

    private final FetchAccount fetchAccountFlow;
    private final CreateAccountFlow createAccountFlow;

    @Autowired
    public UserAccountController(FetchAccount fetchAccountFlow, CreateAccountFlow createAccountFlow) {
        this.fetchAccountFlow = fetchAccountFlow;
        this.createAccountFlow = createAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all users in the db", notes = "only for debugging uses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned users", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public List<CreateAccountDTO> getAll()
    {
        List<CreateAccountDTO> userAcc = fetchAccountFlow.getAll();
        GeneralResponse<List<CreateAccountDTO>> response = new GeneralResponse<>(true, userAcc);
        return userAcc;
    }


    @GetMapping("/user")
    @ApiOperation(value = "gets a certain user in the db")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public CreateAccountDTO getUser(@RequestParam Long userid)
    {
        CreateAccountDTO userAcc = fetchAccountFlow.getUser(userid);
        GeneralResponse<CreateAccountDTO> response = new GeneralResponse<>(true, userAcc);
        return userAcc;
    }

    @PostMapping("")
    @ApiOperation(value = "Create New User", notes = "create new user in db")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<CreateAccountDTO>> create(
            @ApiParam(
                    value = "Request body to create user",
                    required = true)
            @RequestBody CreateAccountDTO createAccountDTO){
        CreateAccountDTO accountUserData = createAccountFlow.create(createAccountDTO);
        GeneralResponse<CreateAccountDTO> response = new GeneralResponse<>(true , accountUserData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}

package translator.Impl;

import domain.dto.CreateAccountDTO;
import domain.persistance.photoDotUser;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import repo.persistance.photoDotUserRepo;
import translator.CreateAccountTranslator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@ComponentScan(value = "repo.persistance")
public class CreateAccountTranslatorImpl implements CreateAccountTranslator {
    private final photoDotUserRepo userRepo;

    @Autowired
    public CreateAccountTranslatorImpl(photoDotUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<CreateAccountDTO> getAll() {
        List<CreateAccountDTO> accountDTOS = new ArrayList<>();
        try{
            for(photoDotUser user : userRepo.findAll())
            {
                accountDTOS.add(new CreateAccountDTO(user));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from db.\n Error:",e);
        }
        return accountDTOS;
    }

    @Override
    public CreateAccountDTO getUser(Long id){
        photoDotUser user = userRepo.getOne(id);
        try{
            return new CreateAccountDTO(user);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.toString());
        }

    }

    @Override
    public String getName(Long id) {
        photoDotUser photoDotUser = userRepo.getOne(id);
        return photoDotUser.getName();
    }

    @Override
    public CreateAccountDTO findbyEmail(String emai) {
        photoDotUser photoDotUser = userRepo.findByEmail(emai);
        return new CreateAccountDTO(photoDotUser);
    }

    @Override
    public CreateAccountDTO findByEmailAndPassword(String email, String password) {
        CreateAccountDTO createAccountDTO = new CreateAccountDTO(userRepo.findByEmailAndPassword(email, password));
        return createAccountDTO;
    }

    @Override
    public CreateAccountDTO create(CreateAccountDTO accountDTO) {
        try{
            boolean exists = userRepo.existsByEmail(accountDTO.getEmail());
            if(!exists)
            {
                photoDotUser temporary_user = accountDTO.getUser();
                photoDotUser accountUser = userRepo.save(temporary_user);
                System.out.println(accountUser);
                return new CreateAccountDTO(accountUser);
            }
            else{
                throw new RuntimeException("User already exists");
            }

        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db or user already exists.", e);
        }
    }
}

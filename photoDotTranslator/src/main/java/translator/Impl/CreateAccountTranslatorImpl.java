package translator.Impl;

import domain.dto.CreateAccountDTO;
import domain.persistance.photoDotUser;
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
    public CreateAccountDTO create(CreateAccountDTO accountDTO) {
        try{
            photoDotUser temporary_user = accountDTO.getUser();
            photoDotUser accountUser = userRepo.save(temporary_user);
            System.out.println(accountUser);
            return new CreateAccountDTO(accountUser);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }
    }
}

package logic.flow.Implementation;

import domain.dto.CreateAccountDTO;
import logic.flow.FetchAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import translator.CreateAccountTranslator;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Component
@ComponentScan(value = "translator")
public class FetchAccountImpl implements FetchAccount {

    private final CreateAccountTranslator accountTranslator;

    @Autowired

    public FetchAccountImpl(CreateAccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<CreateAccountDTO> getAll(){return accountTranslator.getAll();}

    @Override
    public CreateAccountDTO getUser(Long id) {
        return accountTranslator.getUser(id);
    }

    @Override
    public CreateAccountDTO findbyEmail(String email) {
        return accountTranslator.findbyEmail(email);
    }

    @Override
    public CreateAccountDTO findByEmailAndPassword(String email, String password) {
        return accountTranslator.findByEmailAndPassword(email, password);
    }
}

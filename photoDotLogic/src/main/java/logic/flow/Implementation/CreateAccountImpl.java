package logic.flow.Implementation;

import domain.dto.CreateAccountDTO;
import logic.flow.CreateAccountFlow;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import translator.CreateAccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "translator")
public class CreateAccountImpl implements CreateAccountFlow {
    private final CreateAccountTranslator accountTranslator;

    public CreateAccountImpl(CreateAccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public CreateAccountDTO create(CreateAccountDTO user) {
        return accountTranslator.create(user);
    }
}

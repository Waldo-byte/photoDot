package translator;

import domain.dto.CreateAccountDTO;

import java.util.List;

public interface CreateAccountTranslator {
    List<CreateAccountDTO> getAll();

    CreateAccountDTO create(CreateAccountDTO accountDTO);

}

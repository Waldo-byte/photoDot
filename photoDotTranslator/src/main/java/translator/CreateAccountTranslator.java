package translator;

import domain.dto.CreateAccountDTO;

import java.util.List;
import java.util.UUID;

public interface CreateAccountTranslator {
    List<CreateAccountDTO> getAll();

    CreateAccountDTO create(CreateAccountDTO accountDTO);
    CreateAccountDTO getUser(Long id);
    String getName(Long id);

}

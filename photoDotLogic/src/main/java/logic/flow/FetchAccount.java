package logic.flow;

import domain.dto.CreateAccountDTO;

import java.util.List;
import java.util.UUID;

public interface FetchAccount {
    List<CreateAccountDTO> getAll();

    CreateAccountDTO getUser(Long id);
}

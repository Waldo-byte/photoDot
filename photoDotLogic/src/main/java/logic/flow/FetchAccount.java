package logic.flow;

import domain.dto.CreateAccountDTO;
import domain.persistance.photoDotUser;

import java.util.List;
import java.util.UUID;

public interface FetchAccount {
    List<CreateAccountDTO> getAll();

    CreateAccountDTO getUser(Long id);
    CreateAccountDTO findbyEmail(String email);
    CreateAccountDTO findByEmailAndPassword(String email, String password);
}

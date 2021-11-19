package logic.flow;

import domain.dto.CreateAccountDTO;

import java.util.List;

public interface FetchAccount {
    List<CreateAccountDTO> getAll();
}

package logic.flow;

import domain.dto.CreateAccountDTO;

public interface CreateAccountFlow {
    CreateAccountDTO create(CreateAccountDTO User);
}

package mvc.repository;

import mvc.dto.TransferDTO;

public interface TransferDAO {
    /**
        출금하기
     */
    int withdraw(TransferDTO transferDTO);

    /**
        입금하기
     */
    int deposit(TransferDTO transferDTO);

}

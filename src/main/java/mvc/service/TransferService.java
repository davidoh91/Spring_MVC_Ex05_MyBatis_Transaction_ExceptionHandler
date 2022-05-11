package mvc.service;

import mvc.dto.TransferDTO;

public interface TransferService {
    /*
        이체하기
     */
    int transfer(TransferDTO transferDTO);

}

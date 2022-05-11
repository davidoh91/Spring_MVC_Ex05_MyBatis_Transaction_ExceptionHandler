package mvc.service;

import mvc.dto.TransferDTO;
import lombok.RequiredArgsConstructor;
import mvc.exception.MyException;
import org.springframework.stereotype.Service;
import mvc.repository.TransferDAO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
//@Transactional(rollbackFor = MyException.class)
public class TransferServiceImpl implements TransferService{

    private final TransferDAO transferDAO;

    @Override
    @Transactional(rollbackFor = MyException.class) //if MyException-> rollback triggered
    public int transfer(TransferDTO transferDTO) {
        int re = transferDAO.withdraw(transferDTO);

        int re2 = transferDAO.deposit(transferDTO);

        if(re==0 | re2==0) {
            throw new MyException("계좌이체 실패했습니다");
        }

        return 0;
    }
}

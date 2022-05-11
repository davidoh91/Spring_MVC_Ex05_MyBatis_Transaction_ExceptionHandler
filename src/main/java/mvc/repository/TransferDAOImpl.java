package mvc.repository;

import mvc.dto.TransferDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransferDAOImpl implements TransferDAO {

    private final SqlSession session;

    @Override
    public int withdraw(TransferDTO transferDTO) {
        return session.update("TransferMapper.withdraw", transferDTO);
    }

    @Override
    public int deposit(TransferDTO transferDTO) {
        return session.update("TransferMapper.deposit", transferDTO);
    }
}

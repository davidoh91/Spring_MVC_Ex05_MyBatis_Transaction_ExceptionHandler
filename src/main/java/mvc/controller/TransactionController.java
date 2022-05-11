package mvc.controller;

import mvc.dto.TransferDTO;
import lombok.RequiredArgsConstructor;
import mvc.exception.MyException;
import mvc.service.TransferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransferService transferService;

    @RequestMapping("/")
    public String index() {
        return "transaction"; //WEB-INF/views/transaction.jsp 로 이동
    }

    @RequestMapping("/transfer")
    public String transfer(TransferDTO transferDTO) {
        transferService.transfer(transferDTO);

        return "result";
    }


    //any thrown Exception (from this controller method) will be taken care of by @ExceptionHandler
    @ExceptionHandler(MyException.class)
    public ModelAndView error(MyException e) {
        return new ModelAndView("error", "errMessage", e.getMessage());
    }

}

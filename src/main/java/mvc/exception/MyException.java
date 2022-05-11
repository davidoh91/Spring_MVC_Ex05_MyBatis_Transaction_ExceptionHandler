package mvc.exception;

public class MyException extends RuntimeException {//비체크예외
//    public class MyException extends RuntimeException {//체크예외
    public MyException(){}
    public MyException(String message) {
        super(message);
    }
    
}

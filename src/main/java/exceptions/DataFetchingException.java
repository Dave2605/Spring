package exceptions;

public class DataFetchingException extends Exception {

    public DataFetchingException(){
        super();
    }

    public DataFetchingException(String message){
        super(message);
    }
}

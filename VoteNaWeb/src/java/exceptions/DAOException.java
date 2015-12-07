package exceptions;

public class DAOException extends RuntimeException{
    public DAOException(String mensagem) {
        super(mensagem);
    }
}

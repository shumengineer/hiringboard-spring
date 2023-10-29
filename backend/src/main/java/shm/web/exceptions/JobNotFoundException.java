package shm.web.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String s) {
        super(s);
    }
}

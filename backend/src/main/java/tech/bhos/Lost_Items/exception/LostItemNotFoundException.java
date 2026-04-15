package tech.bhos.Lost_Items.exception;

public class LostItemNotFoundException extends RuntimeException {
    public LostItemNotFoundException(Integer id) {
        super("Lost item with id " + id + " was not found");
    }
}

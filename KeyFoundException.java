/**
 * A checked exception used by SimpleMap to indicate when trying to insert
 * a key that is already in the map.
 *
 * @author  Mike Jacobson
 * @version 1.0
 */
public class KeyFoundException extends RuntimeException {
    /**
     * Creates an exception with a null cause.
     * @see RuntimeException#RuntimeException()
     */
    public KeyFoundException( ) {
	super( );
    }

    /**
     * Creates an exception with cause message.
     * @see RuntimeException#RuntimeException(String message)
     * @param message exception message to display
     */
    public KeyFoundException( String message ) {
	super( message );
    }
}

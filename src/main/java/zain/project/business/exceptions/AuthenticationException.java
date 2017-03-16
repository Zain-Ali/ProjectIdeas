
package zain.project.business.exceptions;

/**
 *
 * @author zain
 */
public class AuthenticationException extends Exception 
{
    public AuthenticationException() 
    {
    }
    
    public AuthenticationException(String exception) 
    {
        super (exception);
    }
       
}

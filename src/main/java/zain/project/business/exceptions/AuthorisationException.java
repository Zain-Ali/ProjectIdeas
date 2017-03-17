/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business.exceptions;

/**
 *
 * @author zain
 */
public class AuthorisationException extends Exception {

    public AuthorisationException(String exception) {
        super(exception);
    }

    public AuthorisationException() {
    }

}

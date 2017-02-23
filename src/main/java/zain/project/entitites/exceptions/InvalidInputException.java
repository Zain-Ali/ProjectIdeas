/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.entitites.exceptions;

/**
 *
 * @author zain
 */
public class InvalidInputException extends Exception 
{
    //InvalidInputException is a class that have to extend Exception.
    public InvalidInputException(String error) 
    {
        super(error);
    }
    
}

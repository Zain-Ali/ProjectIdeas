/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.controllers;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import zain.project.business.UsersService;
import zain.project.entitites.Users;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author zain
 */
@FacesConverter(forClass = Users.class)
public class UserConverter implements Converter {

    /**
     * Creates a new instance of UserConverter
     */
    public UserConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        usersController usersController = (usersController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "usersController");
        UsersService us = usersController.getUsersService();
        UsersFacade uf = us.getUserFacade();
        Long id = Long.decode(value);
        Users u = uf.find(id);
        return u;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Users) {
            return ((Users) value).getId().toString();
        } else {
            throw new Error("object is not of type Organisation");
        }
    }

}

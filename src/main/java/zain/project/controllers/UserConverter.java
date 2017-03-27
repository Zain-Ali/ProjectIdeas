package zain.project.controllers;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import zain.project.business.UsersService;
import zain.project.entitites.Users;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */

/*The following Java code taken from*/
 /*https://github.com/Jimbriggs/webp-examples/blob/ENTWA2015-2016/ENTWAJPA1/src/java/jim/entwa/ctrl/AddressConverter.java*/
 /*But the code has been modifed according to project needs*/
 /*Starts here*/


@FacesConverter(forClass = Users.class)
public class UserConverter implements Converter {

    /**
     * Creates a new instance of UserConverter
     */
    public UserConverter() {
    }

    /**
     * 
     * @param context current  context
     * @param component current component
     * @param value current value
     * @return user
     */
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

    /**
     * 
     * @param context current  context
     * @param component current component
     * @param value current value
     * @return user
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Users) {
            return ((Users) value).getId().toString();
        } else {
            throw new Error("object is not of type Organisation");
        }
    }

}

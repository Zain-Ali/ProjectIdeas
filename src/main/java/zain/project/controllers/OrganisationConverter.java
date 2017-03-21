
package zain.project.controllers;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import zain.project.business.OrganisationService;
import zain.project.entitites.Organisation;
import zain.project.persistence.OrganisationFacade;

/**
 *
 * @author UP687776
 */
@FacesConverter(forClass = Organisation.class)
public class OrganisationConverter implements Converter {
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        OrganisationController organisationController = (OrganisationController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "organisationController");
        OrganisationService os = organisationController.getOrganisationService();
        OrganisationFacade of = os.getOrganisationFacade();
        Long id = Long.decode(value);
        Organisation o = of.find(id);
        return o;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Organisation) {
            return ((Organisation) value).getId().toString();
        } else {
            throw new Error("object is not of type Organisation");
        }
    }

}

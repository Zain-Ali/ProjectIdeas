package zain.project.entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Organisation entity class to represent Organisation within database and application
 * @author Zain Ali (UP687776)
 */
@Entity
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organisationName;
    private String postalAddress;
    private String postCode;
    private String outLineOfWhatYourOrganisationDoes;
    private String contactName;
    private int telePhone;
    private String emailAddress;

    /**
     * get value of id and is auto generated
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id set value of id and is auto generated
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get value of organisation name
     *
     * @return organisation name
     */
    public String getOrganisationName() {
        return organisationName;
    }

    /**
     * 
     *
     * @param organisationName set value of organisation name
     */
    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    /**
     * get value of postal address
     *
     * @return postal address
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * 
     *
     * @param postalAddress set value of postal address
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * get value of post code
     *
     * @return post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 
     *
     * @param postCode set value of post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * get value of Out Line Of What Your Organisation Does
     *
     * @return Out Line Of What Your Organisation Does
     */
    public String getOutLineOfWhatYourOrganisationDoes() {
        return outLineOfWhatYourOrganisationDoes;
    }

    /**
     *
     *
     * @param outLineOfWhatYourOrganisationDoes  set value of Out Line Of What Your Organisation Does
     */
    public void setOutLineOfWhatYourOrganisationDoes(String outLineOfWhatYourOrganisationDoes) {
        this.outLineOfWhatYourOrganisationDoes = outLineOfWhatYourOrganisationDoes;
    }

    /**
     * get value of contact name
     *
     * @return contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 
     *
     * @param contactName set value of contact name
     */ 
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * get value of contact number
     *
     * @return telephone number (contact number)
     */
    public int getTelePhone() {
        return telePhone;
    }

    /**
     * 
     *
     * @param telePhone set value of telephone number (contact number)
     */
    public void setTelePhone(int telePhone) {
        this.telePhone = telePhone;
    }

    /**
     * get value of email address
     *
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     *
     * @param emailAddress set value of email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Organisation)) {
            return false;
        }
        Organisation other = (Organisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zain.project.entitites.Organisation[ id=" + id + " ]";
    }

}

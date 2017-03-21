package zain.project.entitites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author UP687776
 */
@Entity
public class Organisation implements Serializable {

    @OneToMany(mappedBy = "organisation")
    private List<Project> projects;

    @OneToOne(mappedBy = "organisation")
    private Project project;

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
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * set id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return organisation name
     */
    public String getOrganisationName() {
        return organisationName;
    }

    /**
     * set organisation name
     *
     * @param organisationName
     */
    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    /**
     *
     * @return postal address
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * set postal address
     *
     * @param postalAddress
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     *
     * @return post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * set post code
     *
     * @param postCode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     *
     * @return Out Line Of What Your Organisation Does
     */
    public String getOutLineOfWhatYourOrganisationDoes() {
        return outLineOfWhatYourOrganisationDoes;
    }

    /**
     * set Out Line Of What Your Organisation Does
     *
     * @param outLineOfWhatYourOrganisationDoes
     */
    public void setOutLineOfWhatYourOrganisationDoes(String outLineOfWhatYourOrganisationDoes) {
        this.outLineOfWhatYourOrganisationDoes = outLineOfWhatYourOrganisationDoes;
    }

    /**
     *
     * @return contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * set contact name
     *
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     *
     * @return telephone number (contact number)
     */
    public int getTelePhone() {
        return telePhone;
    }

    /**
     * set telephone number (contact number)
     *
     * @param telePhone
     */
    public void setTelePhone(int telePhone) {
        this.telePhone = telePhone;
    }

    /**
     *
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * set email address
     *
     * @param emailAddress
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
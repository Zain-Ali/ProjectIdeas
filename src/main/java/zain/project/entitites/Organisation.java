/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author zain
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


    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    

    public String getOrganisationName() 
    {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) 
    {
        this.organisationName = organisationName;
    }

    public String getPostalAddress() 
    {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) 
    {
        this.postalAddress = postalAddress;
    }

    
    public String getPostCode() 
    {
        return postCode;
    }

    public void setPostCode(String postCode) 
    {
        this.postCode = postCode;
    }

    
    public String getOutLineOfWhatYourOrganisationDoes() 
    {
        return outLineOfWhatYourOrganisationDoes;
    }

    public void setOutLineOfWhatYourOrganisationDoes(String outLineOfWhatYourOrganisationDoes) 
    {
        this.outLineOfWhatYourOrganisationDoes = outLineOfWhatYourOrganisationDoes;
    }

    
    public String getContactName() 
    {
        return contactName;
    }

    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public int getTelePhone() 
    {
        return telePhone;
    }

    public void setTelePhone(int telePhone) 
    {
        this.telePhone = telePhone;
    }
    

    public String getEmailAddress() 
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) 
    {
        this.emailAddress = emailAddress;
    }
    

    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisation)) 
        {
            return false;
        }
        Organisation other = (Organisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "zain.project.entitites.Organisation[ id=" + id + " ]";
    }
    
}


package zain.project.entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author UP687776
 */
@Entity
public class ContactAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String emailAddress;
    private String contactNumber;
    private String shortTitle;
    private String message;

    /**
     * 
     * @return id
     */
    public Long getId() 
    {
        return id;
    }

    /**
     * set id
     * @param id 
     */
    public void setId(Long id) 
    {
        this.id = id;
    }

    /**
     * 
     * @return full name
     */
    public String getFullName() 
    {
        return fullName;
    }

    /**
     * set full name
     * @param fullName 
     */
    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }
    
    /**
     * 
     * @return email address
     */
    public String getEmailAddress() 
    {
        return emailAddress;
    }

    /**
     * set email address
     * @param emailAddress 
     */
    public void setEmailAddress(String emailAddress) 
    {
        this.emailAddress = emailAddress;
    }

    /**
     * 
     * @return contact number
     */
    public String getContactNumber() 
    {
        return contactNumber;
    }

    /**
     * set contact number
     * @param contactNumber 
     */
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    /**
     * 
     * @return short title
     */
    public String getShortTitle() 
    {
        return shortTitle;
    }

    /**
     * set short title
     * @param shortTitle 
     */
    public void setShortTitle(String shortTitle) 
    {
        this.shortTitle = shortTitle;
    }

    /**
     * 
     * @return message 
     */
    public String getMessage() 
    {
        return message;
    }

    /**
     * set message
     * @param message 
     */
    public void setMessage(String message) 
    {
        this.message = message;
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
        if (!(object instanceof ContactAdmin)) 
        {
            return false;
        }
        ContactAdmin other = (ContactAdmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "zain.project.entitites.Contact[ id=" + id + " ]";
    }
    
}

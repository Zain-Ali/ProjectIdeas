
package zain.project.entitites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ContactAdmin entity class, to represent Contact Admin within the database and application
 * @author Zain Ali (UP687776)
 */
@Entity
public class ContactAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String shortTitle;

    @Column(nullable = false)
    private String message;

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
     *
     * @param id set value of id and is auto generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get value of user's full name
     *
     * @return user's full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     *
     * @param fullName set value of user's full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * @param emailAddress  set value of email address

     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * get value of contact number
     *
     * @return contact number
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 
     *
     * @param contactNumber set value of contact number
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * get value of short title
     *
     * @return short title
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * 
     *
     * @param shortTitle set value of short title
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * get value of user's message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     *
     * @param message set value of message
     */
    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof ContactAdmin)) {
            return false;
        }
        ContactAdmin other = (ContactAdmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zain.project.entitites.ContactAdmin[ id=" + id + " ]";
    }
}

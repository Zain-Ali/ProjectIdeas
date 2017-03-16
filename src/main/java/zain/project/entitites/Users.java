
package zain.project.entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zain
 */
@Entity
@Table(name="Users")
public class Users implements Serializable 
{

    @OneToOne(mappedBy = "appliedStudent")
    private Project project;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String email;
    private String firstname;
    private String lastName;
    private String phoneNumber;
    private String typeOfUser;
    
    @ManyToOne
    private Organisation organisation;




    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    
    
    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getFirstname() 
    {
        return firstname;
    }
    
    
    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }

    public String getLastName() 
    {
        return lastName;
    }

    
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
    
    
    public String getTypeOfUser() 
    {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser)
    {
        switch(typeOfUser)
        {
            case "Admin":
            case "Student":
            case "Staff":    
                this.typeOfUser = typeOfUser;
                break;
                default:System.out.println("Not a Admin, Student, or Staff");
        }
    }
    
    
    public Organisation getOrganisation() 
    {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) 
    {
        this.organisation = organisation;
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
        if (!(object instanceof Users)) 
        {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "zain.project.entitites.User[ id=" + id + " ]";
    }
    
}

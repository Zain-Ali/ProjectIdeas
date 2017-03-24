package zain.project.entitites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author UP687776
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastName;
    private String phoneNumber;
    private String typeOfUser;
    private String email;
    private String password;

    //@OneToOne(mappedBy = "appliedStudent")
    @OneToMany(mappedBy = "appliedStudent")
    private List<Project> project; //s

    @ManyToOne
    private Organisation organisation;

    /**
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * set new id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return get first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * set first name
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return get phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set phone number
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return type of users (Admin, or Student, or Staff)
     */
    public String getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * set type of users (Admin, or Student, or Staff)
     *
     * @param typeOfUser
     */
    public void setTypeOfUser(String typeOfUser) {
        switch (typeOfUser) {
            case "Admin":
            case "Student":
            case "Staff":
                this.typeOfUser = typeOfUser;
                break;
            default:
                System.out.println("Not a Admin, Student, or Staff");
        }
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return list of projects from Project Class
     */
    public List<Project> getProject() {
        return project;
    }

    /**
     * set project from Project Class
     *
     * @param project
     */
    public void setProject(List<Project> project) {
        this.project = project;
    }
    //(Note) delete above 2 if cause problem 

    /**
     *
     * @return organisation
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * set organisation
     *
     * @param organisation
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zain.project.entitites.User[ id=" + id + " ]";
    }

}

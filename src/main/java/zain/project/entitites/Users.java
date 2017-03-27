package zain.project.entitites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Users entity class, to represent an User within the database and application
 *
 * @author Zain Ali (UP687776)
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    @Column(nullable = false)
    private String lastName;
    private String typeOfUser;
    private String email;
    private String password;

    @OneToOne(mappedBy = "appliedStudent")
    private Project appliedProject;

    @OneToMany(mappedBy = "projectOwner")
    private List<Project> ownedProjects;

    @ManyToOne
    private Organisation organisation;

    /**
     * get value of ID and is auto generated
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * set new value id and is auto generated
     *
     * @param id id
     */ 
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get value of fist name
     *
     * @return get first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * set first name
     *
     * @param firstname fn
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * get value of last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set last name
     *
     * @param lastName ln
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get value of user type
     *
     * @return type of users (Admin, or Student, or Staff)
     */
    public String getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * set type of users (Admin, or Student, or Staff)
     *
     * @param typeOfUser type of user
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
     * get value of email address
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get value of password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get list of project owned by a user
     *
     * @return list of projects from Project Class
     */
    public List<Project> getOwnedProjects() {
        return ownedProjects;
    }

    /**
     * Clear owned project idea after idea is removed
     */
    public void clearOwnedProjects() {
        ownedProjects.clear();
    }

    /**
     * set project from Project Class
     *
     * @param project project
     */
    public void addOwnedProject(Project project) {
        this.ownedProjects.add(project);
    }

    /**
     * get value of organisation owned by user
     *
     * @return organisation
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * set value of organisation
     *
     * @param organisation organisation
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     * get value of applied project by user
     *
     * @return applied project
     */
    public Project getAppliedProject() {
        return appliedProject;
    }

    /**
     * set value of applied project by user
     *
     * @param appliedProject appliedProject
     */
    public void setAppliedProject(Project appliedProject) {
        this.appliedProject = appliedProject;
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

package zain.project.entitites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author UP687776
 */
@Entity
@Table(name = "Projects")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //reference number

    @Column(nullable = false, length = 99)
    private String title;

    @Column(nullable = false, length = 99)
    private String languages;

    @ManyToOne
    private Users projectOwner;

    @Column(nullable = false)
    private String aimsAndObjectives;

    @Column(nullable = true)
    private String academicQuestionsToBeAnswered;

    @Column(nullable = false)
    private String anticipatedDeliverables;

    @Column(nullable = true)
    private String studentForWhoProjectHasBeenDevised;

    @Column(nullable = false)
    private String status;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
    
    @ManyToOne//(mappedBy = "projects")
    private Organisation organisation;

    //new 
    @OneToOne
    private Users appliedStudent;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return language
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * set language
     *
     * @param languages
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     *
     * @return from Project Class
     */
    public Users getProjectOwner() {
        return projectOwner;
    }

    /**
     * set from Project Class
     *
     * @param projectOwner
     */
    public void setProjectOwner(Users projectOwner) {
        this.projectOwner = projectOwner;
    }

    /**
     *
     * @return aims and objectives
     */
    public String getAimsAndObjectives() {
        return aimsAndObjectives;
    }

    /**
     * set aims and objective
     *
     * @param aimsAndObjectives
     */
    public void setAimsAndObjectives(String aimsAndObjectives) {
        this.aimsAndObjectives = aimsAndObjectives;
    }

    /**
     *
     * @return academic questions to be answered
     */
    public String getAcademicQuestionsToBeAnswered() {
        return academicQuestionsToBeAnswered;
    }

    /**
     * set academic questions to be answered
     *
     * @param academicQuestionsToBeAnswered
     */
    public void setAcademicQuestionsToBeAnswered(String academicQuestionsToBeAnswered) {
        this.academicQuestionsToBeAnswered = academicQuestionsToBeAnswered;
    }

    /**
     *
     * @return anticipated deliverables
     */
    public String getAnticipatedDeliverables() {
        return anticipatedDeliverables;
    }

    /**
     * set anticipated deliverables
     *
     * @param anticipatedDeliverables
     */
    public void setAnticipatedDeliverables(String anticipatedDeliverables) {
        this.anticipatedDeliverables = anticipatedDeliverables;
    }

    /**
     *
     * @return Student For Who Project Has Been Devised
     */
    public String getStudentForWhoProjectHasBeenDevised() {
        return studentForWhoProjectHasBeenDevised;
    }

    /**
     * set Student For Who Project Has Been Devised
     *
     * @param studentForWhoProjectHasBeenDevised
     */
    public void setStudentForWhoProjectHasBeenDevised(String studentForWhoProjectHasBeenDevised) {
        this.studentForWhoProjectHasBeenDevised = studentForWhoProjectHasBeenDevised;
    }

    /**
     *
     * @return status (Approved, Provisional, Withdrawn)
     */
    public String getStatus() {
        return status;
    }

    /**
     * set (status (Approved, Provisional, Withdrawn)
     *
     * @param status
     */
    public void setStatus(String status) {
        switch (status) {
            case "Approved": //Approved
            case "Provisional": // Provisional 
            case "Withdrawn": // WithDrawn
                this.status = status;
                break;
            default:
                System.out.println("Only Select \"Approved\", \"Provisional\", \"Withdrawn\" ");
        }
    }

    /**
     *
     * @return organisation from Organisation Class
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * set organisation from Organisation Class
     *
     * @param organisation
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     *
     * @return date created or updated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * set date created or updated
     *
     * @param lastUpdated
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     *
     * @return applied student from Users class (optional)
     */
    public Users getAppliedStudent() {
        return appliedStudent;
    }

    /**
     * set applied student from Users class (optional)
     *
     * @param appliedStudent
     */
    public void setAppliedStudent(Users appliedStudent) {
        this.appliedStudent = appliedStudent;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zain.project.entitites.Project[ id=" + id + " ]";
    }

}
package zain.project.entitites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project Entity class to represent a Project within database and application
 * @author Zain Ali (UP687776)
 */
@Entity
@Table(name = "Projects")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 99)
    private String title;

    @Column(nullable = false, length = 99)
    private String languages;

    @Column(nullable = false)
    private String aimsAndObjectives;

    @Column(nullable = true)
    private String academicQuestionsToBeAnswered;

    @Column(nullable = false)
    private String anticipatedDeliverables;

    @Column(nullable = true)
    private String studentForWhoProjectHasBeenDevised;

    @Column(nullable = false)
    private String status = "Provisional";

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastUpdated;

    @ManyToOne
    private Organisation organisation;

    @ManyToOne
    private Users appliedStudent;

    @ManyToOne
    private Users projectOwner;

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
     * @param id  set value of id and is auto generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get value of title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     *
     * @param title set value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get value of language used for project
     *
     * @return language
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * 
     *
     * @param languages set value of language used for project
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * get value of project owner (user)
     *
     * @return project owner from Project Class
     */
    public Users getProjectOwner() {
        return projectOwner;
    }

    /**
     * 
     *
     * @param projectOwner set value of project owner (user) project owner from Project Class
     */
    public void setProjectOwner(Users projectOwner) {
        this.projectOwner = projectOwner;
    }

    /**
     * 
     *
     * @return aims and objectives get value of aims and objectives
     */
    public String getAimsAndObjectives() {
        return aimsAndObjectives;
    }

    /**
     * 
     *
     * @param aimsAndObjectives set value of aims and objective
     */
    public void setAimsAndObjectives(String aimsAndObjectives) {
        this.aimsAndObjectives = aimsAndObjectives;
    }

    /**
     * get value of academic questions to be answered
     *
     * @return academic questions to be answered
     */
    public String getAcademicQuestionsToBeAnswered() {
        return academicQuestionsToBeAnswered;
    }

    /**
     * 
     *
     * @param academicQuestionsToBeAnswered set value of academic questions to be answered
     */
    public void setAcademicQuestionsToBeAnswered(String academicQuestionsToBeAnswered) {
        this.academicQuestionsToBeAnswered = academicQuestionsToBeAnswered;
    }

    /**
     * get value of academic questions to be answered
     *
     * @return anticipated deliverables
     */
    public String getAnticipatedDeliverables() {
        return anticipatedDeliverables;
    }

    /**
     * 
     *
     * @param anticipatedDeliverables set value of anticipated deliverables
     */
    public void setAnticipatedDeliverables(String anticipatedDeliverables) {
        this.anticipatedDeliverables = anticipatedDeliverables;
    }

    /**
     * get value of Student For Who Project Has Been Devised
     *
     * @return Student For Who Project Has Been Devised
     */
    public String getStudentForWhoProjectHasBeenDevised() {
        return studentForWhoProjectHasBeenDevised;
    }

    /**
     * 
     *
     * @param studentForWhoProjectHasBeenDevised set value of Student For Who Project Has Been Devised
     */
    public void setStudentForWhoProjectHasBeenDevised(String studentForWhoProjectHasBeenDevised) {
        this.studentForWhoProjectHasBeenDevised = studentForWhoProjectHasBeenDevised;
    }

    /**
     * get value of project status (Provisional by default for students)
     *
     * @return status (Approved, Provisional, Withdrawn)
     */
    public String getStatus() {
        return status;
    }

    /**
     * set (status (Approved, Provisional, Withdrawn) (Provisional by default
     * for students)
     *
     * @param status status
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
     * get value of organisation from Organisation class
     *
     * @return organisation from Organisation Class
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * set organisation from Organisation Class
     *
     * @param organisation org
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     * get value of project created/updated date
     *
     * @return date created or updated
     */
    public Calendar getLastUpdated() {
        return lastUpdated;
    }

    /**
     * set value of project created/updated date
     *
     * @param lastUpdated date
     */
    public void setLastUpdated(Calendar lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * get value of applied student from Users class (optional)
     *
     * @return applied student from Users class (optional)
     */
    public Users getAppliedStudent() {
        return appliedStudent;
    }

    /**
     * set applied student from Users class (optional)
     *
     * @param appliedStudent applied student
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


package zain.project.entitites;

import zain.project.entitites.exceptions.InvalidInputException;
import java.io.Serializable;
import java.util.Date;
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
 * @author zain
 */
@Entity
@Table(name="Projects")
public class Project implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //reference number
    
    @Column(nullable=false, length=99)
    private String title;
    
    @Column(nullable=false, length=99)
    private String languages;    
    
    @ManyToOne
    private Users projectOwner;
    
    @Column(nullable=false) 
    private String aimsAndObjectives;
    
    @Column(nullable=true)
    private String academicQuestionsToBeAnswered;
    
    @Column(nullable=false)
    private String anticipatedDeliverables;
    
    @Column(nullable=true)
    private String studentForWhoProjectHasBeenDevised;
    
    @Column(nullable=false)
    private String status;
    
    
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Organisation organisation;
    
    //new 
    @OneToOne
    private Users appliedStudent;




    
    
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) throws InvalidInputException
    {
        if(title.length() < 1 || title.length() > 100) 
        {
            throw new InvalidInputException("Length of Title must be between 1 and 100");
        }
        else 
        {
            this.title = title;
        }
    }
        
    
    public String getLanguages() 
    {
        return languages;
    }

    public void setLanguages(String languages) 
    {
        this.languages = languages;
    }
    
    
        public Users getProjectOwner() 
    {
        return projectOwner;
    }

    public void setProjectOwner(Users projectOwner) 
    {
        this.projectOwner = projectOwner;
    } 

    public String getAimsAndObjectives() 
    {
        return aimsAndObjectives;
    }

    public void setAimsAndObjectives(String aimsAndObjectives) throws InvalidInputException 
    {
        if (aimsAndObjectives.length() < 1) 
        {
            throw new InvalidInputException("Length of Title must be between 1 and 100");
        }
        else 
        {        
            this.aimsAndObjectives = aimsAndObjectives;
        }
    }
    

    public String getAcademicQuestionsToBeAnswered() 
    {
        return academicQuestionsToBeAnswered;
    }

    public void setAcademicQuestionsToBeAnswered(String academicQuestionsToBeAnswered) throws InvalidInputException 
    {
        if(academicQuestionsToBeAnswered.length() < 1) 
        {
            throw new InvalidInputException("Must Answer the question");          
        }
        else 
        {        
            this.academicQuestionsToBeAnswered = academicQuestionsToBeAnswered;
        }
    }
    

    public String getAnticipatedDeliverables() 
    {
        return anticipatedDeliverables;
    }

    public void setAnticipatedDeliverables(String anticipatedDeliverables) throws InvalidInputException 
    {
        if(anticipatedDeliverables.length() < 1) 
        {
            throw new InvalidInputException("Must Answer the Question");
        }
        else 
        {
            this.anticipatedDeliverables = anticipatedDeliverables;       
        }
    }
    
    
    public String getStudentForWhoProjectHasBeenDevised() 
    {
        return studentForWhoProjectHasBeenDevised;
    }

    public void setStudentForWhoProjectHasBeenDevised(String studentForWhoProjectHasBeenDevised) 
    {
        this.studentForWhoProjectHasBeenDevised = studentForWhoProjectHasBeenDevised;
    }
    
    
    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) throws InvalidInputException 
    {
        switch(status) 
        {
            case "Approved": //Approved
            case "Provisional": // Provisional 
            case "Withdrawn": // WithDrawn
                this.status = status;
                break;
            default:
                throw new InvalidInputException("Only Select \"Approved\", \"Provisional\", \"Withdrawn\" ");
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
    

    public Date getLastUpdated() 
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) 
    {
        this.lastUpdated = lastUpdated;
    }
    
    
    public Users getAppliedStudent() 
    {
        return appliedStudent;
    }

    public void setAppliedStudent(Users appliedStudent) 
    {
        this.appliedStudent = appliedStudent;
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
        if (!(object instanceof Project)) 
        {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "zain.project.entitites.Project[ id=" + id + " ]";
    }
    
}

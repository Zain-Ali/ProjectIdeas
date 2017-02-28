/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.entitites;

import zain.project.entitites.exceptions.InvalidInputException;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String title;
    private String languages;    
    private String projectOwner;
    private String aimsAndObjectives;
    private String academicQuestionsToBeAnswered;
    private String anticipatedDeliverables;
    private String studentForWhoProjectHasBeenDevised;
    //private User user;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
    
    
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
    
    
        public String getProjectOwner() 
    {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) 
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
    

    public Date getLastUpdated() 
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) 
    {
        this.lastUpdated = lastUpdated;
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

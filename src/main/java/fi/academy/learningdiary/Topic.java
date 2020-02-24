package fi.academy.learningdiary;

import org.hibernate.type.ShortType;
import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;

import javax.persistence.*;


import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "topic_id_seq")
    @SequenceGenerator(name = "topic_id_seq",
            sequenceName = "topic_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String title;
    private String description;
    private String additionalsource;
    private boolean complete;
    private Date creationdate;
    private Date completiondate;

    public Topic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalsource() {
        return additionalsource;
    }

    public void setAdditionalsource(String additionalsource) {
        this.additionalsource = additionalsource;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", additionalsource='" + additionalsource + '\'' +
                ", complete=" + complete +
                ", creationdate=" + creationdate +
                ", completiondate=" + completiondate +
                '}';
    }
}

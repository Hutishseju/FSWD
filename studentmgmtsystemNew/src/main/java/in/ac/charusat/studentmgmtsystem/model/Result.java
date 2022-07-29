package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {

    @Id
    private Integer id;
    private String title;
    private String description;

    public Result(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Result() {

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
}


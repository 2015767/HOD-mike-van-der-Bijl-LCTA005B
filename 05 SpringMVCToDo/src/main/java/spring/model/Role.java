package spring.model;

import java.io.Serializable;
import javax.validation.constraints.Size;

public class Role implements Serializable {

    private long id;
    @Size(min = 3, max = 16, message = "Name must be between 3 and 16 characters long.")
    private String name;

    // constructors 
    public Role() {
        this.setId(System.nanoTime());
    }

    public Role(long id, String name) {

        this.setId(id);
        this.setName(name);

    }

    // getters and setters  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package ads.seg;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formulario {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
}

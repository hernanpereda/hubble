package hubble.springframework.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Person {

    @ApiModelProperty(notes = "Person name")
    private String name;
    @ApiModelProperty(notes = "Person last name")
    private String lastName;
    @ApiModelProperty(notes = "Person age")
    private int age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(notes = "Birth date", example = "03-05-1988")
    private Date birthDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(notes = "Probability kill date", example = "03-05-2038")
    private Date killDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getKillDate() {
        return killDate;
    }

    public void setKillDate(Date killDate) {
        this.killDate = killDate;
    }
}

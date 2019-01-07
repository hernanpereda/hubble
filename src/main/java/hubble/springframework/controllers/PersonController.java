package hubble.springframework.controllers;

import hubble.springframework.domain.Person;
import hubble.springframework.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Api(value="person data", description="Person's operation")
public class PersonController {


    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "View a list of person",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Person> list(Model model){
        Iterable<Person> personList = personService.getPersonList();
        return personList;
    }

    @ApiOperation(value = "Get average age",response = int.class)
    @RequestMapping(value = "/average/age", method= RequestMethod.GET, produces = "application/json")
    public int averageAge(){
        return personService.getAverageAge();
    }

    @ApiOperation(value = "Add a person")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity savePerson(@RequestBody Person person){
        personService.savePerson(person);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Clean person's data",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully clean data")
    }
    )
    @RequestMapping(value = "/clean", method= RequestMethod.DELETE, produces = "application/json")
    public void clean(Model model){
        personService.deleteData();
    }

}

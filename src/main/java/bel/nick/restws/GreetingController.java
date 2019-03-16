/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bel.nick.restws;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author nikolaos
 */
@RestController
//@RequestMapping("/greetings")
public class GreetingController {

    private List<Greeting> greetings;
    private Integer autoId;
    
    public GreetingController() {
        this.greetings = new ArrayList();
        autoId = 0;
        //greetings.add(new Greeting(0L, "Hello World"));
    }

    @GetMapping("/greetings/")
    public List<Greeting> list() {
        return greetings;
    }

    @GetMapping("/greetings/{id}")
    public Greeting get(@PathVariable long id) {
        Greeting greeting = new Greeting();
        for(Greeting gr: greetings){
            if(gr.getId() == id){
                greeting = gr;
                break;
            }
        } 
        return greeting;
    }

    @PutMapping("/greetings/{id}")
    public ResponseEntity<String> put(@PathVariable long id, @RequestBody Greeting updatedGreeting) {
        // The body @RequestBody String content comes as data from a jquery $.ajax call
        //System.out.println(updatedGreeting);
        for(Greeting gr: greetings){
            if(gr.getId() == id){
                gr.setContent(updatedGreeting.getContent());
                gr.setImage(updatedGreeting.getImage());
                break;
            }
        } 
        return new ResponseEntity<>("Greeting updated succesfully", HttpStatus.OK);
    }

    @PostMapping("/greetings")
    public ResponseEntity<?> post(@RequestBody Greeting greeting) {
        // The body @RequestBody Greeting greeting comes as data from a jquery $.ajax call
        //System.out.println(greeting);
        greeting.setId((long)++autoId);
        greetings.add(greeting);
        return new ResponseEntity<>("New Greeting added as body", HttpStatus.OK);
    }

    @DeleteMapping("/greetings/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Greeting greeting = new Greeting();
        for(Greeting gr: greetings){
            if(gr.getId() == id){
                greeting = gr;
                break;
            }
        } 
        greetings.remove(greeting);
        return new ResponseEntity<>("Selected Greeting removed", HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}

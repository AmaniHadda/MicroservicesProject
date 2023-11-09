package tn.esprit.CoachProjet.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Coach")
public class CoachController {
    @Autowired
    CoachService coachService;
    @GetMapping("/hello")
    public  String sayHello(){
        System.out.println("baher");
        return "baher";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        return new ResponseEntity<>(coachService.addCoach(coach), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Coach> updateMember(@RequestBody Coach coach) {
        return new ResponseEntity<>(coachService.updateCoach(coach), HttpStatus.OK);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Coach>> getAllMembers() {
        return new ResponseEntity<>(coachService.retrieveAllCoachs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getOneMember(@PathVariable(value="id") Integer id) {
        return new ResponseEntity<>(coachService.retrieveCoach(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable(value="id") Integer id) {
        coachService.deleteCoach(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

package tn.esprit.MembreProjet.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/Member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/hello")
    public  String sayHello(){
        System.out.println("amani");
        return "amani";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addMember(member), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.updateMember(member), HttpStatus.OK);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Member>> getAllMembers() {
        return new ResponseEntity<>(memberService.retrieveAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getOneMember(@PathVariable(value="id") Integer id) {
        return new ResponseEntity<>(memberService.retrieveMember(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable(value="id") Integer id) {
        memberService.deleteMember(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

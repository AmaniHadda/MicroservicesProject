package tn.esprit.CoachProjet.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    @Autowired
    CoachRepository coachRepository;

    public List<Coach> retrieveAllCoachs() {
        return coachRepository.findAll();
    }

    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteCoach(Integer id) {
        coachRepository.deleteById(id);
    }

    public Coach updateCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach retrieveCoach(Integer id) {
        return coachRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
    }


}

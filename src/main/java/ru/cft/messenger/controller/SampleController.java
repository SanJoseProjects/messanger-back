package ru.cft.messenger.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.messenger.repository.model.Users;
import ru.cft.messenger.service.SampleService;
import java.util.List;

@RestController
@RequestMapping("api")
@Tag(name="Users", description="Interact with user profile")
public class SampleController {
    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @GetMapping("/users/get/all")
    public List<Users> getAll() {
        return sampleService.getAllSample();
    }

    @GetMapping("/user/get/by_login/{login}")
    public Users getUserByLogin(@PathVariable("login") String login) { return sampleService.findByLogin(login); }

    @GetMapping("/users/get/by_name/{name}")
    public List<Users> getUserByName(@PathVariable("name") String name) { return sampleService.findByName(name); }

    @GetMapping("/user/get/by_id/{id}")
    public Users getUserById(@PathVariable("id") Long userId) { return sampleService.findById(userId); }
}

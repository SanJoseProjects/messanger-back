package ru.cft.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import ru.cft.messenger.repository.model.User;
import ru.cft.messenger.service.SampleService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api")
public class SampleController {
    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @GetMapping("/get/all")
    public List<User> getAll() {
        return sampleService.getAllSample();
    }


}

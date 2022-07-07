package ru.cft.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.messenger.repository.model.SampleEntity;
import ru.cft.messenger.service.SampleService;

import java.util.List;

@RestController
@RequestMapping("api")
public class SampleController {

    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @GetMapping("/get/all")
    public List<SampleEntity> getAll() {
        return sampleService.getAllSample();
    }


}

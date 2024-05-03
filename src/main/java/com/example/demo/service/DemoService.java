package com.example.demo.service;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cat;

@Service
public class DemoService {

    private KieServices kieServices = KieServices.Factory.get();

    public void process(Cat cat) {
        System.out.println("Data: " + cat);
        kieServices.newKieBuilder(getKieFileSystem()).buildAll();
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(cat);
        kieSession.fireAllRules();
    }

    public KieFileSystem getKieFileSystem() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("cat_rule.drl"));
        return kieFileSystem;
    }
}

package com.theerakan.earnexpspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:images/doh.png");
        System.out.println(resource.getURI());
    }
}

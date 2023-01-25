package com.theerakan.earnexpspring.step;

import com.theerakan.earnexpspring.service.FileService;
import com.theerakan.earnexpspring.service.FileServiceImpl;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

public class Writer implements ItemWriter<String> {

//    private String PATH_IMG = "classpath:images/doh.png";

    @Override
    public void write(List <? extends String> messages) throws Exception {
        FileService fileService = new FileServiceImpl();
        fileService.testFile();
        for(String msg: messages){
            System.out.println("Writing the data " + msg);
        }
    }
}

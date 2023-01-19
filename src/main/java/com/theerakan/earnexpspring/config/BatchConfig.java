package com.theerakan.earnexpspring.config;

import com.theerakan.earnexpspring.listener.JobCompletionListener;
import com.theerakan.earnexpspring.step.Processor;
import com.theerakan.earnexpspring.step.Reader;
import com.theerakan.earnexpspring.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean(name = "processJob")
    public Job processJob(){
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end().build();
    }

    @Bean(name = "orderStep1")
    public Step orderStep1(){
        return stepBuilderFactory.get("orderStep1").<String,String> chunk(1)
                .reader(new Reader()).processor(new Processor())
                .writer(new Writer()).build();
    }

    @Bean
    public JobExecutionListener listener(){
        return new JobCompletionListener();
    }

}

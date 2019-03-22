/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fop.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fop.batch.model.Product;
import com.fop.batch.processor.JobCompletionNotificationListener;
import com.fop.batch.processor.ProductItemProcessor;
import com.fop.batch.reader.RESTProductReader;
import com.fop.batch.reader.RESTProductWriter;

/**
 * Configuration of the spring batch.
 * 
 * @author Alexandre Sousa(abdesousa@gmail.com)
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	public static String JOB_NAME = "fop-batch";


	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;


	@Bean
	public ProductItemProcessor processor() {
		return new ProductItemProcessor();
	}

	@Bean
	public ItemReader<Product> reader() {
		return new RESTProductReader();
	}
	
	@Bean
	public ItemWriter<Product> writer() {
		return new RESTProductWriter();
	}
	
	@Bean
	public Job fopJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get(JOB_NAME).incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
				.end().build();
	}

	@Bean
	public Step step1(ItemWriter<Product> writer) {
		return stepBuilderFactory.get("step1").<Product, Product>chunk(1).reader(reader()).processor(processor())
				.writer(writer).build();
	}

}
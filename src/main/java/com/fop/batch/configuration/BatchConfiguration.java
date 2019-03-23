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

import com.fop.batch.configuration.steps.listener.JobCompletionNotificationListener;
import com.fop.batch.configuration.steps.reader.OrderItemReader;
import com.fop.batch.configuration.steps.reader.ProductItemReader;
import com.fop.batch.configuration.steps.writer.OrderItemWriter;
import com.fop.batch.configuration.steps.writer.ProductItemWriter;
import com.fop.batch.model.Order;
import com.fop.batch.model.Product;

/**
 * Configuration of the spring batch.
 * Here are the configuration of the steps of this job process.
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

	// readers and writer.
	@Bean
	public ItemReader<Product> reader() {
		return new ProductItemReader();
	}

	@Bean
	public ItemWriter<Product> writer() {
		return new ProductItemWriter();
	}

	@Bean
	public ItemReader<Order> orderReader() {
		return new OrderItemReader();
	}

	@Bean
	public ItemWriter<Order> orderWriter() {
		return new OrderItemWriter();
	}

	@Bean
	public Job fopJob(JobCompletionNotificationListener listener, Step stepUpdateInventory, Step stepUpdateOrderItemStatus) {
		return jobBuilderFactory.get(JOB_NAME)
					.incrementer(new RunIdIncrementer())
					.listener(listener)
					.start(stepUpdateInventory)
					.next(stepUpdateOrderItemStatus)
					.build();
	}

	// steps.
	
	// Consumes all products for a given brand*2, recording the inventory levels for each product option
	@Bean
	public Step stepUpdateInventory(ItemWriter<Product> writer) {
		return stepBuilderFactory.get("stepUpdateInventory").<Product, Product>chunk(1).reader(reader()).writer(writer)
				.build();
	}

	
	 // Consumes all orders, accepting the order if there is inventory to fulfill the
	 // order and it is not already accepted, otherwise it marks the items that don’t
	 // have enough inventory as backordered
	@Bean
	public Step stepUpdateOrderItemStatus(ItemWriter<Product> writer) {
		return stepBuilderFactory.get("stepUpdateOrderItemStatus").<Order, Order>chunk(1).reader(orderReader())
				.writer(orderWriter()).build();
	}

}
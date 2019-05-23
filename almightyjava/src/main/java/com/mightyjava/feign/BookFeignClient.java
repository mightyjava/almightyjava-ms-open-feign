package com.mightyjava.feign;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mightyjava.dto.Book;
import com.mightyjava.utils.ConstantUtils;

@FeignClient(value = "book-rest-api", url = ConstantUtils.BOOK_REST_URL)
public interface BookFeignClient {

	@GetMapping
	ResponseEntity<Collection<Book>> bookList();

	@GetMapping("/{id}")
	ResponseEntity<Book> bookOne(@PathVariable("id") Long id);

	@PostMapping
	ResponseEntity<Book> bookAdd(@RequestBody Book book);

	@PutMapping
	ResponseEntity<Book> bookUpdate(@RequestBody Book book);

	@DeleteMapping("/{id}")
	ResponseEntity<Book> bookDelete(@PathVariable("id") Long id);
}

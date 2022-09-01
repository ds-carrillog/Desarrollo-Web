package com.cutebooks.prototype.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cutebooks.prototype.domain.Book;



@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

    Book findByisbn(String isbn);
    
}

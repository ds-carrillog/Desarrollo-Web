import { Injectable } from '@angular/core';
import { Book } from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor() { }


  private bookDB = {
    1: new Book(1, 'Book100', 'isbn1', 'author1, author2'),
    2: new Book(2, 'Book101', 'isbn2', 'author3, author4'),
    3: new Book(3, 'Book102', 'isbn3', 'author5, author6'),
  };

  get books() {
    return Object.values(this.bookDB);
  }
}
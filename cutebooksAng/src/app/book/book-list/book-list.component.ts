import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  @Output()
  selectionChanged = new EventEmitter<boolean[]>();

  selection: boolean[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit(): void { }

  get books() {
    return this.bookService.books;
  }

  onSelectBook() {
    this.selectionChanged.emit(this.selection);
  }
}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Book } from 'src/app/model/book';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit {

  @Input()
  book: Book | null = null;

  @Output()
  nameClicked = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    this.nameClicked.emit(this.book?.title);
  }

}
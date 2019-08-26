import { ServiceService } from './../service.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
  bookForm : FormGroup;
  bookList :Book[];

  constructor(private bookService: ServiceService, private fb:FormBuilder) { }

  ngOnInit() {
    this.bookForm = this.fb.group({
      id:[''],
      title: [''],
      price: [''],
      published: [''],
      firstname:[''],
     
    })
  }

  createBook(){
    const book:Book = this.bookForm.value;
    book.id = null;
    console.log(book);
    this.bookService.createBook(book).subscribe(book => this.bookList.push(book));
  }

}

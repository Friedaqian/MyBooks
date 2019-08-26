import { ServiceService } from './../service.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  bookList: Book[];
  bookForm : FormGroup;
 


  constructor(private bookService: ServiceService,private fb:FormBuilder) {}

  ngOnInit() {

    this.bookForm = this.fb.group({
      id:[''],
      title: [''],
      price: [''],
      published: [''],
      firstname:[''],
      lastname:[''],
      imgUrl:[''],
     
    })

  
    //this.bookList = this.bookService.getBookList();
    this.bookService.getBookList().subscribe(books=>(this.bookList=books));
  }

  deleteBookById(id:number){
      this.bookService
      .deleteBookById(id)
      .subscribe(book=>
        (this.bookList.filter(
          bookEntry => bookEntry.id !=book.id,)),
          );
    }

    createBook(){
      const book:Book = this.bookForm.value;
      book.id = null;
      console.log(book);
      this.bookService.createBook(book).subscribe(book => this.bookList.push(book));
    }
  

   
}

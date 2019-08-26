import { ServiceService } from './../service.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deteil',
  templateUrl: './deteil.component.html',
  styleUrls: ['./deteil.component.css']
})
export class DeteilComponent implements OnInit {

  book: Book;
  autor: Autor;
 
  constructor(private bookDeteilService: ServiceService, private autorDeteilService: ServiceService, private route: ActivatedRoute) {}

  ngOnInit() {
   const id= +this.route.snapshot.paramMap.get('bookid');
    this.bookDeteilService.getBookById(id).subscribe(book=>(this.book=book));
   
    //this.book = this.bookDeteilService.getBookDeteil(id);
   // console.log(this.book)
  }

}

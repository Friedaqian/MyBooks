import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

 
  // bookList : Book[]=[
  //   {titel:"Was ist das",id:12345, price:11.9,published: new Date()},
  //   {titel:"Descovery",id:12344,price:11.9,published: new Date('1990-09-09')},
  //   {titel:"My Love",id:12346,price:22.9,published: new Date('1989-12-09')}
  // ]; 

  constructor(private http: HttpClient) { }

  getBookList(){
    //return this.bookList;
    return this.http.get<Book[]>('http://localhost:8080/api/books');
  }

  //getBookDeteil(id:number){
    //id hier als Parament ist ungleich wie book.id, hier ist eigentlich ein Index von Array!!!
    //Deswegen muss man unter find() anwenden!!!
    //return this.bookList.find(book => book.id == id)

  getBookById(id:number) : Observable<Book>{
      return this.http.get<Book>("http://localhost:8080/api/books/" + id);
  }//last "/"!!! sonst bei Console immer Fehler Cannot read property
  
  getAutorList(){
    //return this.bookList;
    return this.http.get<Autor[]>('http://localhost:8080/api/autors');
  }
  getAutorById(id :number){
    return this.http.get<Autor>("http://localhost:8080/api/autors/" + id);
  }

  deleteBookById(id:number):Observable<Book>{
    return this.http.delete<Book>("http://localhost:8080/api/books/" + id);
  }

  createBook(book :Book){
    const httpOptions = {
      headers : new HttpHeaders({'Content-type':'application/json'}),
   };
   
    return this.http.post<Book>("http://localhost:8080/api/books", book, httpOptions);
 }

}

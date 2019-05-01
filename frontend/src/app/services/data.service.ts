import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Post} from '../models/post.model';
import {Injectable} from '@angular/core';
import {delay, retry, catchError} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';

@Injectable()
export class DataService {
  url: string;

  constructor(private httpClient: HttpClient) {
    // this.url = 'http://172.20.162.155:8080';
    this.url = 'http://10.250.241.79:8080';
    // this.url = 'https://jsonplaceholder.typicode.com/posts';
  }

  // getAllPosts() {
  //     return this.httpClient.get<Array<Post>>(this.url);
  // }

  getAllPanels() {
    return this.httpClient.get(this.url + '/panels').pipe(
      // delay(5000),
      retry(3),
      catchError(this.handleError<Array<any>>('getAllPanels'))
    );
  }

  getUserPassword() {
    return this.httpClient.get(this.url + '/users').pipe(
      // delay(5000),
      retry(3),
      catchError(this.handleError<Array<any>>('getUserPassword'))
    );
  }

  postUserPassword(user, pass) {
    console.log(user, pass);
    this.httpClient.post(this.url + '/users',
      {
        "username": user,
        "password": pass
      })
      .subscribe(
        data => {
          console.log('POST Request is successful ', data);
        },
        error => {
          console.log('Error', error);
        }
      );
  }

  getGreeting() {
    this.httpClient.get(this.url).subscribe((res) => {
      return res;
    });
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: HttpErrorResponse): Observable<T> => {
      // Error Logging
      console.log(`${operation} failed: ${error.message}`);

      return throwError('Connection Error, please try again later');
    };
  }
}

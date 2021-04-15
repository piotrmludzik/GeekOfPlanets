import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

// TODO: check if needed
@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  executeGameService(){
    const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'}), withCredentials: true};
    return this.http.get<any>('http://localhost:8080/secured', httpOptions);
  }
}

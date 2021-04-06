import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Message } from '../model/message';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  executeGameService(){
    return this.http.get<any>('http://localhost:8080/secured', { withCredentials: true });
  }
}

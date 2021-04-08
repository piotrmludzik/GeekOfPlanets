import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http: HttpClient) { }
    executeLogoutService(): any {
      const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'}), withCredentials: true};
      return this.http.get<any>('http://localhost:8080/logout', httpOptions);
    }
}

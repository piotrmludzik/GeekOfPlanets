import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpRequest} from '@angular/common/http';
import { map } from 'rxjs/operators';
import {WebsocketService} from '../../services/websocket.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  public username: string;
  public password: string;

  constructor(private http: HttpClient, private websocket: WebsocketService) { }

  // tslint:disable-next-line:typedef
  authenticationService(username: string, password: string) {
    const body = `{"username":"${username}","password":"${password}"}`;
    const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json', Origin: 'http://localhost:4200'}),
      withCredentials: true};
    return this.http.post(`http://localhost:8080/login`,
      body, httpOptions).pipe(map((res) => {
      this.username = username;
      this.password = password;
      this.registerSuccessfulLogin(username, password);
    }));
  }
  createBasicAuthToken(username: string, password: string): string{
    return 'username  password';
  }
  registerSuccessfulLogin(username, password): void{
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
    this.websocket.connect();
  }
  logout(): void {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.websocket.disconnect();
    this.username = null;
    this.password = null;
  }
  isUserLoggedIn(): boolean {
    const user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    return user !== null;
  }
  getLoggedInUSerName(): string {
    const user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null ) { return ''; }
    return user;
  }
}

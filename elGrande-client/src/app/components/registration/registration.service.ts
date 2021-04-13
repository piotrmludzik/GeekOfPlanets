import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {User} from '../../model/user';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';



@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient,
              private snackbarService: SnackbarService) { }


  // tslint:disable-next-line:typedef
  registerNewUser(user: User): any {
    const body = `{"username":"${user.username}",
      "password":"${user.password}"}`;
    // tslint:disable-next-line:max-line-length
    const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json', Origin: 'http://localhost:4200'}),
      withCredentials: true};
    return this.http.post(`http://localhost:8080/register`, // TODO change server api endpoint for registration
      body, httpOptions).pipe(map((res) => {
      this.registerSuccessful();
    }));
  }
  registerSuccessful(): void{
    this.snackbarService.show('You have been registered successfully');
  }

}

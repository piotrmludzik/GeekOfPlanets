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

  registerNewUser(user: User): any {
    const body = `{"username":"${user.username}",
      "password":"${user.password}"}`;
    const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json', Origin: 'http://localhost:4200'}),
      withCredentials: true};
    console.log('Register initialized');
    return this.http.post<any>(`http://localhost:8080/register`, body, httpOptions).subscribe(((res) => {
      console.log('Register successful');
      this.registerSuccessful();
    }));
  }

  registerSuccessful(): void{
    this.snackbarService.show('You have been registered successfully');
  }

}

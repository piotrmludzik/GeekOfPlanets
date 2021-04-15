import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {User} from '../../model/user';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';
import {ActivatedRoute, Router} from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient,
              private snackbarService: SnackbarService,
              private route: ActivatedRoute,
              private router: Router,
              ) { }

  registerNewUser(user: User): any {
    const body = `{"username":"${user.username}", "password":"${user.password}"}`;
    const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json', Origin: 'http://localhost:4200'}),
      withCredentials: true};
    console.log('Register initialized');
    return this.http.post<any>(`http://localhost:8080/register`, body, httpOptions).subscribe((res) => {
      console.log('Register successful'); // TODO: catch error if username already exist
      this.router.navigate(['/login']).then(() => {
        this.registerSuccessful();
      });
    }, () => {
        this.snackbarService.show('Username already exist', 'danger');
    });
  }

  registerSuccessful(): void{
    this.snackbarService.show('You have been registered successfully');
  }

}

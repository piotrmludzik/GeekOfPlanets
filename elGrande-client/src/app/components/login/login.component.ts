import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService} from './auth.service';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  errorMessage: string;
  successMessage: string;
  invalidLogin: boolean;
  loginSuccess: boolean;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private snackbarService: SnackbarService) { }


  ngOnInit(): void {

  }
  handleLogin(): void {
    this.authenticationService.authenticationService(this.username, this.password).subscribe(
      (result) => {
        this.invalidLogin = false;
        this.loginSuccess = true;
        this.successMessage = 'Success! Login successful';
        this.router.navigate(['/game']).then(r => {
          this.snackbarService.show('Login success!');
        });
      }, () => {
        this.invalidLogin = true;
        this.loginSuccess = false;
        this.errorMessage = 'Bad credentials, please enter valid username and password';
        this.snackbarService.show('Bad credentials, please enter valid username and password', 'danger');
      });
  }
}

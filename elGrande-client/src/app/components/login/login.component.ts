import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService} from './auth.service';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';
import {User} from '../../model/user';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User();
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
    this.authenticationService.authenticationService(this.user.username, this.user.password).subscribe(
      (data) => {
        this.invalidLogin = false;
        this.loginSuccess = true;
        this.router.navigate(['/game']).then(r => {
          this.snackbarService.show('Login success!');
        });
      }, () => {
        this.invalidLogin = true;
        this.loginSuccess = false;
        this.snackbarService.show('Bad credentials, please enter valid username and password', 'danger');
      });
  }
}

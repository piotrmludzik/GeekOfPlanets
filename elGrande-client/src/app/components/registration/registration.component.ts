import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../login/auth.service';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';
import {User} from '../../model/user';
import {RegistrationService} from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user = new User();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private registrationService: RegistrationService) { }

  ngOnInit(): void {
  }

  handRegistration(): void {
    this.registrationService.registerNewUser(this.user);
  }
}

import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LogoutService} from './logout.service';
import {SnackbarService} from '../shared/snack-bar/snackbar.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private logoutService: LogoutService,
              private snackbarService: SnackbarService )  { }

  ngOnInit(): void {
    this.logoutService.executeLogoutService().subscribe((res) => {
      this.snackbarService.show('You have been successfully logged out.');
      this.router.navigate(['login']);
    });

    // setTimeout(() => {
    //   this.router.navigate(['login']);
    // }, 1500);
  }

}

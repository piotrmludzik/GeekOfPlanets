import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../login/auth.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  welcomeMessage = 'Test';
  loggedUserName: string;
  isLoggedIn: boolean;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
  }

  handleLogout(): void {
    this.authenticationService.logout();
  }
  getLoggedInUSerName(): any {
    return this.authenticationService.getLoggedInUSerName();
  }

}

import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LogoutService} from './logout.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private logoutService: LogoutService)  { }

  ngOnInit(): void {
    this.logoutService.executeLogoutService().subscribe((res) => {
      console.log("Successfully logout")
    });
  }

}

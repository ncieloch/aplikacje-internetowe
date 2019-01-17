import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';
import {Router} from '@angular/router';
import {UserAccountService} from '../service/user-account.service';
import {UserAccount} from '../model/user-account';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userAccount: UserAccount;

  constructor(private authService: AuthenticationService,
              private router: Router,
              private userAccountService: UserAccountService) { }

  ngOnInit() {
    this.userAccountService.getLoggedUser().subscribe(data => {
      this.userAccount = data;
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}

import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
  returnUrl: string;

  constructor(private authService: AuthenticationService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.router.navigate([this.returnUrl]);
  }

  login() {
    this.authService.login(this.model.username, this.model.password).subscribe(data => {
        this.router.navigate([this.returnUrl]);
      });
  }

}

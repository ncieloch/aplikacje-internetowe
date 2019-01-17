import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppComponent} from '../app.component';
import {Observable} from 'rxjs';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) {
  }

  getLoggedUser(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/users/logged-user', this.authenticationService.jwt());
  }

}

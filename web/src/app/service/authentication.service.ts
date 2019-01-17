import {Injectable} from '@angular/core';
import {AppComponent} from '../app.component';
import {Http} from '@angular/http';
import {HttpClient, HttpHeaderResponse, HttpHeaders, HttpResponse} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post(AppComponent.API_URL + '/login', {username: username, passwd: password},
      {responseType: 'text', observe: 'response'})
      .pipe(map((response: HttpResponse<string>) => {
          // login successful if there's a jwt token in the response
          let user = response.headers.get('Authorization');
          if (user) {
            // store user details and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('currentUser', JSON.stringify(user));
          }
        }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

  // helper method
  jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser) {
      let headers = new HttpHeaders({'Authorization': currentUser});
      return {headers: headers};
    }
  }

}

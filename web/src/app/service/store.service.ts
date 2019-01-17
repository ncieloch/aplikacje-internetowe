import { Injectable } from '@angular/core';
import {AuthenticationService} from './authentication.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private http: HttpClient,
            private authenticationService: AuthenticationService) {
  }

  getAll(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/stores', this.authenticationService.jwt());
  }

}

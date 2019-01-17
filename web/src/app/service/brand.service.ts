import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';
import {AppComponent} from '../app.component';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) { }

  getAll(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/brands', this.authenticationService.jwt());
  }

  getById(id): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/brands/' + id, this.authenticationService.jwt());
  }

}

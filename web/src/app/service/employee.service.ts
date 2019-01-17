import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Employee} from '../model/employee';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) { }

  create(employee: Employee): Observable<any> {
    return this.http.post(AppComponent.API_URL + '/employees', employee, this.authenticationService.jwt());
  }

  getAll(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/employees', this.authenticationService.jwt());
  }

  update(employee: Employee): Observable<any> {
    return this.http.put(AppComponent.API_URL + '/employees', employee, this.authenticationService.jwt());
  }

  getById(id): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/employees/' + id, this.authenticationService.jwt());
  }

}

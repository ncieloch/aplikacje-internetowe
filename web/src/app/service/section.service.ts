import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppComponent} from '../app.component';
import {AuthenticationService} from './authentication.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SectionService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) { }

  getAll(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/sections', this.authenticationService.jwt());
  }

  getById(id): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/sections/' + id, this.authenticationService.jwt());
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';

@Injectable({
  providedIn: 'root'
})
export class StoreReportService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) { }

  getReport(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/store-sales-reports', this.authenticationService.jwt());
  }

}

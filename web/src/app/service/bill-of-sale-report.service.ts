import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthenticationService} from './authentication.service';
import {AppComponent} from '../app.component';

@Injectable({
  providedIn: 'root'
})
export class BillOfSaleReportService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) {
  }

  getReport(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/bill-of-sale-reports', this.authenticationService.jwt());
  }

}
